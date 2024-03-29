package com.example.td2.data.model;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.example.td2.data.database.ItemsTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class DataItem implements Parcelable {
    public static final String TAG = "TAG: DataItem ";
    private String itemID;
    private String itemName;
    private String description;
    private String duration;
    private String after;
    private String deadline;
    private String starts;
    private String finishes;
    private String recycles;
    private String daysICanDoIt;
    private String dateEntered;
    private String earliestTimeOfDay;
    private String latestTimeOfDay;
    private String peopleNeeded;
    private int subjectivePriority;
    private int category;
    private int location;
    private int weather;
    private int benefit;
    private int consequence;
    private int WorkLoadAnalysis;
    private int sortPosition;
    private double CalculatedPriority;

    public DataItem(List<String> titles, String lineFromFile) {
        //Log.i(TAG, "Starting initializer from lineFromFile");
        //Log.i(TAG, "Received Titles: " + titles.toString());
        //Log.i(TAG, "Received lineFromFile: " + lineFromFile);
        String DES = "Description", PRI = "PRI", DUR = "DUR", AFT = "After",
                DDL = "Deadline", REC = "REC", DAY = "Days", TYP = "TYP",
                ENT = "Entered", LOC = "LOC", WEA = "WEA", EAR = "EAR",
                LAT = "LAT", BEN = "BEN", CON = "CON", WLA = "WLA";

        String[] fields = {PRI, DES, DUR, AFT, DDL, REC, DAY, TYP, ENT, LOC,
                WEA, EAR, LAT, BEN, CON, WLA};

        List<String> requiredFields = Arrays.asList(fields);
        //Log.i(TAG, "ExpectedFields created: " + requiredFields.toString());


        HashMap<String, String> sortedLineFromFile = new HashMap<>();
        Scanner tabScan = null;
        try {
            tabScan = new Scanner(lineFromFile);

            tabScan.useDelimiter(",");
            for (Iterator<String> iterator = titles.iterator();
                 iterator.hasNext(); ) {
                String title = iterator.next();
//                //Log.i(TAG, "title = " + title);
                if (!tabScan.hasNext()) {
                    //Log.i(TAG, "Error tabscan fell short");
                    break;
                }
                String value = null;
                try {
                    value = tabScan.next();
//                    //Log.i(TAG, "value obtained by line scanner: "+value);
                } catch (Exception e) {
                    //Log.i(TAG, "Error getting value from scanner " + e);
                    e.printStackTrace();
                    break;
                }
                if (requiredFields.contains(title)) {
//                    //Log.i(TAG, "Title: in expectedFields " + title);
                    try {
                        sortedLineFromFile.put(String.valueOf(title), String.valueOf(value));
                        //Log.i(TAG, "Put: " + title + ": " + sortedLineFromFile.get(title));
                    } catch (Exception e) {
                        //Log.i(TAG, "Error putting title in sortedLineFromFile " + e);
                        e.printStackTrace();
                    }
//                } else {
//                    //Log.i(TAG, "Title not in expectedFields: " + title + ": " + value);
                }
            }
        } catch (Exception e) {
            //Log.i(TAG, "Couldn't create Scanner");
            e.printStackTrace();
        } finally {
            if (tabScan != null) {
                tabScan.close();
            }
        }

        if (sortedLineFromFile.isEmpty()) {
            //Log.i(TAG, "No line from file");
            return;
        }

        setItemName(sortedLineFromFile.get(DES));
        //Log.i(TAG, "ItemName: " + getItemName());
        setDescription(sortedLineFromFile.get(DES));
        //Log.i(TAG, "Description: " + getDescription());
        setSubjectivePriority(sortedLineFromFile.get(PRI));
        //Log.i(TAG, "SubjectivePriority: " +getSubjectivePriority());
        setCategory(sortedLineFromFile.get(TYP));
        //Log.i(TAG, "Category: " + getCategory());
        setDuration(sortedLineFromFile.get(DUR));
        //Log.i(TAG, "Duration: " + getDuration());
        setAfter(sortedLineFromFile.get(AFT));
        //Log.i(TAG, "After: " + getAfter());
        setDeadline(sortedLineFromFile.get(DDL));
        //Log.i(TAG, "Deadline: " + getDeadline());
        setRecycles(sortedLineFromFile.get(REC));
        //Log.i(TAG, "Recycle: " + getRecycles());
        setDaysICanDoIt(sortedLineFromFile.get(DAY));
        //Log.i(TAG, "Days I can do it: " + getDaysICanDoIt());
        setDateEntered(sortedLineFromFile.get(ENT));
        //Log.i(TAG, "Entry date " + getDateEntered());
        setLocation(sortedLineFromFile.get(LOC));
        //Log.i(TAG, "Location: " + getLocation());
        setWeather(sortedLineFromFile.get(WEA));
        //Log.i(TAG, "Weather: " + getWeather());
        setEarliestTimeOfDay(sortedLineFromFile.get(EAR));
        //Log.i(TAG, "Earliest: " + getEarliestTimeOfDay());
        setLatestTimeOfDay(sortedLineFromFile.get(LAT));
        //Log.i(TAG, "Latest: " + getLatestTimeOfDay());
        setBenefit(sortedLineFromFile.get(BEN));
        //Log.i(TAG, "Benefit: " + getBenefit());
        setConsequence(sortedLineFromFile.get(CON));
        //Log.i(TAG, "Consequency: " + getConsequence());
        setWorkLoadAnalysis(sortedLineFromFile.get(WLA));
        //Log.i(TAG, "WLA: " + getWorkLoadAnalysis());
    }

    private void setWeather(String weather_String) {
        if (weather_String.isEmpty()) {
            weather_String = "0";
        }
        try {
            setLocation(Integer.parseInt(weather_String));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            //Log.i(TAG, "can't parse to weather from string" + weather_String + " for " + itemName);
        }
    }

    private void setLocation(String location_String) {
        if (location_String.isEmpty()) {
            location_String = "0";
        }
        try {
            setLocation(Integer.parseInt(location_String));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            Log.i(TAG, "can't parse to location from string" + location_String + " for " + itemName);
        }
    }

    private void setCategory(String category_String) {
        if (category_String.isEmpty()) {
            category_String = "0";
        }
        try {
            setCategory(Integer.parseInt(category_String));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            Log.i(TAG, "can't parse to category from string" + category_String + " for " + itemName);
        }
    }

    private void setSortPosition(String next) {
        try {
            int localInt = Integer.parseInt(next);
            setSortPosition(localInt);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void setWorkLoadAnalysis(String next) {
        try {
            int localInt = Integer.parseInt(next);
            setWorkLoadAnalysis(localInt);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void setPeopleNeeded(String next) {
        if (this.peopleNeeded == null) {
            this.peopleNeeded = next;
        } else {
            this.peopleNeeded = this.peopleNeeded + ", " + next;
        }
    }

    public String getPeopleNeeded() {
        return peopleNeeded;
    }

    public void setConsequence(String next) {
        try {
            int localInt = Integer.parseInt(next);
            setConsequence(localInt);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void setBenefit(String next) {
        try {
            int localInt = Integer.parseInt(next);
            setBenefit(localInt);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void setSubjectivePriority(String next) {
        try {
            int localInt = Integer.parseInt(next);
            setSubjectivePriority(localInt);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public int getSubjectivePriority() {
        return subjectivePriority;
    }

    public void setSubjectivePriority(int subjectivePriority) {
        this.subjectivePriority = subjectivePriority;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getStarts() {
        return starts;
    }

    public void setStarts(String starts) {
        this.starts = starts;
    }

    public String getFinishes() {
        return finishes;
    }

    public void setFinishes(String finishes) {
        this.finishes = finishes;
    }

    public String getRecycles() {
        return recycles;
    }

    public void setRecycles(String recycles) {
        this.recycles = recycles;
    }

    public String getDaysICanDoIt() {
        return daysICanDoIt;
    }

    public void setDaysICanDoIt(String daysICanDoIt) {
        this.daysICanDoIt = daysICanDoIt;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getWeather() {
        return weather;
    }

    public void setWeather(int weather) {
        this.weather = weather;
    }

    public String getEarliestTimeOfDay() {
        return earliestTimeOfDay;
    }

    public void setEarliestTimeOfDay(String earliestTimeOfDay) {
        this.earliestTimeOfDay = earliestTimeOfDay;
    }

    public String getLatestTimeOfDay() {
        return latestTimeOfDay;
    }

    public void setLatestTimeOfDay(String latestTimeOfDay) {
        this.latestTimeOfDay = latestTimeOfDay;
    }

    public int getBenefit() {
        return benefit;
    }

    public void setBenefit(int benefit) {
        this.benefit = benefit;
    }

    public int getConsequence() {
        return consequence;
    }

    public void setConsequence(int consequence) {
        this.consequence = consequence;
    }

    public int getWorkLoadAnalysis() {
        return WorkLoadAnalysis;
    }

    public void setWorkLoadAnalysis(int workLoadAnalysis) {
        WorkLoadAnalysis = workLoadAnalysis;
    }

    public double getCalculatedPriority() {
        return CalculatedPriority;
    }

    public void setCalculatedPriority(double calculatedPriority) {
        CalculatedPriority = calculatedPriority;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getSortPosition() {
        return sortPosition;
    }

    public void setSortPosition(int sortPosition) {
        this.sortPosition = sortPosition;
    }

    public DataItem() {
    }

    public DataItem(String itemID, String itemName, String description, int subjectivePriority,
                    int category, String duration, String after, String deadline, String starts,
                    String finishes, String recycles, String daysICanDoIt, String entered,
                    int location, int weather, String earliestTimeOfDay, String latestTimeOfDay,
                    int benefit, int consequence, String peopleNeeded, int workLoadAnalysis) {

        if (itemID == null) {
            itemID = UUID.randomUUID().toString();
        }
        this.itemID = itemID;
        this.itemName = itemName;
        this.description = description;
        this.subjectivePriority = subjectivePriority;
        this.category = category;
        this.duration = duration;
        this.after = after;
        this.deadline = deadline;
        this.starts = starts;
        this.finishes = finishes;
        this.recycles = recycles;
        this.daysICanDoIt = daysICanDoIt;
        this.dateEntered = entered;
        this.location = location;
        this.weather = weather;
        this.earliestTimeOfDay = earliestTimeOfDay;
        this.latestTimeOfDay = latestTimeOfDay;
        this.benefit = benefit;
        this.consequence = consequence;
        this.peopleNeeded = peopleNeeded;
        WorkLoadAnalysis = workLoadAnalysis;
    }

    public ContentValues toValues() {
        ContentValues values = new ContentValues(21);
        values.put(ItemsTable.COLUMN_ID, itemID);
        values.put(ItemsTable.COLUMN_NAME, itemName);
        values.put(ItemsTable.COLUMN_DESCRIPTION, description);
        values.put(ItemsTable.COLUMN_DURATION, duration);
        values.put(ItemsTable.COLUMN_AFTER, after);
        values.put(ItemsTable.COLUMN_DEADLINE, deadline);
        values.put(ItemsTable.COLUMN_START, starts);
        values.put(ItemsTable.COLUMN_FINISH, finishes);
        values.put(ItemsTable.COLUMN_RECYCLE, recycles);
        values.put(ItemsTable.COLUMN_VALID_DAYS, daysICanDoIt);
        values.put(ItemsTable.COLUMN_ENTRY_DATE, dateEntered);
        values.put(ItemsTable.COLUMN_EARLIEST_TIME_OF_DAY, earliestTimeOfDay);
        values.put(ItemsTable.COLUMN_LATEST_TIME_OF_DAY, latestTimeOfDay);
        values.put(ItemsTable.COLUMN_SUBJECTIVE_PRIORITY, subjectivePriority);
        values.put(ItemsTable.COLUMN_LOCATION, location);
        values.put(ItemsTable.COLUMN_WEATHER, weather);
        values.put(ItemsTable.COLUMN_CATEGORY, category);
        values.put(ItemsTable.COLUMN_BENEFIT, benefit);
        values.put(ItemsTable.COLUMN_CONSEQUENCES, consequence);
        values.put(ItemsTable.COLUMN_POSITION, sortPosition);
        values.put(ItemsTable.COLUMN_PEOPLE, peopleNeeded);
        return values;
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "itemID='" + itemID + '\'' +
                ", itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", subjectivePriority=" + subjectivePriority + '\'' +
                ", category='" + category + '\'' +
                ", duration='" + duration + '\'' +
                ", after='" + after + '\'' +
                ", deadline='" + deadline + '\'' +
                ", starts='" + starts + '\'' +
                ", finishes='" + finishes + '\'' +
                ", recycles='" + recycles + '\'' +
                ", daysICanDoIt='" + daysICanDoIt + '\'' +
                ", entered='" + dateEntered + '\'' +
                ", location='" + location + '\'' +
                ", weather='" + weather + '\'' +
                ", earliestTimeOfDay='" + earliestTimeOfDay + '\'' +
                ", latestTimeOfDay='" + latestTimeOfDay + '\'' +
                ", benefit=" + benefit + '\'' +
                ", consequence=" + consequence + '\'' +
                ", peopleNeeded=" + peopleNeeded + '\'' +
                ", WorkLoadAnalysis=" + WorkLoadAnalysis + '\'' +
                ", sortPosition=" + sortPosition + '\'' +
                ", CalculatedPriority=" + CalculatedPriority + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.itemID);
        dest.writeString(this.itemName);
        dest.writeString(this.description);
        dest.writeInt(this.subjectivePriority);
        dest.writeInt(this.category);
        dest.writeString(this.duration);
        dest.writeString(this.after);
        dest.writeString(this.deadline);
        dest.writeString(this.starts);
        dest.writeString(this.finishes);
        dest.writeString(this.recycles);
        dest.writeString(this.daysICanDoIt);
        dest.writeString(this.dateEntered);
        dest.writeInt(this.location);
        dest.writeInt(this.weather);
        dest.writeString(this.earliestTimeOfDay);
        dest.writeString(this.latestTimeOfDay);
        dest.writeInt(this.benefit);
        dest.writeInt(this.consequence);
        dest.writeString(this.peopleNeeded);
        dest.writeInt(this.WorkLoadAnalysis);
        dest.writeInt(this.sortPosition);
        dest.writeDouble(this.CalculatedPriority);
    }

    private DataItem(Parcel in) {
        this.itemID = in.readString();
        this.itemName = in.readString();
        this.description = in.readString();
        this.subjectivePriority = in.readInt();
        this.category = in.readInt();
        this.duration = in.readString();
        this.after = in.readString();
        this.deadline = in.readString();
        this.starts = in.readString();
        this.finishes = in.readString();
        this.recycles = in.readString();
        this.daysICanDoIt = in.readString();
        this.dateEntered = in.readString();
        this.location = in.readInt();
        this.weather = in.readInt();
        this.earliestTimeOfDay = in.readString();
        this.latestTimeOfDay = in.readString();
        this.benefit = in.readInt();
        this.consequence = in.readInt();
        this.peopleNeeded = in.readString();
        this.WorkLoadAnalysis = in.readInt();
        this.sortPosition = in.readInt();
        this.CalculatedPriority = in.readDouble();
    }

    public static final Parcelable.Creator<DataItem> CREATOR = new Parcelable.Creator<DataItem>() {
        @Override
        public DataItem createFromParcel(Parcel source) {
            return new DataItem(source);
        }

        @Override
        public DataItem[] newArray(int size) {
            return new DataItem[size];
        }
    };

    public String getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(String dateEntered) {
        this.dateEntered = dateEntered;
    }
}
