package com.punehackers.eventapp.view;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.punehackers.eventapp.R;
import com.punehackers.eventapp.view.fragment.HomeFragment;
import com.punehackers.eventapp.view.fragment.SplashFragment;

/**
 * Created by user on 03-10-2015.
 */
public class EventActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener, View.OnClickListener  {

    private int mNavSelected = R.id.nav_home; // 0 is an invalid resId
    public DrawerLayout mDrawerLayout;
    private Fragment mCurrentFragment;
    public Toolbar mToolbar;
    private CharSequence mTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        initializeScreen();
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id != mNavSelected) {
            switch (id) {
                case R.id.nav_home:
                    navigateToFragment(new HomeFragment());
                    break;
                case R.id.nav_bus:
                    Log.d("ShowPass", "from navigation");
//                     new ChoosePasswordDialog().show(getSupportFragmentManager(), "show_password_dialog");
                    navigateToFragment(new HomeFragment());
                    // Don't close drawer here, and don't select the menu item
//                    Toast.makeText(getBaseContext(), "Not Implemented! Coming Soon", Toast.LENGTH_LONG).show();
                    return false;
                case R.id.nav_train:
                    navigateToFragment(new HomeFragment());
//                    Toast.makeText(getBaseContext(), "Not Implemented! Coming Soon", Toast.LENGTH_LONG).show();
                    break;
                case R.id.nav_rickshaw:
                    navigateToFragment(new HomeFragment());
                    break;
                case R.id.nav_map:
                    navigateToFragment(new HomeFragment());
                    return false;
                case R.id.nav_profile:
                    navigateToFragment(new HomeFragment());
                    return false;
            }
        }

        mNavSelected = id;
        mDrawerLayout.closeDrawers();
        item.setChecked(true);
        return true;
    }
    private void navigateToFragment(Fragment f) {
        mCurrentFragment=f;
        if(f instanceof HomeFragment)
            getSupportFragmentManager().beginTransaction().add(R.id.container, f).addToBackStack(null).commit();
        else
            getSupportFragmentManager().beginTransaction().replace(R.id.container, f).commit();
    }
    private void initializeScreen()
    {
        mTitle = getTitle();

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle dt = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar,
                0, 0
        );
        getSupportActionBar().hide();
        if (mDrawerLayout != null)
            mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        mDrawerLayout.setDrawerListener(dt);
        dt.syncState();
        mCurrentFragment=new SplashFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mCurrentFragment).commit();
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount()==1)
        {
            finish();
        }
        else {
            super.onBackPressed();
        }
    }
}
