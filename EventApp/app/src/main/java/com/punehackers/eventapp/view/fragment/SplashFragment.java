package com.punehackers.eventapp.view.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.punehackers.eventapp.R;


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
                getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null).add(R.id.container, new HomeFragment()).commitAllowingStateLoss();
                finishFragment();
            }
        }, SPLASH_TIME_OUT);

        return rootView;
    }

    private void finishFragment() {
        getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
    }

}