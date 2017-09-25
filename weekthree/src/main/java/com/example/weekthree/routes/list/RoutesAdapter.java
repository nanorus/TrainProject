package com.example.weekthree.routes.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.weekthree.R;
import com.example.weekthree.data.api.pojo.DatumPojo;

import java.util.List;

public class RoutesAdapter extends RecyclerView.Adapter<RoutesAdapter.RoutesViewHolder> {

    private List<DatumPojo> mDatumPojos;

    public RoutesAdapter(List<DatumPojo> datumPojos) {
        mDatumPojos = datumPojos;
    }

    @Override
    public RoutesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_routes_item, parent, false);
        return new RoutesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RoutesViewHolder holder, int position) {
        holder.rvFromCity.setText(mDatumPojos.get(position).getFromCity().getName());
        holder.rvToCity.setText(mDatumPojos.get(position).getToCity().getName());
    }

    @Override
    public int getItemCount() {
        if (mDatumPojos != null)
            return mDatumPojos.size();
        else
            return 0;
    }

    class RoutesViewHolder extends RecyclerView.ViewHolder {
        TextView rvFromCity;
        TextView rvToCity;

        public RoutesViewHolder(View itemView) {
            super(itemView);
            rvFromCity = itemView.findViewById(R.id.list_routes_item_tv_from_city);
            rvToCity = itemView.findViewById(R.id.list_routes_item_tv_to_city);
        }
    }

}
