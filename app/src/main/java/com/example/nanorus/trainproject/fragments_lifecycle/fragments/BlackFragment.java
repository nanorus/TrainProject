package com.example.nanorus.trainproject.fragments_lifecycle.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.nanorus.trainproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BlackFragment extends Fragment {

    @BindView(R.id.fragment_black_root)
    LinearLayout rootLayout;

    public BlackFragment() {
        super();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    void checkVisibility() {
        System.out.println("this.isVisible(): " + this.isVisible());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_black, container, false);
        ButterKnife.bind(this, v);

        rootLayout.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                System.out.println("BLACK: focus changed");

            }
        });
        rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("BLACK: clicked");
                checkVisibility();

            }
        });
        rootLayout.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View view) {
                System.out.println("BLACK: AttachedToWindow");

            }

            @Override
            public void onViewDetachedFromWindow(View view) {
                System.out.println("BLACK: DetachedFromWindow");

            }
        });
        rootLayout.setOnHoverListener(new View.OnHoverListener() {
            @Override
            public boolean onHover(View view, MotionEvent motionEvent) {
                System.out.println("BLACK: onHover");

                return false;
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        System.out.println("Black: onAttach");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println("Black: onViewCreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("Black: onActivityCreated");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        System.out.println("Black: onViewStateRestored");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        System.out.println("Black: onSaveInstanceState");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("Black: onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Black: onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("Black: onDetach");
    }

    @Override
    public void onResume() {
        super.onResume();
        checkVisibility();
        System.out.println("Black: onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("Black: onPause");
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("Black: onStart");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("Black: onStop");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            System.out.println("BLACK FRAGMENT: VISIBLE");
        } else {
            System.out.println("BLACK FRAGMENT: INVISIBLE");
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        System.out.println("BLACK FRAGMENT: onHiddenChanged");
    }
}
