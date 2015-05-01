package com.github.takumalee.simplematerialtabpager.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.github.takumalee.simplematerialtabpager.R;
import com.github.takumalee.simplematerialtabpager.adapter.BaseMaterialTabFragmentAdapter;
import com.github.takumalee.simplematerialtabpager.adapter.CustomMaterialMaterialTabFragmentAdapter;
import com.github.takumalee.simplematerialtabpager.adapter.IconMaterialTabFragmentAdapter;
import com.github.takumalee.simplematerialtabpager.manager.MaterialFragmentManager;
import com.readystatesoftware.systembartint.SystemBarTintManager;

/**
 * Created by TakumaLee on 15/1/16.
 *
 */
public class SimpleMaterialTabPagerView extends SimpleMaterialBarView {
    private static final String TAG = SimpleMaterialTabPagerView.class.getSimpleName();

    private LayoutInflater inflater;

    private View view;
    private PagerSlidingTabStrip tabs;
    private ViewPager viewPager;
    private BaseMaterialTabFragmentAdapter adapter;

    private SystemBarTintManager systemBarTintManager;

    private Drawable oldBackground = null;

    private int currentColor;

    private MTP adapterType = MTP.DEFAULT;
    private boolean isNeedActionBar = false;
    private boolean isParentFragment = false;
    private FragmentManager fragmentManager;
    private MaterialFragmentManager mFManager = new MaterialFragmentManager();

    private SimpleMaterialTabPagerView(Context context, Builder builder) {
        super(context);
        adapterType = builder.adapterType;
        mFManager = builder.mFManager;
        isNeedActionBar = builder.isNeedActionBar;
        isParentFragment = builder.isParetFragment;
        fragmentManager = isParentFragment ? builder.fragmentManager : getContextFragmentManager();
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

        if (adapterType == MTP.DEFAULT)
                setMaterialPagerAdapter(fragmentManager);
        else if (adapterType == MTP.ICON)
                setIconMaterialTabAdapter(fragmentManager);
        else if (adapterType == MTP.CUSTOM)
                setCustomMaterialTabAdapter(fragmentManager);
    }

    public void setMaterialPagerAdapter(FragmentManager fm) {
        adapter = new BaseMaterialTabFragmentAdapter(fm);
        setPagerAdapter();
    }

    public void setCustomMaterialTabAdapter(FragmentManager fm) {
        adapter = new CustomMaterialMaterialTabFragmentAdapter(fm);
        setPagerAdapter();
    }

    public void setIconMaterialTabAdapter(FragmentManager fm) {
        adapter = new IconMaterialTabFragmentAdapter(fm);
        setPagerAdapter();
    }

    private void setPagerAdapter() {
        adapter.setmPagerEntities(mFManager.getEntities());
        viewPager.setAdapter(adapter);

        tabs.setShouldExpand(true);
        tabs.setViewPager(viewPager);
    }

    @Override
    public void changeTextColor(int newColor) {
        tabs.setTextColor(newColor);
        if (isNeedActionBar) super.changeTextColor(newColor);
    }

    public void changePrimaryTitleColor(int newColor) {
        changeTextColor(newColor);
        changeIndicatorColor(newColor);
    }

    public void changeTopicColor(int newColor) {
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

    public BaseMaterialTabFragmentAdapter getAdapter() {
        return adapter;
    }

    public static class Builder {

        private MTP adapterType = MTP.DEFAULT;

        private boolean isNeedActionBar = false;

        private boolean isParetFragment = false;

        private FragmentManager fragmentManager;

        private MaterialFragmentManager mFManager = new MaterialFragmentManager();

        public Builder(MTP adapterType) {
            this.adapterType = adapterType;
        }

        public Builder disableActionBar() {
            isNeedActionBar = false;
            return this;
        }

        /**
         *  Default
         * */
        public Builder enableActionBar() {
            isNeedActionBar = true;
            return this;
        }

        /**
         *  When this view initial in fragment, and it has child fragment, need to enable
         * */
        public Builder enableChildFragmentManager(FragmentManager fm) {
            this.isParetFragment = true;
            this.fragmentManager = fm;
            return this;
        }

        public Builder addSection(String title, View view) {
            mFManager.createNewInstance(title, view);
            return this;
        }

        public Builder addSection(String title, Fragment fragment) {
            mFManager.createNewInstance(title, fragment);
            return this;
        }

        public Builder addSection(View customTabView, View view) {
            mFManager.createNewInstance(customTabView, view);
            return this;
        }

        public Builder addSection(View customTabView, Fragment fragment) {
            mFManager.createNewInstance(customTabView, fragment);
            return this;
        }

        public Builder addSection(int drawableId, View view) {
            mFManager.createNewInstance(drawableId, view);
            return this;
        }

        public Builder addSection(int drawableId, Fragment fragment) {
            mFManager.createNewInstance(drawableId, fragment);
            return this;
        }

        public SimpleMaterialTabPagerView build(Context context) {
            return new SimpleMaterialTabPagerView(context, this);
        }

    }
}
