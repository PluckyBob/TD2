package com.example.td2.data.sample;

import android.content.Context;
import android.util.Log;

import com.example.td2.data.model.DataItem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static android.content.Context.*;

public class DataFromCSV {

    public static List<DataItem> dataItemList;
    public static final String TAG = "TAG: DataFromCSV";
    //Could not use Context.getFileDir().getPath on a static context
    //attempted to instantiate but getPath returned an invisible path
    public static final String CSV_FILE = "/data/data/com.example.td2/cache/todo.csv";

    static {
        dataItemList = new ArrayList<>();
//      I might use File file = new File(CSV_FILE) to check file info
//       but for now this will do
        FileReader in = null;
        try {
            in = new FileReader(CSV_FILE);
        } catch (FileNotFoundException e) {
            Log.i(TAG, "File not found" + e);
        }

        String lineFromFile = null;
        BufferedReader bReader = new BufferedReader(in);
//        Obtain the title row
        try {
            lineFromFile = bReader.readLine();
//            Log.i(TAG,lineFromFile);
        } catch (IOException e) {
            Log.i(TAG, "Error obtaining column titles");
            e.printStackTrace();
        }
//        Split the title row into column titles
        ArrayList<String> titles = new ArrayList<>();
        Scanner tabScan = new Scanner(lineFromFile);
        try {
            tabScan.useDelimiter(",");
            while (tabScan.hasNext()) {
                String title = tabScan.next();
                titles.add(title);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (tabScan == null) {
                tabScan.close();
            }
        }
//          Get the data rows and add to the dataItemList list
        while (true) {
            try {
                if (((lineFromFile = bReader.readLine()) == null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            addItem(new DataItem(titles, lineFromFile));
        }
    }

    private static void addItem(DataItem item) {
        dataItemList.add(item);
    }
}


