package com.example.nanorus.trainproject.fragments_lifecycle.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nanorus.trainproject.R;

public class GreenFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_green, container, false);
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        System.out.println("Green: onAttach");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println("Green: onViewCreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("Green: onActivityCreated");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        System.out.println("Green: onViewStateRestored");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        System.out.println("Green: onSaveInstanceState");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("Green: onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Green: onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("Green: onDetach");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("Green: onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("Green: onPause");
    }
    @Override
    public void onStart() {
        super.onStart();
        System.out.println("Green: onStart");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("Green: onStop");
    }

}
