package com.example.nanorus.trainproject.fragments_lifecycle.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nanorus.trainproject.R;

public class RedFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_red, container, false);
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        System.out.println("Red: onAttach");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println("Red: onViewCreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("Red: onActivityCreated");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        System.out.println("Red: onViewStateRestored");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        System.out.println("Red: onSaveInstanceState");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("Red: onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Red: onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("Red: onDetach");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("Red: onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("Red: onPause");
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("Red: onStart");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("Red: onStop");
    }

}
