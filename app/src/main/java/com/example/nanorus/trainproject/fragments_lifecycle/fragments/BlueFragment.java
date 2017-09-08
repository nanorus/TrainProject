package com.example.nanorus.trainproject.fragments_lifecycle.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nanorus.trainproject.R;

public class BlueFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_blue, container, false);
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        System.out.println("Blue: onAttach");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println("Blue: onViewCreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("Blue: onActivityCreated");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        System.out.println("Blue: onViewStateRestored");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        System.out.println("Blue: onSaveInstanceState");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("Blue: onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Blue: onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("Blue: onDetach");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("Blue: onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("Blue: onPause");
    }
    @Override
    public void onStart() {
        super.onStart();
        System.out.println("Blue: onStart");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("Blue: onStop");
    }
}
