package com.github.takumalee.simplematerialpager.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;
import com.github.takumalee.simplematerialpager.R;
import com.github.takumalee.simplematerialpager.adapter.SimpleMaterialPagerFragmentAdapter;
import com.github.takumalee.simplematerialpager.manager.MaterialFragmentManager;
import com.readystatesoftware.systembartint.SystemBarTintManager;

/**
 * Created by TakumaLee on 15/1/16.
 *
 */
public class SimpleMaterialPagerView extends SimpleMaterialBarView {
    private static final String TAG = SimpleMaterialPagerView.class.getSimpleName();

    private MaterialFragmentManager mFManager = new MaterialFragmentManager();

    private LayoutInflater inflater;
    private View view;
    private PagerSlidingTabStrip tabs;
    private ViewPager viewPager;

    private SimpleMaterialPagerFragmentAdapter adapter;

    private SystemBarTintManager systemBarTintManager;

    private Drawable oldBackground = null;
    private int currentColor;
    private boolean isNeedActionBar = true;

    public SimpleMaterialPagerView(Context context) {
        super(context);
        initView();
    }

    public SimpleMaterialPagerView(Context context, boolean isNeedActionBar) {
        super(context);
        this.isNeedActionBar = isNeedActionBar;
        initView();
    }

    private void initView() {
        this.setOrientation(VERTICAL);
        inflater = LayoutInflater.from(context);

        view = inflater.inflate(R.layout.material_pager, null);
        tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        viewPager = (ViewPager) view.findViewById(R.id.pager);

        getFrameLayout().addView(view);

        if (!isNeedActionBar) {
            getToolbar().setVisibility(GONE);
        }
    }

    public void createNewPage(String title, View view) {
        mFManager.createNewInstance(title, view);
    }

    public void createNewPage(String title, Fragment fragment) {
        mFManager.createNewInstance(title, fragment);
    }

    public void setMaterialPagerAdapter() {
        adapter = new SimpleMaterialPagerFragmentAdapter(getContextFragmentManager());
        adapter.setmPagerEntities(mFManager.getEntities());
        viewPager.setAdapter(adapter);

        tabs.setShouldExpand(true);
        tabs.setViewPager(viewPager);
    }

    public void setChildMaterialPagerAdapter(FragmentManager fm) {
        adapter = new SimpleMaterialPagerFragmentAdapter(fm);
        adapter.setmPagerEntities(mFManager.getEntities());
        viewPager.setAdapter(adapter);

        tabs.setShouldExpand(true);
        tabs.setViewPager(viewPager);
    }

    public void changeTextColor(int newColor) {
        tabs.setTextColor(newColor);
        if (isNeedActionBar) changeTextColor(newColor);
    }

    public void changeAllColor(int newColor) {
        tabs.setBackgroundColor(newColor);
        if (isNeedActionBar) super.changeBarColor(newColor);
    }

    public void changeStatusBarColor(int newColor) {
        systemBarTintManager = new SystemBarTintManager((Activity) context);
        systemBarTintManager.setStatusBarTintEnabled(true);
        systemBarTintManager.setTintColor(newColor);
    }

    public void changeIndicatorColor(int newColor) {
        tabs.setIndicatorColor(newColor);
    }

    public PagerSlidingTabStrip getTabs() {
        return tabs;
    }

    public ViewPager getViewPager() {
        return viewPager;
    }

    public SimpleMaterialPagerFragmentAdapter getAdapter() {
        return adapter;
    }
}
