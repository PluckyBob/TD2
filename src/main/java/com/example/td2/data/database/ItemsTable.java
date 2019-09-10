package com.example.td2.data.database;

public class ItemsTable {

    public static final String TABLE_ITEMS = "items";
    public static final String COLUMN_ID = "itemId";
    public static final String COLUMN_NAME = "itemName";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_DURATION = "duration";
    public static final String COLUMN_AFTER = "after";
    public static final String COLUMN_DEADLINE = "deadline";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_LOCATION = "location";
    public static final String COLUMN_RECYCLE = "recycle";
    public static final String COLUMN_IMAGE = "image";
    public static final String COLUMN_VALID_DAYS = "valid_days";
    public static final String COLUMN_EARLIEST_TIME_OF_DAY = "earliest_tod";
    public static final String COLUMN_LATEST_TIME_OF_DAY = "latest_tod";
    public static final String COLUMN_BENEFIT = "benefit";
    public static final String COLUMN_SUBJECTIVE_PRIORITY = "priority";
    public static final String COLUMN_CONSEQUENCES = "consequences";
    public static final String COLUMN_WEATHER = "weather";
    public static final String COLUMN_SAM = "sam";
    public static final String COLUMN_HELEN = "helen";
    public static final String COLUMN_WORKLOAD = "workload";
    public static final String COLUMN_ENTRYDATE = "entrydate";
    public static final String COLUMN_CALCULATED_PRIORITY = "CalculatedPriority";
    public static final String COLUMN_POSITION = "sortPosition";
    public static final String SQL_CREATE =
                    "CREATE TABLE " + TABLE_ITEMS + "(" +
                            COLUMN_ID + " TEXT PRIMARY KEY," +
                            COLUMN_NAME + " TEXT," +
                            COLUMN_DESCRIPTION + " TEXT," +
                            COLUMN_DURATION + " TEXT," +
                            COLUMN_CATEGORY + " TEXT," +
                            COLUMN_LOCATION + " INTEGER," +
                            COLUMN_AFTER + " TEXT," +
                            COLUMN_DEADLINE + " TEXT," +
                            COLUMN_VALID_DAYS + " TEXT," +
                            COLUMN_EARLIEST_TIME_OF_DAY + " TEXT," +
                            COLUMN_LATEST_TIME_OF_DAY + " TEXT," +
                            COLUMN_WEATHER + " INTEGER," +
                            COLUMN_HELEN + " TEXT," +
                            COLUMN_SAM + " TEXT," +
                            COLUMN_SUBJECTIVE_PRIORITY + " INTEGER," +
                            COLUMN_CONSEQUENCES + " INTEGER," +
                            COLUMN_BENEFIT + " INTEGER," +
                            COLUMN_CALCULATED_PRIORITY + " REAL," +
                            COLUMN_POSITION + " INTEGER," +
                            COLUMN_RECYCLE + " TEXT," +
                            COLUMN_WORKLOAD + " INTEGER," +
                            COLUMN_ENTRYDATE + " TEXT," +
                            COLUMN_IMAGE + " TEXT" + ");";
    public static final String SQL_DELETE =
            "DROP TABLE " + TABLE_ITEMS;
}
