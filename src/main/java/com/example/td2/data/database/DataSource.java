package com.example.td2.data.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.td2.data.model.DataItem;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private static final String TAG = "TAG: DataSource: ";
    private Context mContext;
    private SQLiteDatabase mDatabase;
    SQLiteOpenHelper mDbHelper;

    public DataSource(Context context) {
        this.mContext = context;
        mDbHelper = new DBHelper(mContext);
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void open() {
        mDatabase = mDbHelper.getWritableDatabase();

    }

    public void close() {
        mDbHelper.close();
    }

    public DataItem createItem(DataItem item) {
        ContentValues values = item.toValues();
//        mDatabase.insert(ItemsTable.TABLE_ITEMS, null, values);
        try {
            mDatabase.insertOrThrow(ItemsTable.TABLE_ITEMS, null, values);
        } catch (SQLException e) {
            Log.i(TAG, "insertOrThrow catch: " + e);
            e.printStackTrace();
        }
        return item;
    }

    public long getDataItemsCount() {
        return DatabaseUtils.queryNumEntries(mDatabase, ItemsTable.TABLE_ITEMS);
    }

    public void seedDataBase(List<DataItem> dataItemList) {
        long numItems = getDataItemsCount();
        if (numItems == 0) {
            for (DataItem item : dataItemList) {
                try {
                    createItem(item);
                } catch (SQLiteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<DataItem> getAllItems(String location) {
        String sortOrder = ItemsTable.COLUMN_CONSEQUENCES + ", " + ItemsTable.COLUMN_BENEFIT;
        Cursor cursor=null;
        if (location==String.valueOf(0)){location = null;}
        if (location == null){
            cursor = mDatabase.query(ItemsTable.TABLE_ITEMS, ItemsTable.ALL_COLUMNS,
                    null, null, null, null,
                    sortOrder);
        }else{
            String[] locations = {String.valueOf(0),location};
            cursor = mDatabase.query(ItemsTable.TABLE_ITEMS, ItemsTable.ALL_COLUMNS,
                    ItemsTable.COLUMN_LOCATION+"=?", locations, null, null,
                    sortOrder);
        }
        List<DataItem> dataItems = new ArrayList<>();
        while (cursor.moveToNext()) {
            DataItem item = new DataItem();
            item.setItemID(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_ID)));
            item.setItemName(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_NAME)));
            item.setDescription(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_DESCRIPTION)));
            item.setDuration(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_DURATION)));
            item.setAfter(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_AFTER)));
            item.setDeadline(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_DEADLINE)));
            item.setStarts(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_START)));
            item.setFinishes(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_FINISH)));
            item.setRecycles(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_RECYCLE)));
            item.setDaysICanDoIt(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_VALID_DAYS)));
            item.setDateEntered(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_ENTRY_DATE)));
            item.setEarliestTimeOfDay(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_EARLIEST_TIME_OF_DAY)));
            item.setLatestTimeOfDay(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_LATEST_TIME_OF_DAY)));
            item.setPeopleNeeded(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_PEOPLE)));
            item.setSubjectivePriority(cursor.getInt(cursor.getColumnIndex(ItemsTable.COLUMN_SUBJECTIVE_PRIORITY)));
            item.setCategory(cursor.getInt(cursor.getColumnIndex(ItemsTable.COLUMN_CATEGORY)));
            item.setLocation(cursor.getInt(cursor.getColumnIndex(ItemsTable.COLUMN_LOCATION)));
            item.setWeather(cursor.getInt(cursor.getColumnIndex(ItemsTable.COLUMN_WEATHER)));
            item.setBenefit(cursor.getInt(cursor.getColumnIndex(ItemsTable.COLUMN_BENEFIT)));
            item.setConsequence(cursor.getInt(cursor.getColumnIndex(ItemsTable.COLUMN_CONSEQUENCES)));
            item.setSortPosition(cursor.getInt(cursor.getColumnIndex(ItemsTable.COLUMN_POSITION)));
            item.setCalculatedPriority(cursor.getDouble(cursor.getColumnIndex(ItemsTable.COLUMN_CALCULATED_PRIORITY)));
//            Log.i(TAG, "Item: "+item.toString());
            dataItems.add(item);
        }
        cursor.close();
        return dataItems;
    }
}
