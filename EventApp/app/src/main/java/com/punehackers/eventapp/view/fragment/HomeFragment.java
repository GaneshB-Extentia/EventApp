package com.punehackers.eventapp.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.punehackers.eventapp.R;
import com.punehackers.eventapp.Widgets.CircleMenuLayout;
import com.punehackers.eventapp.view.EventActivity;


public class HomeFragment extends Fragment {

    private View rootView;

    private CircleMenuLayout mCircleMenuLayout;

    private String[] mItemTexts = new String[] { "BUS ", "CAB", "RICKSHAW",
            "TRAIN"};
    private int[] mItemImgs = new int[] { R.drawable.ic_bus,
            R.drawable.ic_rickshaw, R.drawable.ic_action_cab,
            R.drawable.ic_train };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        if (((EventActivity) getActivity()).mDrawerLayout != null)
            ((EventActivity) getActivity()).mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        initializeScreen();
        return rootView;
    }

    private void initializeScreen()
    {
        ((EventActivity) getActivity()).mToolbar.setTitle("Home");

        mCircleMenuLayout = (CircleMenuLayout) rootView.findViewById(R.id.id_menulayout);
        mCircleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);
        mCircleMenuLayout.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener() {
            @Override
            public void itemClick(View view, int pos) {

                switch (pos) {

                    case 0:
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .addToBackStack(null).add(R.id.container, new BusFragment()).commitAllowingStateLoss();
                        break;
                    case 1:
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .addToBackStack(null).add(R.id.container, new BusFragment()).commitAllowingStateLoss();
                        break;

                    case 2:
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .addToBackStack(null).add(R.id.container, new RickshawFragment()).commitAllowingStateLoss();
                        break;

                    case 3:
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .addToBackStack(null).add(R.id.container, new TrainFragment()).commitAllowingStateLoss();
                        break;

                    default:
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .addToBackStack(null).add(R.id.container, new BusFragment()).commitAllowingStateLoss();
                        break;

                }


            }

            @Override
            public void itemCenterClick(View view) {

            }
        });

    }

}