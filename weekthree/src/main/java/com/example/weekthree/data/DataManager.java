package com.example.weekthree.data;

import com.example.weekthree.data.api.pojo.DatumPojo;
import com.example.weekthree.data.db.IDatabaseManager;

import java.util.List;

public class DataManager {

    public static final int DB_TYPE_SQLITE = 0;
    public static final int DB_TYPE_REALM = 1;
    private IDatabaseManager mDatabaseManager;
    private DataManagerFactory mDataManagerFactory;

    public DataManager() {
        mDataManagerFactory = new DataManagerFactory();
        mDatabaseManager = mDataManagerFactory.getDataManager();
    }

    public void saveData(List<DatumPojo> data) {
        mDatabaseManager.saveData(data);
    }

    public List<DatumPojo> loadData() {
        return mDatabaseManager.loadData();
    }

    public DatumPojo loadDetailsData(int id) {
        return mDatabaseManager.loadDetailsData(id);
    }

    public void releaseDatabase(){
        mDatabaseManager.releaseManager();
    }

}
