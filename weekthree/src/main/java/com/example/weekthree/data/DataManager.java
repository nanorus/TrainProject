package com.example.weekthree.data;

import com.example.weekthree.data.api.pojo.DatumPojo;
import com.example.weekthree.data.db.DatabaseManager;

import java.util.List;

public class DataManager {

    public static final int DB_TYPE_SQLITE = 0;
    public static final int DB_TYPE_REALM = 1;

    DatabaseManager mDatabaseManager;

    public DataManager() {
        mDatabaseManager = new DatabaseManager();
    }

    public void saveData(List<DatumPojo> data, int dbType) {
        switch (dbType) {
            case DB_TYPE_SQLITE:
                mDatabaseManager.saveDataIntoSqlite(data);
                break;
            case DB_TYPE_REALM:

                break;
        }
    }

    public List<DatumPojo> loadData(int dbType) {
        List<DatumPojo> datumPojos = null;
        switch (dbType) {
            case DB_TYPE_SQLITE:
                datumPojos = mDatabaseManager.loadDataFromSqlite();
                break;
            case DB_TYPE_REALM:

                break;
        }
        return datumPojos;
    }

    public DatumPojo loadDetailsData(int id, int dbType){
        DatumPojo data = null;
        switch (dbType) {
            case DB_TYPE_SQLITE:
                data = mDatabaseManager.loadDetailsDataFromSqlite(id);
                break;
            case DB_TYPE_REALM:

                break;
        }
        return data;
    }

    // loadData(dbType);
    // saveData(dbType);
    // clearData(dbType);

}
