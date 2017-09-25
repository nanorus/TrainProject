package com.example.weekthree.routes.details;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.weekthree.R;
import com.example.weekthree.data.DataManager;
import com.example.weekthree.data.api.pojo.DatumPojo;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RouteDetailsFragment extends Fragment {

    DataManager mDataManager;
    int id;

    @BindView(R.id.fragment_route_details_tv_id)
    TextView tvId;
    @BindView(R.id.fragment_route_details_tv_from_city)
    TextView tvFromCity;
    @BindView(R.id.fragment_route_details_tv_to_city)
    TextView tvToCity;
    @BindView(R.id.fragment_route_details_tv_price)
    TextView tvPrice;

    private OnFragmentInteractionListener mListener;

    public RouteDetailsFragment() {
        // Required empty public constructor
    }

    public static RouteDetailsFragment newInstance(int id) {
        RouteDetailsFragment fragment = new RouteDetailsFragment();
        Bundle args = new Bundle();
        args.putInt("id", id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        id = getArguments().getInt("id", 0);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_route_details, container, false);
        ButterKnife.bind(this, view);

        mDataManager = new DataManager();

        DatumPojo data = mDataManager.loadDetailsData(id, DataManager.DB_TYPE_SQLITE);

        tvId.setText(String.valueOf(data.getId()));
        tvFromCity.setText(data.getFromCity().getName());
        tvToCity.setText(data.getToCity().getName());
        tvPrice.setText(String.valueOf(data.getPrice()));


        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
    }
}
