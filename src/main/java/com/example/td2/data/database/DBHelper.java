package com.example.td2.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_FILE_NAME = "ToDo.db";
    public static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_FILE_NAME,
                null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ItemsTable.SQL_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        The first time the user opens the new version of the application,
//        the on upgrade method will be called. Once again,
//        you'll get a DB reference but this time you'll get the old
//        version and the new version. It's up to you to write the custom
//        code that's needed. Say to add columns to a table,
//        but if you just want to wipe out the database and start
//        over again, you can do this.
        db.execSQL(ItemsTable.SQL_DELETE);
        onCreate(db);
//        If you want to maintain data that's already in the database,
//         you could export the current data, say to a JSON file,
//         then drop the database, recreate it, and then re import the data

    }
}
