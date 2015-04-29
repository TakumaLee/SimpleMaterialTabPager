package com.github.takumalee.simplematerialtabpager.adapter;

import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;

import com.github.takumalee.simplematerialtabpager.view.PagerSlidingTabStrip;

/**
 * Created by TakumaLee on 15/4/29.
 */
public class CustomMaterialMaterialTabFragmentAdapter extends BaseMaterialTabFragmentAdapter implements PagerSlidingTabStrip.CustomTabProvider {
    private static final String TAG = CustomMaterialMaterialTabFragmentAdapter.class.getSimpleName();

    public CustomMaterialMaterialTabFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public View getCustomTabView(ViewGroup parent, int position) {
        return mPagerEntities.get(position).getCustomTabView();
    }
}
