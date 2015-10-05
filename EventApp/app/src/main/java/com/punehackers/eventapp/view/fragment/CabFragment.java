package com.punehackers.eventapp.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.punehackers.eventapp.R;
import com.punehackers.eventapp.view.EventActivity;

/**
 * Created by Chintamani.Kulkarni on 10/5/2015.
 */
public class CabFragment extends Fragment {
    private View rootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView=inflater.inflate(R.layout.cab_view,null);
        initializeScreen();
        return rootView;
    }
    private void initializeScreen()
    {
        ((EventActivity) getActivity()).mToolbar.setTitle("Cab");
    }
}
