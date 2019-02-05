package com.example.android.projectname;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class PagerViewAdapter extends FragmentPagerAdapter {
    public PagerViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;
        switch (position){

            case 0:
                fragment = new fragment_page1();
                break;
            case 1:
                fragment = new fragment_page2();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}