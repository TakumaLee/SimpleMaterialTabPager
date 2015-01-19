package com.takumalee.simplematerialpager.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.astuetz.PagerSlidingTabStrip;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.takumalee.simplematerialdesign.R;
import com.takumalee.simplematerialpager.activity.SimpleMaterialPagerAdapter;
import com.takumalee.simplematerialpager.manager.MaterialFragmentManager;

/**
 * Created by TakumaLee on 15/1/16.
 *
 */
public class SimpleMaterialPagerView extends FrameLayout {
    private static final String TAG = SimpleMaterialPagerView.class.getSimpleName();

    private MaterialFragmentManager mFManager = new MaterialFragmentManager();

    private ActionBarActivity actionBarActivity;
    private Context context;
    private LayoutInflater inflater;
    private View view;
    private Toolbar toolbar;
    private PagerSlidingTabStrip tabs;
    private ViewPager viewPager;

    private SystemBarTintManager systemBarTintManager;
    private SimpleMaterialPagerAdapter adapter;

    private Drawable oldBackground = null;
    private int currentColor;

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

    private void initView() {
        inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.material_pager, null);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        viewPager = (ViewPager) view.findViewById(R.id.pager);
        actionBarActivity.setSupportActionBar(toolbar);
//        ((ActionBarActivity)context).getSupportActionBar().setDisplayShowHomeEnabled(true);
//        ((ActionBarActivity)context).getSupportActionBar().setLogo(R.drawable.ic_menu_white);

        systemBarTintManager = new SystemBarTintManager((Activity) context);
        systemBarTintManager.setStatusBarTintEnabled(true);

        changeColor(context.getResources().getColor(R.color.green));
        this.addView(view);
    }

    public void createNewPage(String title, Fragment fragment) {
        mFManager.createNewInstance(title, fragment);
    }

    public void setMaterialPagerAdapter() {
        adapter = new SimpleMaterialPagerAdapter(actionBarActivity.getSupportFragmentManager());
        adapter.setmPagerEntities(mFManager.getEntities());
        viewPager.setAdapter(adapter);

//        LinearLayout.LayoutParams tabParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, Math.round(48 * getResources().getDisplayMetrics().density));
        tabs.setShouldExpand(true);
        tabs.setViewPager(viewPager);
//        tabs.setLayoutParams(tabParams);
    }

    public void changeTextColor(int newColor) {
        toolbar.setTitleTextColor(newColor);
        tabs.setTextColor(newColor);
    }

    public void changeColor(int newColor) {
        tabs.setBackgroundColor(newColor);
        systemBarTintManager.setTintColor(newColor);
        // change ActionBar color just if an ActionBar is available
        Drawable colorDrawable = new ColorDrawable(newColor);
        Drawable bottomDrawable = new ColorDrawable(getResources().getColor(android.R.color.transparent));
        LayerDrawable ld = new LayerDrawable(new Drawable[]{colorDrawable, bottomDrawable});
        if (oldBackground == null) {
            actionBarActivity.getSupportActionBar().setBackgroundDrawable(ld);
        } else {
            TransitionDrawable td = new TransitionDrawable(new Drawable[]{oldBackground, ld});
            actionBarActivity.getSupportActionBar().setBackgroundDrawable(td);
            td.startTransition(200);
        }

        oldBackground = ld;
        currentColor = newColor;
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public PagerSlidingTabStrip getTabs() {
        return tabs;
    }

    public ViewPager getViewPager() {
        return viewPager;
    }

    public SimpleMaterialPagerAdapter getAdapter() {
        return adapter;
    }
}
