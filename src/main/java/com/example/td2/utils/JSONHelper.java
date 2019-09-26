package com.example.td2.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.example.td2.R;
import com.example.td2.data.model.DataItem;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class JSONHelper {

    private static final String FILE_NAME = "menuitems.json";
    private static final String TAG = "TAG:JSONHelper";

    public static boolean exportToJSON(Context context, List<DataItem> dataItemList) {

        DataItems menuData = new DataItems();
        menuData.setDataItems(dataItemList);

        Gson gson = new Gson();
        String jsonString = gson.toJson(menuData);
        Log.i(TAG, "Export to JSON " + jsonString);

        FileOutputStream fileOutputStream = null;
        File file = new File(Environment.getExternalStorageDirectory(),FILE_NAME);

        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(jsonString.getBytes());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public static List<DataItem> importFromJSON(Context context) {
        FileReader reader = null;
        try {
//            File file = new File("/sdcard/menuitems.json");
            File file = new File(Environment.getExternalStorageDirectory(),FILE_NAME);
            Log.i(TAG, "file exists = "+ file.exists());
            reader = new FileReader(file);
            Gson gson = new Gson();
            DataItems dataItems = gson.fromJson(reader, DataItems.class);
            return dataItems.getDataItems();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static List<DataItem> importFromResource(Context context) {
        InputStreamReader reader = null;
        InputStream inputStream=null;
        try {
            inputStream = context.getResources().openRawResource(R.raw.menuitems);
            reader = new InputStreamReader(inputStream);
            Gson gson = new Gson();
            DataItems dataItems = gson.fromJson(reader, DataItems.class);
            for (DataItem dataItem : dataItems.getDataItems()) {
                Log.i(TAG, dataItem.toString());
            }

            return dataItems.getDataItems();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class DataItems {
        List<DataItem> dataItems;

        List<DataItem> getDataItems() {
            return dataItems;
        }

        void setDataItems(List<DataItem> dataItems) {
            this.dataItems = dataItems;
        }
    }

}
