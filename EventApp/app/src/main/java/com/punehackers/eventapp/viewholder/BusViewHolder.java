package com.punehackers.eventapp.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.punehackers.eventapp.R;

/**
 * Created by user on 04-10-2015.
 */
public class BusViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView textView;

    public BusViewHolder(View view) {
        super(view);
        this.imageView = (ImageView) view.findViewById(R.id.imageView);
        this.textView = (TextView) view.findViewById(R.id.depotName);
    }
}