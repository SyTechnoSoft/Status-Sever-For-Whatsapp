package com.statusseverforwhatsapp.adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.statusseverforwhatsapp.fragments.ImageFragment;
import com.statusseverforwhatsapp.fragments.VideoFragment;


public class ViewPagerAdapter extends FragmentPagerAdapter {
    private Context myContext;
    int totalTabs;

    public ViewPagerAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ImageFragment learn_fragment = new ImageFragment();
                return learn_fragment;
            case 1:
                VideoFragment test_fragment = new VideoFragment();
                return test_fragment;

            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }

}
