package com.github.takumalee.simplematerialtabpager.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.github.takumalee.simplematerialtabpager.R;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.util.Random;

/**
 * Created by TakumaLee on 15/1/21.
 */
public class BaseMaterialBarView extends LinearLayout {
    private static final String TAG = BaseMaterialBarView.class.getSimpleName();

    @Deprecated
    private ActionBarActivity actionBarActivity;
    private AppCompatActivity appCompatActivity;
    private int type = TYPE.APP_COMPACT;

    public class TYPE {
        public static final int ACTION_BAR = 1;
        public static final int APP_COMPACT = 2;
    }

    protected Context context;
    private LayoutInflater inflater;
    private View view;
    private LinearLayout parent;
    private Toolbar toolbar;
    private FrameLayout frameLayout;

    private Drawable oldBackground = null;

    protected int currentColor;
    protected boolean isNeedActionBar = true;
    protected SystemBarTintManager systemBarTintManager;

    protected BaseMaterialBarView(Context context) {
        this(context, null);
        initSystemTintBar();
    }

    protected BaseMaterialBarView(Context context, int newColor) {
        super(context);
        this.context = context;
        checkActivityType(context);
        initView();
        setDefaultToobar();
        initSystemTintBar();
        changeBarColor(newColor == 0 ? getRandomBackgroundColor() : newColor);
    }

    protected BaseMaterialBarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        setDefaultToobar();
    }

    protected BaseMaterialBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        checkActivityType(context);
        initView();
    }

    private int checkActivityType(Context context) {
        if (context instanceof ActionBarActivity) {
            Log.v(TAG, "ActionBarActivity");
            initActivity(TYPE.ACTION_BAR);
            return TYPE.ACTION_BAR;
        } else if (context instanceof AppCompatActivity) {
            Log.v(TAG, "AppCompatActivity");
            initActivity(TYPE.APP_COMPACT);
            return TYPE.APP_COMPACT;
        }
        return TYPE.APP_COMPACT;
    }

    private void initActivity(int type) {
        this.type = type;
        switch (type) {
            case TYPE.ACTION_BAR:
                this.actionBarActivity = (ActionBarActivity) context;
                break;
            case TYPE.APP_COMPACT:
                this.appCompatActivity = (AppCompatActivity) context;
                break;
        }

    }

    private void initView() {
        this.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        this.setOrientation(VERTICAL);
        inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.material_bar, null);
        parent = (LinearLayout) view.findViewById(R.id.linearLayout_materialbar);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar_materialbar);
        frameLayout = (FrameLayout) view.findViewById(R.id.frameLayout_materialbar);

        this.addView(view);
    }

    private void initSystemTintBar() {
        systemBarTintManager = new SystemBarTintManager((Activity) context);
        systemBarTintManager.setStatusBarTintEnabled(true);
    }

    protected void setDefaultToobar() {
        if (isNeedActionBar) {
            switch (type) {
                case TYPE.ACTION_BAR:
                    this.actionBarActivity.setSupportActionBar(toolbar);
                    break;
                case TYPE.APP_COMPACT:
                    this.appCompatActivity.setSupportActionBar(toolbar);
                    break;
            }
        } else {
            getToolbar().setVisibility(GONE);
            getParentContainer().setFitsSystemWindows(false);
        }
    }

    public int getRandomBackgroundColor() {
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(64) + 256, rnd.nextInt(64) + 256, rnd.nextInt(64) + 256);
        return color;
    }

    public void changeTextColor(int newColor) {
        toolbar.setTitleTextColor(newColor);
    }

    public void changeBarColor(int newColor) {
        systemBarTintManager.setTintColor(newColor);
        // change ActionBar color just if an ActionBar is available
        Drawable colorDrawable = new ColorDrawable(newColor);
        Drawable bottomDrawable = new ColorDrawable(getResources().getColor(android.R.color.transparent));
        LayerDrawable ld = new LayerDrawable(new Drawable[]{colorDrawable, bottomDrawable});
        if (oldBackground == null) {
            setActionBarBackgroundDrawable(ld);
        } else {
            TransitionDrawable td = new TransitionDrawable(new Drawable[]{oldBackground, ld});
            setActionBarBackgroundDrawable(td);
            td.startTransition(200);
        }

        oldBackground = ld;
        currentColor = newColor;
    }

    private void setActionBarBackgroundDrawable(Drawable drawable) {
        switch (type) {
            case TYPE.ACTION_BAR:
                this.actionBarActivity.getSupportActionBar().setBackgroundDrawable(drawable);
                break;
            case TYPE.APP_COMPACT:
                this.appCompatActivity.getSupportActionBar().setBackgroundDrawable(drawable);
                break;
        }
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public FrameLayout getFrameLayout() {
        return frameLayout;
    }

    public LinearLayout getBarParent() {
        return parent;
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

    public View getParentContainer() {
        return parent;
    }

    protected FragmentManager getContextFragmentManager() {
        switch (type) {
            case TYPE.ACTION_BAR:
                return actionBarActivity.getSupportFragmentManager();
            case TYPE.APP_COMPACT:
                return appCompatActivity.getSupportFragmentManager();
            default:
                return appCompatActivity.getSupportFragmentManager();
        }
    }
}
