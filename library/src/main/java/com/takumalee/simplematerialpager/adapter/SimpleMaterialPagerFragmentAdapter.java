package com.takumalee.simplematerialpager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.takumalee.simplematerialpager.entity.MaterialPagerEntity;

import java.util.List;

/**
 * Created by TakumaLee on 15/1/12.
 */
public class SimpleMaterialPagerFragmentAdapter extends FragmentPagerAdapter {
    private static final String TAG = SimpleMaterialPagerFragmentAdapter.class.getSimpleName();

    private List<MaterialPagerEntity> mPagerEntities;

    public SimpleMaterialPagerFragmentAdapter(FragmentManager fm) {
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
