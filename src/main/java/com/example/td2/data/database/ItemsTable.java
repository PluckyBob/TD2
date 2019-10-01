package com.example.td2.data.database;

public class ItemsTable {

    public static final String TABLE_ITEMS = "items";
    //strings
    public static final String COLUMN_ID = "itemId";
    public static final String COLUMN_NAME = "itemName";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_DURATION = "duration";
    public static final String COLUMN_AFTER = "after";
    public static final String COLUMN_DEADLINE = "deadline";
    public static final String COLUMN_START = "starts";
    public static final String COLUMN_FINISH = "finishes";
    public static final String COLUMN_RECYCLE = "recycle";
    public static final String COLUMN_VALID_DAYS = "valid_days";
    public static final String COLUMN_ENTRY_DATE = "entry_date";
    public static final String COLUMN_EARLIEST_TIME_OF_DAY = "earliest_tod";
    public static final String COLUMN_LATEST_TIME_OF_DAY = "latest_tod";
    //integers
    public static final String COLUMN_SUBJECTIVE_PRIORITY = "priority";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_LOCATION = "location";
    public static final String COLUMN_WEATHER = "weather";
    public static final String COLUMN_BENEFIT = "benefit";
    public static final String COLUMN_CONSEQUENCES = "consequences";
    public static final String COLUMN_WORKLOAD = "workload";
    public static final String COLUMN_POSITION = "sortPosition";
    public static final String COLUMN_PEOPLE = "people";
    //double
    public static final String COLUMN_CALCULATED_PRIORITY = "CalculatedPriority";
    public static final String[] ALL_COLUMNS = {
            COLUMN_ID, COLUMN_NAME, COLUMN_DESCRIPTION, COLUMN_DURATION,
            COLUMN_AFTER, COLUMN_DEADLINE, COLUMN_START, COLUMN_FINISH,
            COLUMN_RECYCLE, COLUMN_VALID_DAYS, COLUMN_ENTRY_DATE,
            COLUMN_EARLIEST_TIME_OF_DAY, COLUMN_LATEST_TIME_OF_DAY,
            COLUMN_CALCULATED_PRIORITY, COLUMN_CATEGORY, COLUMN_LOCATION,
            COLUMN_WEATHER, COLUMN_BENEFIT, COLUMN_CONSEQUENCES,
            COLUMN_WORKLOAD, COLUMN_POSITION, COLUMN_PEOPLE
    };

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_ITEMS + "(" +
                    COLUMN_ID + " TEXT PRIMARY KEY," +
                    COLUMN_NAME + " TEXT," +
                    COLUMN_DESCRIPTION + " TEXT," +
                    COLUMN_DURATION + " TEXT," +
                    COLUMN_CATEGORY + " INTEGER," +
                    COLUMN_LOCATION + " INTEGER," +
                    COLUMN_AFTER + " TEXT," +
                    COLUMN_DEADLINE + " TEXT," +
                    COLUMN_START + " TEXT," +
                    COLUMN_FINISH + " TEXT," +
                    COLUMN_VALID_DAYS + " TEXT," +
                    COLUMN_EARLIEST_TIME_OF_DAY + " TEXT," +
                    COLUMN_LATEST_TIME_OF_DAY + " TEXT," +
                    COLUMN_WEATHER + " INTEGER," +
                    COLUMN_PEOPLE + " TEXT," +
                    COLUMN_SUBJECTIVE_PRIORITY + " INTEGER," +
                    COLUMN_CONSEQUENCES + " INTEGER," +
                    COLUMN_BENEFIT + " INTEGER," +
                    COLUMN_CALCULATED_PRIORITY + " REAL," +
                    COLUMN_POSITION + " INTEGER," +
                    COLUMN_RECYCLE + " TEXT," +
                    COLUMN_WORKLOAD + " INTEGER," +
                    COLUMN_ENTRY_DATE + " TEXT" + ");";

    public static final String SQL_DELETE =
            "DROP TABLE " + TABLE_ITEMS;
}
