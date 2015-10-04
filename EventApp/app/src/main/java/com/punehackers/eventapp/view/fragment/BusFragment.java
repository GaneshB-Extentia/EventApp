package com.punehackers.eventapp.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.punehackers.eventapp.R;
import com.punehackers.eventapp.Widgets.CustomButton;
import com.punehackers.eventapp.view.EventActivity;

/**
 * Created by user on 03-10-2015.
 */
public class BusFragment extends Fragment {

    private View rootView;
    private CustomButton busDepotListButton;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.bus_info_view,null);
        initializeScreen();
        return rootView;
    }
    private void initializeScreen()
    {
        ((EventActivity) getActivity()).mToolbar.setTitle("Bus");
        busDepotListButton=(CustomButton)rootView.findViewById(R.id.browsDepots);
        busDepotListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.container,new BusListFragment()).commitAllowingStateLoss();
            }
        });
    }
}
