package com.punehackers.eventapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.punehackers.eventapp.R;
import com.punehackers.eventapp.viewholder.BusDepot;
import com.punehackers.eventapp.viewholder.BusViewHolder;

import java.util.List;

/**
 * Created by user on 04-10-2015.
 */
public class BusDepotAdapter extends RecyclerView.Adapter<BusViewHolder>{
    private List<BusDepot> busDepotList;
    private Context context;
    public BusDepotAdapter(Context context, List<BusDepot>busDepotList)
    {
        this.context=context;
        this.busDepotList=busDepotList;
    }

    @Override
    public BusViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.depot_list_view, null);

        BusViewHolder viewHolder = new BusViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BusViewHolder busViewHolder, int i) {

        busViewHolder.imageView.setImageResource(busDepotList.get(i).getResourceId());
        busViewHolder.textView.setText(busDepotList.get(i).getDepotName());
    }

    @Override
    public int getItemCount() {
        return (null != busDepotList ? busDepotList.size() : 0);
    }
}
