package com.example.weekthree.data.db.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "routes.db";

    public static final String TABLE_ROUTES_NAME = "routes";
    public static final String COLUMN_ROUTES_ID = "_id";
    public static final String COLUMN_ROUTES_FROM_CITY_NAME = "from_city";
    public static final String COLUMN_ROUTES_TO_CITY_NAME = "to_city";
    public static final String COLUMN_ROUTES_PRICE = "price";

    private String SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_ROUTES_NAME +
            "(" + COLUMN_ROUTES_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_ROUTES_FROM_CITY_NAME + " TEXT, " +
            COLUMN_ROUTES_TO_CITY_NAME + " TEXT, " +
            COLUMN_ROUTES_PRICE + " INTEGER) ";
    private String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TABLE_ROUTES_NAME;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
