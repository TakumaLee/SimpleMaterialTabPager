package com.github.takumalee.simplematerialtabpager.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.github.takumalee.simplematerialtabpager.entity.MaterialPagerEntity;

import java.util.List;

/**
 * Created by TakumaLee on 15/1/21.
 */
public class SimpleMaterialPagerViewAdapter extends PagerAdapter {

    private static final String TAG = SimpleMaterialPagerViewAdapter.class.getSimpleName();

    private List<MaterialPagerEntity> mPagerEntities;

    public SimpleMaterialPagerViewAdapter() {

    }

    public void setmPagerEntities(List<MaterialPagerEntity> mPagerEntities) {
        this.mPagerEntities = mPagerEntities;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mPagerEntities.get(position).getTitle();
    }

    @Override
    public int getCount() {
        return mPagerEntities.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return mPagerEntities.get(position).getView();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
