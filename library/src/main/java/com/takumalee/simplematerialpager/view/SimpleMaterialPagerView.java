package com.takumalee.simplematerialpager.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.astuetz.PagerSlidingTabStrip;
import com.takumalee.simplematerialpager.R;
import com.takumalee.simplematerialpager.adapter.SimpleMaterialPagerFragmentAdapter;
import com.takumalee.simplematerialpager.manager.MaterialFragmentManager;

/**
 * Created by TakumaLee on 15/1/16.
 *
 */
public class SimpleMaterialPagerView extends LinearLayout {
    private static final String TAG = SimpleMaterialPagerView.class.getSimpleName();

    private MaterialFragmentManager mFManager = new MaterialFragmentManager();

    private ActionBarActivity actionBarActivity;
    private Context context;
    private LayoutInflater inflater;
    private SimpleMaterialBarView barView;
    private View view;
    private PagerSlidingTabStrip tabs;
    private ViewPager viewPager;

    private SimpleMaterialPagerFragmentAdapter adapter;

    private Drawable oldBackground = null;
    private int currentColor;
    private boolean isNeedActionBar = true;

    public SimpleMaterialPagerView(Context context) {
        super(context);
        this.context = context;
        this.actionBarActivity = (ActionBarActivity) context;
        initView();
    }

    public SimpleMaterialPagerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
    }

    public SimpleMaterialPagerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView();
    }

    public SimpleMaterialPagerView(Context context, boolean isNeedActionBar) {
        super(context);
        this.context = context;
        this.actionBarActivity = (ActionBarActivity) context;
        this.isNeedActionBar = isNeedActionBar;
        initView();
    }

    public SimpleMaterialPagerView(Context context, AttributeSet attrs, boolean isNeedActionBar) {
        super(context, attrs);
        this.context = context;
        this.isNeedActionBar = isNeedActionBar;
        initView();
    }

    public SimpleMaterialPagerView(Context context, AttributeSet attrs, int defStyleAttr, boolean isNeedActionBar) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        this.isNeedActionBar = isNeedActionBar;
        initView();
    }

    private void initView() {
        this.setOrientation(VERTICAL);
        inflater = LayoutInflater.from(context);

        view = inflater.inflate(R.layout.material_pager, null);
        tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        viewPager = (ViewPager) view.findViewById(R.id.pager);


        if (isNeedActionBar) {
            barView = new SimpleMaterialBarView(context);
            changeColor(barView.getRandomBackgroundColor());
            barView.getFrameLayout().addView(view);
            this.addView(barView);
        } else {
            this.addView(view);
        }
    }

    public void createNewPage(String title, View view) {
        mFManager.createNewInstance(title, view);
    }

    public void createNewPage(String title, Fragment fragment) {
        mFManager.createNewInstance(title, fragment);
    }

    public void setMaterialPagerAdapter() {
        adapter = new SimpleMaterialPagerFragmentAdapter(actionBarActivity.getSupportFragmentManager());
        adapter.setmPagerEntities(mFManager.getEntities());
        viewPager.setAdapter(adapter);

//        LinearLayout.LayoutParams tabParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, Math.round(48 * getResources().getDisplayMetrics().density));
        tabs.setShouldExpand(true);
        tabs.setViewPager(viewPager);
//        tabs.setLayoutParams(tabParams);
    }

    public void changeTextColor(int newColor) {
        barView.changeTextColor(newColor);
        if (isNeedActionBar) tabs.setTextColor(newColor);
    }

    public void changeColor(int newColor) {
        tabs.setBackgroundColor(newColor);
        if (isNeedActionBar) barView.changeColor(newColor);
    }

    public Toolbar getToolbar() {
        return barView.getToolbar();
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
