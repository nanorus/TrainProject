package com.example.weekthree.data.db;

import com.example.weekthree.data.api.pojo.DatumPojo;

import java.util.List;

public interface IDatabaseManager {

    void saveData(List<DatumPojo> data);

    List<DatumPojo> loadData();

    DatumPojo loadDetailsData(int id);

    void releaseManager();

}
