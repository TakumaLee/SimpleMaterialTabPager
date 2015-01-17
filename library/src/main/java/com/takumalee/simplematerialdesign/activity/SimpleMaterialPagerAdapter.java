package com.takumalee.simplematerialdesign.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.takumalee.simplematerialdesign.entity.MaterialPagerEntity;

import java.util.List;

/**
 * Created by TakumaLee on 15/1/12.
 */
public class SimpleMaterialPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = SimpleMaterialPagerAdapter.class.getSimpleName();

    private List<MaterialPagerEntity> mPagerEntities;

    public SimpleMaterialPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setmPagerEntities(List<MaterialPagerEntity> mPagerEntities) {
        this.mPagerEntities = mPagerEntities;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mPagerEntities.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {
        return mPagerEntities.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return mPagerEntities.size();
    }
}
