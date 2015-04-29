package com.github.takumalee.simplematerialtabpager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.github.takumalee.simplematerialtabpager.entity.MaterialPagerEntity;

import java.util.List;

/**
 * Created by TakumaLee on 15/1/12.
 */
public class BaseMaterialTabFragmentAdapter extends FragmentPagerAdapter {
    private static final String TAG = BaseMaterialTabFragmentAdapter.class.getSimpleName();

    private FragmentManager fragmentManager;
    protected List<MaterialPagerEntity> mPagerEntities;

    public BaseMaterialTabFragmentAdapter(FragmentManager fm) {
        super(fm);
        this.fragmentManager = fm;
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

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        fragmentManager.beginTransaction().remove((Fragment) object).commit();
    }
}
