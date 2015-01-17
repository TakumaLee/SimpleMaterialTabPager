package com.takumalee.simplematerialdesign.activity;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.astuetz.PagerSlidingTabStrip;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.takumalee.simplematerialdesign.R;

import java.util.List;


public class SimpleMaterialPagerDrawerActivity extends ActionBarActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private FrameLayout frameLayout;
    private PagerSlidingTabStrip tabs;
    private ViewPager viewPager;

    private SystemBarTintManager systemBarTintManager;
    private SimpleMaterialPagerAdapter adapter;

    private Drawable oldBackground = null;
    private int currentColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout_DrawerContent);
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.pager);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_menu_white);

        systemBarTintManager = new SystemBarTintManager(this);
        systemBarTintManager.setStatusBarTintEnabled(true);

        drawerLayout.setStatusBarBackgroundColor(0);
    }

    protected void setMaterialPagerAdapter(String[] strings, List<Fragment> fragmentList) {
        adapter = new SimpleMaterialPagerAdapter(getSupportFragmentManager());
        adapter.setTitleName(strings);
        adapter.setFragmentList(fragmentList);
        viewPager.setAdapter(adapter);

//        LinearLayout.LayoutParams tabParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, Math.round(48 * getResources().getDisplayMetrics().density));
        tabs.setShouldExpand(true);
        tabs.setViewPager(viewPager);
//        tabs.setLayoutParams(tabParams);

        changeColor(getResources().getColor(R.color.green));
    }

    private void changeColor(int newColor) {
        tabs.setBackgroundColor(newColor);
        systemBarTintManager.setTintColor(newColor);
        // change ActionBar color just if an ActionBar is available
        Drawable colorDrawable = new ColorDrawable(newColor);
        Drawable bottomDrawable = new ColorDrawable(getResources().getColor(android.R.color.transparent));
        LayerDrawable ld = new LayerDrawable(new Drawable[]{colorDrawable, bottomDrawable});
        if (oldBackground == null) {
            getSupportActionBar().setBackgroundDrawable(ld);
        } else {
            TransitionDrawable td = new TransitionDrawable(new Drawable[]{oldBackground, ld});
            getSupportActionBar().setBackgroundDrawable(td);
            td.startTransition(200);
        }

        oldBackground = ld;
        currentColor = newColor;
    }

    public SimpleMaterialPagerAdapter getAdapter() {
        return adapter;
    }
}
