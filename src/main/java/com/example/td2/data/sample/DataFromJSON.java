package com.example.td2.data.sample;

import android.content.Context;
import android.util.Log;

import com.example.td2.data.model.DataItem;
import com.example.td2.utils.JSONHelper;

import java.util.ArrayList;
import java.util.List;

public class DataFromJSON {
    public static final String TAG = "TAG:DataFromJason";
    public static List<DataItem> dataItemList = new ArrayList<>();

    public DataFromJSON(Context mContext) {
        dataItemList = JSONHelper.importFromJSON(mContext);
        if(dataItemList !=null)
        {
            for (DataItem dataitem :
                    dataItemList) {
                Log.i(TAG, "onOptionsItemSelected: " + dataitem.getItemName());
            }
        } else{
            Log.i(TAG, "No data items in dataItemList!");
        }
    }
}
