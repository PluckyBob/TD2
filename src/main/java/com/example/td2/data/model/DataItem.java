package com.example.td2.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

public class DataItem implements Parcelable {
    private static final String TAG = "TAG: DataItem ";
    private String itemID;
    private String itemName;
    private String description;
    private int subjectivePriority;
    private int category;
    private String duration;
    private String after;
    private String deadline;
    private String starts;
    private String finishes;
    private String recycles;
    private String daysICanDoIt;
    private String entered;
    private int location;
    private int weather;
    private String earliestTimeOfDay;
    private String latestTimeOfDay;
    private int benefit;
    private int consequence;
    private boolean helenNeeded;
    private boolean samNeeded;
    private int WorkLoadAnalysis;
    private int sortPosition;
    private double CalculatedPriority;

    private void setWeather(String weather_String) {
        if (weather_String.isEmpty()) {
            weather_String = "0";
        }
        try {
            setWeather(Integer.parseInt(weather_String));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            Log.i(TAG, "can't parse to weather from string" + weather_String + " for " + itemName);
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

    private void setSamNeeded(String next) {
        try {
            boolean localBool = Boolean.parseBoolean(next);
            setSamNeeded(localBool);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void setHelenNeeded(String next) {
        try {
            boolean localBool = Boolean.parseBoolean(next);
            setHelenNeeded(localBool);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void setConsequence(String next) {
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

    private void setSubjectivePriority(String next) {
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

    private void setSubjectivePriority(int subjectivePriority) {
        this.subjectivePriority = subjectivePriority;
    }

    public String getDuration() {
        return duration;
    }

    private void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAfter() {
        return after;
    }

    private void setAfter(String after) {
        this.after = after;
    }

    public String getDeadline() {
        return deadline;
    }

    private void setDeadline(String deadline) {
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

    private void setRecycles(String recycles) {
        this.recycles = recycles;
    }

    public String getDaysICanDoIt() {
        return daysICanDoIt;
    }

    private void setDaysICanDoIt(String daysICanDoIt) {
        this.daysICanDoIt = daysICanDoIt;
    }

    public String getEntered() {
        return entered;
    }

    private void setEntered(String entered) {
        this.entered = entered;
    }

    public int getLocation() {
        return location;
    }

    private void setLocation(int location) {
        this.location = location;
    }

    public int getWeather() {
        return weather;
    }

    private void setWeather(int weather) {
        this.weather = weather;
    }

    public String getEarliestTimeOfDay() {
        return earliestTimeOfDay;
    }

    private void setEarliestTimeOfDay(String earliestTimeOfDay) {
        this.earliestTimeOfDay = earliestTimeOfDay;
    }

    public String getLatestTimeOfDay() {
        return latestTimeOfDay;
    }

    private void setLatestTimeOfDay(String latestTimeOfDay) {
        this.latestTimeOfDay = latestTimeOfDay;
    }

    public int getBenefit() {
        return benefit;
    }

    private void setBenefit(int benefit) {
        this.benefit = benefit;
    }

    public int getConsequence() {
        return consequence;
    }

    private void setConsequence(int consequence) {
        this.consequence = consequence;
    }

    public boolean isHelenNeeded() {
        return helenNeeded;
    }

    private void setHelenNeeded(boolean helenNeeded) {
        this.helenNeeded = helenNeeded;
    }

    public boolean isSamNeeded() {
        return samNeeded;
    }

    private void setSamNeeded(boolean samNeeded) {
        this.samNeeded = samNeeded;
    }

    public int getWorkLoadAnalysis() {
        return WorkLoadAnalysis;
    }

    private void setWorkLoadAnalysis(int workLoadAnalysis) {
        WorkLoadAnalysis = workLoadAnalysis;
    }

    public double getCalculatedPriority() {
        return CalculatedPriority;
    }

    public void setCalculatedPriority(double calculatedPriority) {
        CalculatedPriority = calculatedPriority;
    }

    public DataItem() {
    }

    public DataItem(String itemID, String itemName, String description, int subjectivePriority,
                    int category, String duration, String after, String deadline, String starts,
                    String finishes, String recycles, String daysICanDoIt, String entered,
                    int location, int weather, String earliestTimeOfDay, String latestTimeOfDay,
                    int benefit, int consequence, boolean helenNeeded, boolean samNeeded,
                    int workLoadAnalysis) {

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
        this.entered = entered;
        this.location = location;
        this.weather = weather;
        this.earliestTimeOfDay = earliestTimeOfDay;
        this.latestTimeOfDay = latestTimeOfDay;
        this.benefit = benefit;
        this.consequence = consequence;
        this.helenNeeded = helenNeeded;
        this.samNeeded = samNeeded;
        WorkLoadAnalysis = workLoadAnalysis;
    }

    public DataItem(List<String> titles, String lineFromFile) {
        String DES = "Description", PRI = "PRI", DUR = "DUR", AFT = "After",
                DDL = "Deadline", REC = "REC", DAY = "Days", TYP = "TYP",
                ENT = "Entered", LOC = "LOC", WEA = "WEA", EAR = "EAR",
                LAT = "LAT", BEN = "BEN", CON = "CON", WLA = "WLA";

        String[] fields = {PRI, DES, DUR, AFT, DDL, REC, DAY, TYP, ENT, LOC,
                WEA, EAR, LAT, BEN, CON, WLA};

        List<String> requiredFields = Arrays.asList(fields);
        HashMap<String, String> sortedLineFromFile = new HashMap<>();
        try (Scanner tabScan = new Scanner(lineFromFile)) {
            tabScan.useDelimiter("\t");
            for (String title : titles) {
                if (!tabScan.hasNext()) {
                    tabScan.close();
                    break;
                }
                String value;
                try {
                    value = tabScan.next();
                    Log.i(TAG, "Value: "+value);
                } catch (Exception e) {
                    Log.i(TAG, "Value not obtained from tabscan.next: "+e);
                    e.printStackTrace();
                    break;
                }
                if (requiredFields.contains(title)) {
                    try {
                        sortedLineFromFile.put(String.valueOf(title), String.valueOf(value));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (sortedLineFromFile.isEmpty()) {
            return;
        }
        if (itemID == null) {
            itemID = UUID.randomUUID().toString();
        }

        itemName = sortedLineFromFile.get(DES);
        description = "TDF " + sortedLineFromFile.get(DES);
        setSubjectivePriority(sortedLineFromFile.get(PRI));
        if (sortedLineFromFile.get(TYP) != null) {
            setCategory(Objects.requireNonNull(sortedLineFromFile.get(TYP)));
        }
        setDuration(sortedLineFromFile.get(DUR));
        setAfter(sortedLineFromFile.get(AFT));
        setDeadline(sortedLineFromFile.get(DDL));
        setRecycles(sortedLineFromFile.get(REC));
        setDaysICanDoIt(sortedLineFromFile.get(DAY));
        setEntered(sortedLineFromFile.get(ENT));
        if (sortedLineFromFile.get(LOC) != null) {
            setLocation(Objects.requireNonNull(sortedLineFromFile.get(LOC)));
        }
        if (sortedLineFromFile.get(WEA) != null) {
            setWeather(Objects.requireNonNull(sortedLineFromFile.get(WEA)));
        }
        setEarliestTimeOfDay(sortedLineFromFile.get(EAR));
        setLatestTimeOfDay(sortedLineFromFile.get(LAT));
        setBenefit(sortedLineFromFile.get(BEN));
        setConsequence(sortedLineFromFile.get(CON));
        setWorkLoadAnalysis(sortedLineFromFile.get(WLA));
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

    private void setCategory(int category) {
        this.category = category;
    }

    public int getSortPosition() {
        return sortPosition;
    }

    private void setSortPosition(int sortPosition) {
        this.sortPosition = sortPosition;
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "itemID='" + itemID + '\'' +
                ", itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", subjectivePriority=" + subjectivePriority +
                ", category='" + category + '\'' +
                ", duration='" + duration + '\'' +
                ", after='" + after + '\'' +
                ", deadline='" + deadline + '\'' +
                ", starts='" + starts + '\'' +
                ", finishes='" + finishes + '\'' +
                ", recycles='" + recycles + '\'' +
                ", daysICanDoIt='" + daysICanDoIt + '\'' +
                ", entered='" + entered + '\'' +
                ", location='" + location + '\'' +
                ", weather='" + weather + '\'' +
                ", earliestTimeOfDay='" + earliestTimeOfDay + '\'' +
                ", latestTimeOfDay='" + latestTimeOfDay + '\'' +
                ", benefit=" + benefit +
                ", consequence=" + consequence +
                ", helenNeeded=" + helenNeeded +
                ", samNeeded=" + samNeeded +
                ", WorkLoadAnalysis=" + WorkLoadAnalysis +
                ", sortPosition=" + sortPosition +
                ", CalculatedPriority=" + CalculatedPriority +
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
        dest.writeString(this.entered);
        dest.writeInt(this.location);
        dest.writeInt(this.weather);
        dest.writeString(this.earliestTimeOfDay);
        dest.writeString(this.latestTimeOfDay);
        dest.writeInt(this.benefit);
        dest.writeInt(this.consequence);
        dest.writeByte(this.helenNeeded ? (byte) 1 : (byte) 0);
        dest.writeByte(this.samNeeded ? (byte) 1 : (byte) 0);
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
        this.entered = in.readString();
        this.location = in.readInt();
        this.weather = in.readInt();
        this.earliestTimeOfDay = in.readString();
        this.latestTimeOfDay = in.readString();
        this.benefit = in.readInt();
        this.consequence = in.readInt();
        this.helenNeeded = in.readByte() != 0;
        this.samNeeded = in.readByte() != 0;
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
}
