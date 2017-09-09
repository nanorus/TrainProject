package com.example.nanorus.trainproject.dialogs;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.nanorus.trainproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TestDialogFragment extends DialogFragment {
    @BindView(R.id.btnYes)
    Button mBtnYes;
    @BindView(R.id.btnNo)
    Button mBtnNo;
    @BindView(R.id.btnMaybe)
    Button mBtnMaybe;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().setTitle("FragmentDialog");
        View view = inflater.inflate(R.layout.fragment_dialog_test, null);
        ButterKnife.bind(this, view);
        mBtnYes.setOnClickListener(view1 -> {
            Toast.makeText(getActivity(), "yes clicked", Toast.LENGTH_SHORT).show();
            dismiss();
        });
        mBtnNo.setOnClickListener(view1 -> {
            Toast.makeText(getActivity(), "no clicked", Toast.LENGTH_SHORT).show();
            dismiss();
        });
        mBtnMaybe.setOnClickListener(view1 -> {
            Toast.makeText(getActivity(), "maybe clicked", Toast.LENGTH_SHORT).show();
            dismiss();
        });
        return view;
    }
}
