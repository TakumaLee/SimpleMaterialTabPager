package com.takumalee.simplematerialpager.view;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.takumalee.simplematerialpager.R;

/**
 * Created by TakumaLee on 15/1/21.
 */
public class IDrawerLayout extends FrameLayout {
    private static final String TAG = IDrawerLayout.class.getSimpleName();

    private Context context;
    private LayoutInflater inflater;
    private View view;
    private DrawerLayout drawerLayout;
    private FrameLayout container;
    private FrameLayout drawerContainer;

    public IDrawerLayout(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    public IDrawerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
    }

    public IDrawerLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        initView();
    }

    private void initView() {
        inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.material_drawer, null);
        drawerLayout = (DrawerLayout) view.findViewById(R.id.drawerlayout);
        container = (FrameLayout) view.findViewById(R.id.frameLayout_container_materialdrawer);
        drawerContainer = (FrameLayout) view.findViewById(R.id.frameLayout_drawercontent_materialdrawer);
        this.addView(view);
    }

    public DrawerLayout getDrawerLayout() {
        return drawerLayout;
    }

    public FrameLayout getContainer() {
        return container;
    }

    public FrameLayout getDrawerContainer() {
        return drawerContainer;
    }
}
