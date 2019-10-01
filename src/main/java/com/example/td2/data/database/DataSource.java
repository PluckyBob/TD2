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
import android.widget.Toast;

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

    public List<DataItem> getAllItems() {
        List<DataItem> dataItems = new ArrayList<>();
        Cursor cursor = mDatabase.query(ItemsTable.TABLE_ITEMS, ItemsTable.ALL_COLUMNS,
                null, null, null, null,
                null);
        while (cursor.moveToNext()) {
            DataItem item = new DataItem();
            item.setItemID(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_ID)));
            Log.i(TAG,"GOT1: " + item.getItemID());
            item.setItemName(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_NAME)));
            Log.i(TAG,"GOT2: " + item.getItemName());
            item.setDescription(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_DESCRIPTION)));
            Log.i(TAG,"GOT3: " + item.getDescription());
            item.setDuration(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_DURATION)));
            Log.i(TAG,"GOT4: " + item.getDuration());
            item.setAfter(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_AFTER)));
            Log.i(TAG,"GOT5: " + item.getAfter());
            item.setDeadline(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_DEADLINE)));
            Log.i(TAG,"GOT6: " + item.getDeadline());
            item.setStarts(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_START)));
            Log.i(TAG,"GOT7: " + item.getStarts());
            item.setFinishes(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_FINISH)));
            Log.i(TAG,"GOT8: " + item.getFinishes());
            item.setRecycles(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_RECYCLE)));
            Log.i(TAG,"GOT9: " + item.getRecycles());
            item.setDaysICanDoIt(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_VALID_DAYS)));
            Log.i(TAG,"GOT10: " + item.getDaysICanDoIt());
            item.setDateEntered(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_ENTRY_DATE)));
            Log.i(TAG,"GOT11: " + item.getDateEntered());
            item.setEarliestTimeOfDay(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_EARLIEST_TIME_OF_DAY)));
            Log.i(TAG,"GOT12: " + item.getEarliestTimeOfDay());
            item.setLatestTimeOfDay(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_LATEST_TIME_OF_DAY)));
            Log.i(TAG,"GOT13: " + item.getLatestTimeOfDay());
            item.setPeopleNeeded(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_PEOPLE)));
            Log.i(TAG,"GOT14: " + item.getPeopleNeeded());
            try {
                item.setSubjectivePriority(cursor.getInt(cursor.getColumnIndex(ItemsTable.COLUMN_SUBJECTIVE_PRIORITY)));
                Log.i(TAG,"GOT15: " + item.getSubjectivePriority());
            } catch (Exception e) {
                e.printStackTrace();
                Log.i(TAG, "Error"+e);
            }
            item.setCategory(cursor.getInt(cursor.getColumnIndex(ItemsTable.COLUMN_CATEGORY)));
            Log.i(TAG,"GOT16: " + item.getCategory());
            item.setLocation(cursor.getInt(cursor.getColumnIndex(ItemsTable.COLUMN_LOCATION)));
            Log.i(TAG,"GOT17: " + item.getLocation());
            item.setWeather(cursor.getInt(cursor.getColumnIndex(ItemsTable.COLUMN_WEATHER)));
            Log.i(TAG,"GOT18: " + item.getWeather());
            item.setBenefit(cursor.getInt(cursor.getColumnIndex(ItemsTable.COLUMN_BENEFIT)));
            Log.i(TAG,"GOT19: " + item.getBenefit());
            item.setConsequence(cursor.getInt(cursor.getColumnIndex(ItemsTable.COLUMN_CONSEQUENCES)));
            Log.i(TAG,"GOT20: " + item.getConsequence());
            item.setSortPosition(cursor.getInt(cursor.getColumnIndex(ItemsTable.COLUMN_POSITION)));
            Log.i(TAG,"GOT21: " + item.getSortPosition());
            item.setCalculatedPriority(cursor.getDouble(cursor.getColumnIndex(ItemsTable.COLUMN_CALCULATED_PRIORITY)));
            Log.i(TAG,"GOT22: " + item.getCalculatedPriority());
            Log.i(TAG, "Item: "+item.toString());
            dataItems.add(item);
        }
        return dataItems;
    }
}
