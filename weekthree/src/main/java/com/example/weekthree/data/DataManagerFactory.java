package com.example.weekthree.data;

import com.example.weekthree.data.db.IDatabaseManager;
import com.example.weekthree.data.db.realm.RealmDatabaseManager;
import com.example.weekthree.data.db.sqlite.SQLiteDatabaseManager;
import com.example.weekthree.data.preferences.PreferencesManager;

import static com.example.weekthree.data.DataManager.DB_TYPE_REALM;
import static com.example.weekthree.data.DataManager.DB_TYPE_SQLITE;

public class DataManagerFactory {
    private PreferencesManager mPreferencesManager;

    public IDatabaseManager getDataManager() {
        mPreferencesManager = PreferencesManager.getInstance();

        IDatabaseManager databaseManager;
        int dbType = mPreferencesManager.getDbType();
        switch (dbType) {
            case DB_TYPE_SQLITE:
                databaseManager = new SQLiteDatabaseManager();
                break;
            case DB_TYPE_REALM:
                databaseManager = new RealmDatabaseManager();
                break;
            default:
                databaseManager = new SQLiteDatabaseManager();
                break;
        }
        return databaseManager;
    }

}
