package com.punehackers.eventapp.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.punehackers.eventapp.R;
import com.punehackers.eventapp.view.fragment.HomeFragment;
import com.punehackers.eventapp.view.fragment.SplashFragment;


public class EventActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        moveToScreen(new SplashFragment());
    }


    public void moveToScreen(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment).addToBackStack(fragment.getClass().getName())
                .commitAllowingStateLoss();
    }

    @Override
    public void onBackPressed() {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.container);
        if (currentFragment instanceof HomeFragment) {
            finish();
        } else {
            super.onBackPressed();
        }
    }

}
