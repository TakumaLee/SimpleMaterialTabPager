package com.github.takumalee.simplematerialtabpager.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
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
public class SimpleMaterialTabPagerView extends BaseMaterialBarView {
    private static final String TAG = SimpleMaterialTabPagerView.class.getSimpleName();

    private LayoutInflater inflater;

    private View view;
    private PagerSlidingTabStrip tabs;
    private ViewPager viewPager;
    private BaseMaterialTabFragmentAdapter adapter;

    private Drawable oldBackground = null;

    private int currentColor;

    private MTP adapterType = MTP.DEFAULT;
    private boolean isParentFragment = false;
    private FragmentManager fragmentManager;
    private MaterialFragmentManager mFManager = new MaterialFragmentManager();

    private SimpleMaterialTabPagerView(Context context, Builder builder) {
        this(context, null, builder);
        setAdapter();
    }

    public SimpleMaterialTabPagerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        tabs.setIndicatorHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, tabs.getIndicatorHeight() / dm.density, dm));
        tabs.setDividerPadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, tabs.getDividerPadding(), dm));
        tabs.setTabPaddingLeftRight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, tabs.getTabPaddingLeftRight(), dm));
        tabs.setDividerWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, tabs.getDividerWidth(), dm));
        tabs.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, tabs.getTextSize() / dm.density, dm));

        // get custom attrs
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SimpleMaterialTabPager);
        isNeedActionBar = a.getBoolean(R.styleable.SimpleMaterialTabPager_mtpIsNeedActionBar, false);
        tabs.setIndicatorColor(a.getColor(R.styleable.SimpleMaterialTabPager_mtpIndicatorColor, tabs.getIndicatorColor()));
        tabs.setDividerColor(a.getColor(R.styleable.SimpleMaterialTabPager_mtpDividerColor, tabs.getDividerColor()));
        tabs.setDividerWidth(a.getDimensionPixelSize(R.styleable.SimpleMaterialTabPager_mtpDividerWidth, tabs.getDividerWidth()));
        tabs.setIndicatorHeight(a.getDimensionPixelSize(R.styleable.SimpleMaterialTabPager_mtpIndicatorHeight, tabs.getIndicatorHeight()));
        tabs.setDividerPadding(a.getDimensionPixelSize(R.styleable.SimpleMaterialTabPager_mtpDividerPadding, tabs.getDividerPadding()));
        tabs.setTabPaddingLeftRight(a.getDimensionPixelSize(R.styleable.SimpleMaterialTabPager_mtpTabPaddingLeftRight, tabs.getTabPaddingLeftRight()));
        tabs.setBackgroundResource(a.getResourceId(R.styleable.SimpleMaterialTabPager_mtpTabBackground, tabs.getTabBackground()));
        tabs.setTabBackgroundColor(a.getColor(R.styleable.SimpleMaterialTabPager_mtpTabBackgroundColor, Color.WHITE));
        tabs.setShouldExpand(a.getBoolean(R.styleable.SimpleMaterialTabPager_mtpShouldExpand, tabs.getShouldExpand()));
        tabs.setScrollOffset(a.getDimensionPixelSize(R.styleable.SimpleMaterialTabPager_mtpScrollOffset, tabs.getScrollOffset()));
        tabs.setAllCaps(a.getBoolean(R.styleable.SimpleMaterialTabPager_mtpTextAllCaps, tabs.isTextAllCaps()));
        tabs.setIsPaddingMiddle(a.getBoolean(R.styleable.SimpleMaterialTabPager_mtpPaddingMiddle, tabs.isPaddingMiddle()));
        tabs.setTabTypefaceStyle(a.getInt(R.styleable.SimpleMaterialTabPager_mtpTextStyle, Typeface.NORMAL));
        tabs.setTabTypefaceSelectedStyle(a.getInt(R.styleable.SimpleMaterialTabPager_mtpTextSelectedStyle, Typeface.NORMAL));
        tabs.setTabTextColorSelected(a.getColorStateList(R.styleable.SimpleMaterialTabPager_mtpTextColorSelected));
        tabs.setTextAlpha(a.getInt(R.styleable.SimpleMaterialTabPager_mtpTextAlpha, tabs.getTextAlpha()));
        tabs.setTextColor(a.getColor(R.styleable.SimpleMaterialTabPager_mtpTextColorPrimary, tabs.getTabTextColor().getDefaultColor()));
        a.recycle();

        setDefaultToobar();
    }

    public SimpleMaterialTabPagerView(Context context, AttributeSet attrs, Builder builder) {
        this(context, attrs, 0);
        setBuilder(builder);
        setDefaultToobar();
    }

    public SimpleMaterialTabPagerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }


    private void initView() {
        this.setOrientation(VERTICAL);
        inflater = LayoutInflater.from(context);

        view = inflater.inflate(R.layout.material_pager, null);
        tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        viewPager = (ViewPager) view.findViewById(R.id.pager);

        getFrameLayout().addView(view);
    }

    private void setAdapter() {
        if (adapterType == MTP.DEFAULT)
            setMaterialPagerAdapter(fragmentManager);
        else if (adapterType == MTP.ICON)
            setIconMaterialTabAdapter(fragmentManager);
        else if (adapterType == MTP.CUSTOM)
            setCustomMaterialTabAdapter(fragmentManager);
    }

    public void commit(Builder builder) {
        setBuilder(builder);
        setAdapter();
    }

    private void setBuilder(Builder builder) {
        adapterType = builder.adapterType;
        mFManager = builder.mFManager;
        isNeedActionBar = builder.isNeedActionBar;
        isParentFragment = builder.isParetFragment;
        fragmentManager = isParentFragment ? builder.fragmentManager : getContextFragmentManager();
    }

    private void setMaterialPagerAdapter(FragmentManager fm) {
        adapter = new BaseMaterialTabFragmentAdapter(fm);
        setPagerAdapter();
    }

    private void setCustomMaterialTabAdapter(FragmentManager fm) {
        adapter = new CustomMaterialMaterialTabFragmentAdapter(fm);
        setPagerAdapter();
    }

    private void setIconMaterialTabAdapter(FragmentManager fm) {
        adapter = new IconMaterialTabFragmentAdapter(fm);
        setPagerAdapter();
    }

    private void setPagerAdapter() {
        adapter.setmPagerEntities(mFManager.getEntities());
        viewPager.setAdapter(adapter);

        tabs.setShouldExpand(true);
        tabs.setViewPager(viewPager);
    }

    public void changePrimaryColor(int newColor) {
        tabs.setTabBackgroundColor(newColor);
        changeStatusBarColor(newColor);
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

    @Override
    public void changeTextColor(int newColor) {
        tabs.setTextColor(newColor);
        super.changeTextColor(newColor);
    }

    public void changeTabTextWithIndicatorColor(int newColor) {
        changeTextColor(newColor);
        changeIndicatorColor(newColor);
    }

    public void changeTabBackgroundColor(int newColor) {
        tabs.setTabBackgroundColor(newColor);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener listener) {
        tabs.setOnPageChangeListener(listener);
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

        private Builder() {}

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
