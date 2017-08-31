package com.example.nanorus.trainproject.custom_views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nanorus.trainproject.R;

public class PlusMinusView extends RelativeLayout {

    private TextView mTvTitle;
    private TextView mTvCount;
    private Button mBtnPlus;
    private Button mBtnMinus;

    private int mCount = 0;

    public PlusMinusView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.PlusMinusView);
        String title = typedArray.getString(R.styleable.PlusMinusView_pmv_title);
        mCount = typedArray.getInt(R.styleable.PlusMinusView_pmv_count, 0);
        typedArray.recycle();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_plus_minus, this, true);
        mTvTitle = findViewById(R.id.view_plus_minus_tv_title);
        mTvCount = findViewById(R.id.view_plus_minus_tv_count);
        mBtnPlus = findViewById(R.id.view_plus_minus_btn_plus);
        mBtnMinus = findViewById(R.id.view_plus_minus_btn_minus);

        mTvTitle.setText(title);
        mTvCount.setText(String.valueOf(mCount));

        mBtnPlus.setOnClickListener(view -> plusCount());
        mBtnMinus.setOnClickListener(view -> minuCount());
    }

    private void plusCount() {
        mCount++;
        mTvCount.setText(String.valueOf(mCount));

    }

    private void minuCount() {
        mCount--;
        mTvCount.setText(String.valueOf(mCount));
    }

}
