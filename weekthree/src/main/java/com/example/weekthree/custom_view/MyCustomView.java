package com.example.weekthree.custom_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.weekthree.R;


public class MyCustomView extends RelativeLayout {

    TextView tv1;
    TextView tv2;
    TextView tv3;

    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.view_my_custom, this);

        tv1 = findViewById(R.id.view_my_custom_tv_1);
        tv2 = findViewById(R.id.view_my_custom_tv_2);
        tv3 = findViewById(R.id.view_my_custom_tv_3);

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.MyCustomView);
        String text1 = typedArray.getString(R.styleable.MyCustomView_myCustomText1);
        String text2 = typedArray.getString(R.styleable.MyCustomView_myCustomText2);
        String text3 = typedArray.getString(R.styleable.MyCustomView_myCustomText3);

        typedArray.recycle();

        tv1.setText(text1);
        tv2.setText(text2);
        tv3.setText(text3);
    }


}
