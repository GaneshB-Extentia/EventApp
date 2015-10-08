package com.punehackers.eventapp.view;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.punehackers.eventapp.R;
import com.punehackers.eventapp.view.fragment.BusFragment;
import com.punehackers.eventapp.view.fragment.BusListFragment;
import com.punehackers.eventapp.view.fragment.CabFragment;
import com.punehackers.eventapp.view.fragment.HomeFragment;
import com.punehackers.eventapp.view.fragment.RickshawFragment;
import com.punehackers.eventapp.view.fragment.SplashFragment;
import com.punehackers.eventapp.view.fragment.TrainFragment;
import com.punehackers.eventapp.view.fragment.TutorialFragment;

import java.util.List;

/**
 * Created by user on 03-10-2015.
 */
public class EventActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener, View.OnClickListener  {

    private int mNavSelected = R.id.nav_home; // 0 is an invalid resId
    public DrawerLayout mDrawerLayout;
    public Fragment mCurrentFragment;
    public Toolbar mToolbar;
    private NavigationView mNavView;
    private CharSequence mTitle;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        initializeScreen();
        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                Fragment fragment=getSupportFragmentManager().findFragmentById(R.id.container);
                if(fragment!=null && fragment.getTag()!=null){
                    mToolbar.setTitle(fragment.getTag());
                }
            }
        });
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        id = item.getItemId();
        if (id != mNavSelected) {
            switch (id) {
                case R.id.nav_home:
                    popFragment(mCurrentFragment);
                    startHomeFragment();
                    break;
                case R.id.nav_bus:
                    popFragment(mCurrentFragment);
                    navigateToFragment(new BusFragment());
                    break;
                case R.id.nav_train:
                    popFragment(mCurrentFragment);
                    navigateToFragment(new TrainFragment());
                    break;
                case R.id.nav_cab:
                    popFragment(mCurrentFragment);
                    navigateToFragment(new CabFragment());
                    break;
                case R.id.nav_rickshaw:
                    popFragment(mCurrentFragment);
                    navigateToFragment(new RickshawFragment());
                    break;
                case R.id.nav_map:
                    popFragment(mCurrentFragment);
                    navigateToFragment(new HomeFragment());
                   break;
                case R.id.nav_profile:
                    popFragment(mCurrentFragment);
                    navigateToFragment(new TutorialFragment());
                    break;
            }
        }

        mNavSelected = id;
        mDrawerLayout.closeDrawers();
        item.setChecked(true);
        return true;
    }
    private void navigateToFragment(Fragment f) {
        mCurrentFragment=f;
            getSupportFragmentManager().beginTransaction().add(R.id.container, f,getTag(f)).addToBackStack(f.getClass().getSimpleName()).commit();

    }

    private void startHomeFragment()
    {
        List<Fragment> fragmentList=getSupportFragmentManager().getFragments();
        for(Fragment fragment:fragmentList)
        {
            if(fragment instanceof HomeFragment)
                getSupportFragmentManager().popBackStack(fragment.getClass().getSimpleName(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
        getSupportFragmentManager().beginTransaction().add(R.id.container, new HomeFragment()).addToBackStack(new HomeFragment().getClass().getSimpleName()).commit();

    }
    private void popFragment(Fragment f)
    {
            if(!(f instanceof HomeFragment))
            getSupportFragmentManager().popBackStack(f.getClass().getSimpleName(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
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
        mNavView = (NavigationView) findViewById(R.id.navView);
        mNavView.setNavigationItemSelectedListener(this);
        mCurrentFragment=new SplashFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mCurrentFragment).commit();
    }

    @Override
    public void onBackPressed() {
        mNavSelected=-1;
        if(getSupportFragmentManager().getBackStackEntryCount()==1)
        {
            finish();
        }
        else {
            super.onBackPressed();
        }
    }



    private String getTag(Fragment fragment)
    {
        String tag="";
            if (fragment instanceof HomeFragment) {
                tag= "Home";
            } else if (fragment instanceof BusFragment) {
                tag= "Bus";
            } else if (fragment instanceof TrainFragment) {
                tag= "Train";
            }
            else if (fragment instanceof BusListFragment) {
                tag= "Depot List";
            }
            else if (fragment instanceof CabFragment) {
                tag= "Cab";
            }
            else if (fragment instanceof TutorialFragment) {
                tag= "Register Now";
            }
            if (fragment instanceof RickshawFragment) {
                tag= "Rickshaw";
            }
        return tag;
    }
}
