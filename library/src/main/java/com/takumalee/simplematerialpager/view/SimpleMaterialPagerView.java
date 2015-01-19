package com.takumalee.simplematerialpager.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.astuetz.PagerSlidingTabStrip;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.takumalee.simplematerialdesign.R;
import com.takumalee.simplematerialpager.activity.SimpleMaterialPagerAdapter;

/**
 * Created by TakumaLee on 15/1/16.
 *
 */
@Deprecated
public class SimpleMaterialPagerView extends FrameLayout {
    private static final String TAG = SimpleMaterialPagerView.class.getSimpleName();

    private Context context;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private PagerSlidingTabStrip tabs;
    private ViewPager viewPager;

    private SystemBarTintManager systemBarTintManager;
    private SimpleMaterialPagerAdapter adapter;

    private Drawable oldBackground = null;
    private int currentColor;

    public SimpleMaterialPagerView(Context context) {
        super(context);
        this.context = context;
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
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.pager);
        ((ActionBarActivity)context).setSupportActionBar(toolbar);
        ((ActionBarActivity)context).getSupportActionBar().setDisplayShowHomeEnabled(true);
        ((ActionBarActivity)context).getSupportActionBar().setLogo(R.drawable.ic_menu_white);

        systemBarTintManager = new SystemBarTintManager((ActionBarActivity)context);
        systemBarTintManager.setStatusBarTintEnabled(true);

        drawerLayout.setStatusBarBackgroundColor(0);

        adapter = new SimpleMaterialPagerAdapter(((ActionBarActivity)context).getSupportFragmentManager());
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
            ((ActionBarActivity)context).getSupportActionBar().setBackgroundDrawable(ld);
        } else {
            TransitionDrawable td = new TransitionDrawable(new Drawable[]{oldBackground, ld});
            ((ActionBarActivity)context).getSupportActionBar().setBackgroundDrawable(td);
            td.startTransition(200);
        }

        oldBackground = ld;
        currentColor = newColor;
    }
}
