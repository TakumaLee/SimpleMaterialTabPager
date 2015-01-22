package com.takumalee.simplematerialpager.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.takumalee.simplematerialpager.R;

/**
 * Created by TakumaLee on 15/1/21.
 */
public class SimpleMaterialBarView extends LinearLayout {
    private static final String TAG = SimpleMaterialBarView.class.getSimpleName();

    private ActionBarActivity actionBarActivity;
    private Context context;
    private LayoutInflater inflater;
    private View view;
    private Toolbar toolbar;
    private FrameLayout frameLayout;

    private SystemBarTintManager systemBarTintManager;

    private Drawable oldBackground = null;
    private int currentColor;

    public SimpleMaterialBarView(Context context) {
        super(context);
        this.context = context;
        this.actionBarActivity = (ActionBarActivity) context;
        initView(0);
    }

    public SimpleMaterialBarView(Context context, int newColor) {
        super(context);
        this.context = context;
        this.actionBarActivity = (ActionBarActivity) context;
        initView(newColor);
    }

    public SimpleMaterialBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView(0);
    }

    public SimpleMaterialBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView(0);
    }

    private void initView(int newColor) {
        this.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        this.setOrientation(VERTICAL);
        inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.material_bar, null);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar_materialbar);
        frameLayout = (FrameLayout) view.findViewById(R.id.frameLayout_materialbar);
        actionBarActivity.setSupportActionBar(toolbar);
//        ((ActionBarActivity)context).getSupportActionBar().setDisplayShowHomeEnabled(true);
//        ((ActionBarActivity)context).getSupportActionBar().setLogo(R.drawable.ic_menu_white);

        systemBarTintManager = new SystemBarTintManager((Activity) context);
        systemBarTintManager.setStatusBarTintEnabled(true);

        changeColor(newColor == 0 ? context.getResources().getColor(R.color.green) : newColor);
        this.addView(view);
    }

    public void changeTextColor(int newColor) {
        toolbar.setTitleTextColor(newColor);
    }

    public void changeColor(int newColor) {
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

    public FrameLayout getFrameLayout() {
        return frameLayout;
    }

    public SystemBarTintManager getSystemBarTintManager() {
        return systemBarTintManager;
    }

    public int getCurrentColor() {
        return currentColor;
    }

    public Drawable getOldBackground() {
        return oldBackground;
    }
}
