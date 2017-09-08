package com.example.nanorus.trainproject.fragments_lifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.nanorus.trainproject.R;
import com.example.nanorus.trainproject.fragments_lifecycle.fragments.BlackFragment;
import com.example.nanorus.trainproject.fragments_lifecycle.fragments.BlueFragment;
import com.example.nanorus.trainproject.fragments_lifecycle.fragments.GreenFragment;
import com.example.nanorus.trainproject.fragments_lifecycle.fragments.RedFragment;

public class FragmentsLifecycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments_lifecycle);


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_fragments_lifecycle_frame, new BlackFragment(), "black")
                .addToBackStack("FragmentsLifecycleActivity")
                .commit();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_fragments_lifecycle_frame, new BlueFragment(), "blue")
                .addToBackStack("FragmentsLifecycleActivity")
                .commit();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_fragments_lifecycle_frame, new GreenFragment(), "green")
                .addToBackStack("FragmentsLifecycleActivity")
                .commit();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_fragments_lifecycle_frame, new RedFragment(), "red")
                .addToBackStack("FragmentsLifecycleActivity")
                .commit();
    }



}
