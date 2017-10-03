package com.example.weekthree.data.db.realm;

import com.example.weekthree.data.api.pojo.DatumPojo;
import com.example.weekthree.data.db.IDatabaseManager;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmDatabaseManager implements IDatabaseManager {

    Realm mRealm;

    public RealmDatabaseManager() {
        mRealm = Realm.getDefaultInstance();
    }

    @Override
    public void saveData(List<DatumPojo> data) {
        mRealm.beginTransaction();
        DataRealm dataRealm;
        for (int i = 0; i < data.size(); i++) {
            dataRealm = mRealm.createObject(DataRealm.class);
            dataRealm.setId(data.get(i).getId());
            dataRealm.setFromCityName(data.get(i).getFromCity().getName());
            dataRealm.setToCityName(data.get(i).getToCity().getName());
            dataRealm.setPrice(data.get(i).getPrice());
        }
        mRealm.commitTransaction();
    }

    @Override
    public List<DatumPojo> loadData() {
        List<DatumPojo> datumPojos = new ArrayList<>();
        RealmResults<DataRealm> dataRealmRealmResults = mRealm.where(DataRealm.class).findAll();
        for (int i = 0; i < dataRealmRealmResults.size(); i++) {
            datumPojos.add(new DatumPojo((int)
                    dataRealmRealmResults.get(0).getId(),
                    dataRealmRealmResults.get(0).getFromCityName(),
                    dataRealmRealmResults.get(0).getToCityName(),
                    dataRealmRealmResults.get(0).getPrice()
            ));
        }
        return datumPojos;
    }

    @Override
    public DatumPojo loadDetailsData(int id) {
        DataRealm dataRealm = mRealm.where(DataRealm.class)
                .equalTo("id", id).findAll().get(0);
        return new DatumPojo((int) dataRealm.getId(), dataRealm.getFromCityName(), dataRealm.getToCityName(), dataRealm.getPrice());
    }

    @Override
    public void releaseManager() {
        mRealm.close();
    }


}
