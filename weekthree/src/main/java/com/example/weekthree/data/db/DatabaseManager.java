package com.example.weekthree.data.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.weekthree.App;
import com.example.weekthree.data.api.pojo.DatumPojo;
import com.example.weekthree.data.db.sqlite.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    SQLiteDatabase mWritableSQLiteDatabase;
    SQLiteDatabase mReadableSQLiteDatabase;
    DBHelper mDBHelper;

    public DatabaseManager() {
        mDBHelper = new DBHelper(App.getInstance().getApplicationContext());
        mWritableSQLiteDatabase = mDBHelper.getWritableDatabase();
        mReadableSQLiteDatabase = mDBHelper.getReadableDatabase();
    }

    public void saveDataIntoSqlite(List<DatumPojo> data) {
        ContentValues contentValues = new ContentValues();
        for (DatumPojo datumPojo : data) {
            contentValues.put(DBHelper.COLUMN_ROUTES_ID, datumPojo.getId());
            contentValues.put(DBHelper.COLUMN_ROUTES_FROM_CITY_NAME, datumPojo.getFromCity().getName());
            contentValues.put(DBHelper.COLUMN_ROUTES_TO_CITY_NAME, datumPojo.getToCity().getName());
            contentValues.put(DBHelper.COLUMN_ROUTES_PRICE, datumPojo.getPrice());
            mWritableSQLiteDatabase.insertWithOnConflict(DBHelper.TABLE_ROUTES_NAME, null, contentValues, SQLiteDatabase.CONFLICT_IGNORE);
        }
        contentValues.clear();
    }

    public List<DatumPojo> loadDataFromSqlite() {
        List<DatumPojo> datumPojos = new ArrayList<>();

        Cursor cursor = mReadableSQLiteDatabase.query(DBHelper.TABLE_ROUTES_NAME, new String[]{
                DBHelper.COLUMN_ROUTES_ID,
                DBHelper.COLUMN_ROUTES_FROM_CITY_NAME,
                DBHelper.COLUMN_ROUTES_TO_CITY_NAME,
                DBHelper.COLUMN_ROUTES_PRICE
        }, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                datumPojos.add(new DatumPojo(
                        cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_ROUTES_ID)),
                        cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_ROUTES_FROM_CITY_NAME)),
                        cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_ROUTES_TO_CITY_NAME)),
                        cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_ROUTES_PRICE))
                ));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return datumPojos;
    }


    public DatumPojo loadDetailsDataFromSqlite(int id) {
        DatumPojo data = null;

        Cursor cursor = mReadableSQLiteDatabase.query(DBHelper.TABLE_ROUTES_NAME, new String[]{
                DBHelper.COLUMN_ROUTES_ID,
                DBHelper.COLUMN_ROUTES_FROM_CITY_NAME,
                DBHelper.COLUMN_ROUTES_TO_CITY_NAME,
                DBHelper.COLUMN_ROUTES_PRICE
        }, DBHelper.COLUMN_ROUTES_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, "1");

        if (cursor.moveToFirst()) {
            data = new DatumPojo(
                    cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_ROUTES_ID)),
                    cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_ROUTES_FROM_CITY_NAME)),
                    cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_ROUTES_TO_CITY_NAME)),
                    cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_ROUTES_PRICE))
            );
        }
        cursor.close();
        return data;
    }

    // loadDataFromSqlite(from, to);
    // saveDataIntoSqlite();
    // clearSqliteDb();

    // loadFromRealm(from, to);
    // saveIntoRealm();
    // clear RealmDv();

}
