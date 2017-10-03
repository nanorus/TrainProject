package com.example.weekthree.routes.details;

import android.app.Activity;
import android.content.Context;
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

    public static RouteDetailsFragment newInstance() {
        RouteDetailsFragment fragment = new RouteDetailsFragment();
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getArguments() != null)
            id = getArguments().getInt("id", -1);
        else
            id = -1;
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

        clearFields();

        if (id != -1) {
            DatumPojo data = mDataManager.loadDetailsData(id);

            tvId.setText(String.valueOf(data.getId()));
            tvFromCity.setText(data.getFromCity().getName());
            tvToCity.setText(data.getToCity().getName());
            tvPrice.setText(String.valueOf(data.getPrice()));
        }

        return view;
    }

    private void clearFields() {
        tvId.setText("");
        tvFromCity.setText("");
        tvToCity.setText("");
        tvPrice.setText("");
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
        else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void showRouteDetails(int id) {
        DatumPojo data = mDataManager.loadDetailsData(id);

        tvId.setText(String.valueOf(data.getId()));
        tvFromCity.setText(data.getFromCity().getName());
        tvToCity.setText(data.getToCity().getName());
        tvPrice.setText(String.valueOf(data.getPrice()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mDataManager.releaseDatabase();
    }

    public interface OnFragmentInteractionListener {
    }
}
