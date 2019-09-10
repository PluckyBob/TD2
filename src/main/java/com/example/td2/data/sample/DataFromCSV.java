package com.example.td2.data.sample;

import android.util.Log;

import com.example.td2.data.model.DataItem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataFromCSV {

    public static final List<DataItem> dataItemList;
    public static final String TAG = "TAG: DataFromCSV";

    static {
        Log.i(TAG, "Static initializer begins");
        dataItemList = new ArrayList<>();
        String CSV_FILE = "/data/data/com.example.td2/cache/todo.csv";
//      I might use File file = new File(CSV_FILE) to check file info
//       but for now this will do
        Log.i(TAG, "attempting to create FileReader object");
        FileReader in = null;
        try {
            in = new FileReader(CSV_FILE);
        } catch (FileNotFoundException e) {
            Log.i(TAG, "File not found" + e);
        }

        String lineFromFile = null;
        DataItem dataItem;
        ArrayList<DataItem> dataItems = new ArrayList<>();
        Log.i(TAG, "FileReader object created - creating buffered reader");
        BufferedReader bReader = new BufferedReader(in);
//        Obtain the title row
        try {
            lineFromFile = bReader.readLine();
            Log.i(TAG,lineFromFile);
        } catch (IOException e) {
            Log.i(TAG,"Error obtaining column titles");
            e.printStackTrace();
        }
//        Split the title row into column titles
        Scanner tabScan = new Scanner(lineFromFile);
        tabScan.useDelimiter(",");
        ArrayList<String> titles = new ArrayList<>();
        while (tabScan.hasNext()) {
            String title = tabScan.next();
            titles.add(title);
        }
//          Get the data rows and add to the dataItems list
        while (true) {
            try {
                if (((lineFromFile = bReader.readLine()) == null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.i(TAG,lineFromFile);
            Log.i(TAG,"Attempt to create new DataItem from lineFromFile");
            dataItem = new DataItem(titles, lineFromFile);
            Log.i(TAG, "Data Item: " +dataItem.toString());
            try {
                dataItems.add(dataItem);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


