package com.example.weekthree.routes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.weekthree.data.api.pojo.DatumPojo;

import java.util.List;


public class SaveRoutesFragment extends Fragment {
    private List<DatumPojo> mDatumPojos;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public List<DatumPojo> getDatumPojos() {
        return mDatumPojos;
    }

    public void setDatumPojos(List<DatumPojo> datumPojos) {
        mDatumPojos = datumPojos;
    }
}
