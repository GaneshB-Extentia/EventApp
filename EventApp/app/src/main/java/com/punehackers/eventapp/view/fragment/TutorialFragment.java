package com.punehackers.eventapp.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.punehackers.eventapp.R;
import com.punehackers.eventapp.Widgets.CirclePageIndicator;
import com.punehackers.eventapp.Widgets.PageIndicator;

import java.util.ArrayList;

/**
 * Created by Chintamani.Kulkarni on 10/5/2015.
 */
public class TutorialFragment extends Fragment {

    private View rootView;
    private ArrayList<Integer> resourceIdList;
    ViewPager pager;
    private ImagePagerAdapter imagePageAdapter;
    protected PageIndicator indicator;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.tutorial_page,null);
        initializeScreen();
        return rootView;
    }

    private void initializeResourcesList()
    {
        resourceIdList=new ArrayList<Integer>();
        resourceIdList.add(R.drawable.img_tut_page1);
        resourceIdList.add(R.drawable.img_tut_page2);
        resourceIdList.add(R.drawable.img_tut_page3);
        resourceIdList.add(R.drawable.img_tut_page4);
        resourceIdList.add(R.drawable.img_tut_page5);
    }
    private void initializeScreen()
    {
        initializeResourcesList();
        imagePageAdapter = new ImagePagerAdapter();
        pager=(ViewPager)rootView.findViewById(R.id.pager);
        pager.setAdapter(imagePageAdapter);
        if (resourceIdList != null && resourceIdList.size() > 1) {
            indicator = (CirclePageIndicator) rootView.findViewById(R.id.indicator);
            indicator.setViewPager(pager);
        }
    }
    public Object handleInstantiateItem(ViewGroup collection, int position) {
        View layoutView = getActivity().getLayoutInflater().inflate(R.layout.tutorial_image_layout, collection, false);
        ImageView imageView = (ImageView) layoutView.findViewById(R.id.imageView);
        if(resourceIdList!=null && !resourceIdList.isEmpty())
        {
            imageView.setImageResource(resourceIdList.get(position));
        }
        collection.addView(layoutView);
        return layoutView;
    }
    private class ImagePagerAdapter extends PagerAdapter {

        public ImagePagerAdapter() {
        }

        @Override
        public int getCount() {
            return resourceIdList.size();
        }

        @Override
        public Object instantiateItem(ViewGroup collection, int position) {
            return handleInstantiateItem(collection, position);
        }

        @Override
        public void destroyItem(ViewGroup collection, int position, Object view) {
            collection.removeView((LinearLayout) view);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void finishUpdate(ViewGroup arg0) {
            // @see android.support.v4.view.PagerAdapter#finishUpdate(android.view.ViewGroup container)
        }

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {
            // @see android.support.v4.view.PagerAdapter#restoreState(android.os.Parcelable state, java.lang.ClassLoader
            // loader)
        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public void startUpdate(ViewGroup arg0) {
            // @see android.support.v4.view.PagerAdapter#startUpdate(android.view.View container)
        }
    }
}
