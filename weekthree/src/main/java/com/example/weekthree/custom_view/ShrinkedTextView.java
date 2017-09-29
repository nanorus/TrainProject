package com.example.weekthree.custom_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.weekthree.R;


public class ShrinkedTextView extends AppCompatTextView {

    final int LINE_BREAK_NONE = 0;
    final int LINE_BREAK_LEFT = 1;
    final int LINE_BREAK_CENTER = 2;
    final int LINE_BREAK_RIGHT = 3;
    final String LINE_BREAK_SYMBOLS = "...";

    float minShrinkSize;
    boolean isAutoShrink;
    int lineBreak;

    int width;
    boolean isLineBreaked;


    public ShrinkedTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        isInEditMode();

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.ShrinkedTextView);
        minShrinkSize = typedArray.getFloat(R.styleable.ShrinkedTextView_minShrinkSize, 12);
        isAutoShrink = typedArray.getBoolean(R.styleable.ShrinkedTextView_autoShrink, false);
        lineBreak = typedArray.getInt(R.styleable.ShrinkedTextView_lineBreak, LINE_BREAK_NONE);
        typedArray.recycle();
    }
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        width = getMeasuredWidth();
        if (isAutoShrink) {
            shrinkTextToFit(width, this, getTextSize(), minShrinkSize);
            if (lineBreak != LINE_BREAK_NONE)
                breakLine(lineBreak, getMeasuredWidth(), this);
        } else {
            if (lineBreak != LINE_BREAK_NONE)
                breakLine(lineBreak, getMeasuredWidth(), this);
        }
    }

    public void shrinkTextToFit(float availableWidth, TextView textView,
                                float startingTextSize, float minimumTextSize) {
        CharSequence text = textView.getText();
        float textSize = startingTextSize;
        textView.setTextSize(startingTextSize);
        while (text != (TextUtils.ellipsize(text, textView.getPaint(),
                availableWidth, TextUtils.TruncateAt.END))) {
            textSize -= 1;
            if (textSize < minimumTextSize) {
                break;
            } else {
                textView.setTextSize(textSize);
            }
        }
    }

    public void breakLine(int lineBreakType, float availableWidth, TextView textView) {
        StringBuilder text = new StringBuilder(textView.getText().toString());
        boolean isCycleStarted;
        if (!isTextFit(text, availableWidth, textView)) {
            switch (lineBreakType) {
                case LINE_BREAK_LEFT:
                    if (!isLineBreaked) {
                        text.insert(0, LINE_BREAK_SYMBOLS);
                        isLineBreaked = true;
                    }
                    isCycleStarted = false;
                    while (!isTextFit(text, availableWidth, textView)) {
                        try {
                            text.deleteCharAt(LINE_BREAK_SYMBOLS.length());
                        } catch (StringIndexOutOfBoundsException e) {
                            break;
                        }
                        isCycleStarted = true;
                    }
                    if (isCycleStarted)
                        setText(text);
                    break;

                case LINE_BREAK_CENTER:
                    if (!isLineBreaked) {
                        if (text.length() % 2 != 0) {
                            try {
                                text.deleteCharAt((text.length() / 2) + 1);
                            } catch (StringIndexOutOfBoundsException e) {
                                break;
                            }
                        }
                        text.insert(text.length() / 2, LINE_BREAK_SYMBOLS);
                        isLineBreaked = true;
                    }
                    isCycleStarted = false;
                    while (!isTextFit(text, availableWidth, textView)) {
                        System.out.println(text);
                        try {
                            text.deleteCharAt((text.length() / 2) - 2);
                            text.deleteCharAt((text.length() / 2) + 1);
                        } catch (StringIndexOutOfBoundsException e) {
                            break;
                        }
                        isCycleStarted = true;
                    }
                    if (isCycleStarted)
                        setText(text);

                    break;

                case LINE_BREAK_RIGHT:
                    if (!isLineBreaked) {
                        text.append(LINE_BREAK_SYMBOLS);
                        isLineBreaked = true;
                    }
                    isCycleStarted = false;
                    while (!isTextFit(text, availableWidth, textView)) {
                        try {
                            text.deleteCharAt((text.length() - 1) - LINE_BREAK_SYMBOLS.length());
                        } catch (StringIndexOutOfBoundsException e) {
                            break;
                        }
                        isCycleStarted = true;
                    }
                    if (isCycleStarted)
                        setText(text);
                    break;
            }
        }
    }

    private boolean isTextFit(StringBuilder text, float availableWidth, TextView textView) {
        return text == (TextUtils.ellipsize(text, textView.getPaint(),
                availableWidth, TextUtils.TruncateAt.END));
    }

}