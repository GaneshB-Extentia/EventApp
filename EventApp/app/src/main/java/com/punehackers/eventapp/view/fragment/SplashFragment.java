package com.punehackers.eventapp.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.punehackers.eventapp.R;
import com.punehackers.eventapp.view.EventActivity;
import com.punehackers.eventapp.view.MainActivity;


public class SplashFragment extends Fragment {

    private View rootView;
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_splash, container, false);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                ((EventActivity) getActivity()).moveToScreen(new HomeFragment());
                Intent intent=new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        }, SPLASH_TIME_OUT);

        return rootView;
    }

}