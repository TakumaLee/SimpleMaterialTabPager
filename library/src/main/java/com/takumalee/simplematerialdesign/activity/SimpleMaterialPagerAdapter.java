package com.takumalee.simplematerialdesign.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by TakumaLee on 15/1/12.
 */
public class SimpleMaterialPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = SimpleMaterialPagerAdapter.class.getSimpleName();


    private String[] titleName;
    private List<Fragment> fragmentList;

    public SimpleMaterialPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleName[position];
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return titleName.length;
    }

    public void setTitleName(String[] titleName) {
        this.titleName = titleName;
    }

    public void setFragmentList(List<Fragment> fragmentList) {
        this.fragmentList = fragmentList;
    }
}
