package com.punehackers.eventapp.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.punehackers.eventapp.R;
import com.punehackers.eventapp.Utility.Constants;
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
        setCardViewHeight(view);
        BusViewHolder viewHolder = new BusViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BusViewHolder busViewHolder, int i) {

        busViewHolder.imageView.setImageResource(busDepotList.get(i).getResourceId());
        busViewHolder.textView.setText(busDepotList.get(i).getDepotName());
    }
    private void setCardViewHeight(View view)
    {
        CardView.LayoutParams params=new CardView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int)Constants.convertDpToPixels(50,context));
        params.setMargins( (int)Constants.convertDpToPixels(7,context), (int)Constants.convertDpToPixels(7,context), (int)Constants.convertDpToPixels(7,context), (int)Constants.convertDpToPixels(7,context));
        view.setLayoutParams(params);
    }

    @Override
    public int getItemCount() {
        return (null != busDepotList ? busDepotList.size() : 0);
    }
}
