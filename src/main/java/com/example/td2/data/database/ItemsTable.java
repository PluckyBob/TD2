package com.example.td2.data.database;

class ItemsTable {

    private static final String TABLE_ITEMS = "items";
    //strings
    private static final String COLUMN_ID = "itemId";
    private static final String COLUMN_NAME = "itemName";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_DURATION = "duration";
    private static final String COLUMN_AFTER = "after";
    private static final String COLUMN_DEADLINE = "deadline";
    private static final String COLUMN_START = "starts";
    private static final String COLUMN_FINISH = "finishes";
    private static final String COLUMN_RECYCLE = "recycle";
    private static final String COLUMN_VALID_DAYS = "valid_days";
    private static final String COLUMN_ENTRYDATE = "entrydate";
    private static final String COLUMN_EARLIEST_TIME_OF_DAY = "earliest_tod";
    private static final String COLUMN_LATEST_TIME_OF_DAY = "latest_tod";
    //integers
    private static final String COLUMN_SUBJECTIVE_PRIORITY = "priority";
    private static final String COLUMN_CATEGORY = "category";
    private static final String COLUMN_LOCATION = "location";
    private static final String COLUMN_WEATHER = "weather";
    private static final String COLUMN_BENEFIT = "benefit";
    private static final String COLUMN_CONSEQUENCES = "consequences";
    private static final String COLUMN_WORKLOAD = "workload";
    private static final String COLUMN_POSITION = "sortPosition";
    //double
    private static final String COLUMN_CALCULATED_PRIORITY = "CalculatedPriority";
    //boolean
    private static final String COLUMN_SAM = "sam";
    private static final String COLUMN_HELEN = "helen";

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
                    COLUMN_VALID_DAYS + " TEXT," +
                    COLUMN_EARLIEST_TIME_OF_DAY + " TEXT," +
                    COLUMN_LATEST_TIME_OF_DAY + " TEXT," +
                    COLUMN_WEATHER + " INTEGER," +
                    COLUMN_HELEN + " BOOLEAN," +
                    COLUMN_SAM + " BOOLEAN," +
                    COLUMN_SUBJECTIVE_PRIORITY + " INTEGER," +
                    COLUMN_CONSEQUENCES + " INTEGER," +
                    COLUMN_BENEFIT + " INTEGER," +
                    COLUMN_CALCULATED_PRIORITY + " REAL," +
                    COLUMN_POSITION + " INTEGER," +
                    COLUMN_RECYCLE + " TEXT," +
                    COLUMN_WORKLOAD + " INTEGER," +
                    COLUMN_ENTRYDATE + " TEXT" + ");";
    
    public static final String SQL_DELETE =
            "DROP TABLE " + TABLE_ITEMS;
}
