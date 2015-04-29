package com.github.takumalee.simplematerialtabpager.adapter;

import android.support.v4.app.FragmentManager;

import com.github.takumalee.simplematerialtabpager.view.PagerSlidingTabStrip;

/**
 * Created by TakumaLee on 15/4/29.
 */
public class IconMaterialTabFragmentAdapter extends BaseMaterialTabFragmentAdapter implements PagerSlidingTabStrip.IconTabProvider {
    public IconMaterialTabFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getPageIconResId(int position) {
        return mPagerEntities.get(position).getResIcon();
    }
}
