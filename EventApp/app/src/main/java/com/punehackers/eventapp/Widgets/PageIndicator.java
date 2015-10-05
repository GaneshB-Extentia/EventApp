/*
 * Copyright (C) 2011 Patrik Akerfeldt
 * Copyright (C) 2011 Jake Wharton
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.punehackers.eventapp.Widgets;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A PageIndicator is responsible to show an visual indicator on the total views
 * number and the current visible view.
 *
 * @version $Revision: 1.0 $
 */
public interface PageIndicator extends ViewPager.OnPageChangeListener {

    /**
     * Bind the indicator to a ViewPager.
     *
     * @param view the new view pager
     */
    void setViewPager(ViewPager view);

    /**
     * Method setViewPager.
     *
     * @param view       ViewPager
     * @param screenMode String
     */
    void setViewPager(ViewPager view, String screenMode);

    /**
     * Bind the indicator to a ViewPager.
     *
     * @param view            the view
     * @param initialPosition the initial position
     */
    void setViewPager(ViewPager view, int initialPosition);

    /**
     * <p>
     * Set the current page of both the ViewPager and indicator.
     * </p>
     * <p/>
     * <p>
     * This <strong>must</strong> be used if you need to set the page before
     * the views are drawn on screen (e.g., default start page).
     * </p>
     *
     * @param item the new current item
     */
    void setCurrentItem(int item);

    /**
     * Set a page change listener which will receive forwarded events.
     *
     * @param listener the new on page change listener
     */
    void setOnPageChangeListener(ViewPager.OnPageChangeListener listener);

    /**
     * Notify the indicator that the fragment list has changed.
     *
     * @param selectedtab int
     */
    void notifyDataSetChanged(int selectedtab);

    /**
     * Method setViewPager.
     *
     * @param view            ViewPager
     * @param tv              TextView
     * @param screenIndicator int
     * @param screenTitle     ArrayList<String>
     */
    void setViewPager(ViewPager view, TextView tv, int screenIndicator, ArrayList<String> screenTitle);

    /**
     * Method setViewPager.
     *
     * @param view          ViewPager
     * @param mapButton     ImageView
     * @param screenMode    String
     * @param flag          boolean
     * @param selectedIndex int
     * @param fromDashboard boolean
     */
    void setViewPager(ViewPager view, ImageView mapButton, String screenMode, boolean flag, int selectedIndex, boolean fromDashboard);

    /**
     * Method setViewPager.
     *
     * @param view      ViewPager
     * @param mapButton ImageView
     */
    void setViewPager(ViewPager view, ImageView mapButton);

}
