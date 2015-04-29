package com.github.takumalee.simplematerialtabpager.entity;

import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by TakumaLee on 15/1/17.
 */
public class MaterialPagerEntity {
    private Fragment fragment;
    private View view;
    private String title;
    private View customTabView;
    private int resIcon;

    public Fragment getFragment() {
        return fragment;
    }

    public String getTitle() {
        return title;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setFragment(Fragment fragment) {

        this.fragment = fragment;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public View getCustomTabView() {
        return customTabView;
    }

    public void setCustomTabView(View customTabView) {
        this.customTabView = customTabView;
    }

    public int getResIcon() {
        return resIcon;
    }

    public void setResIcon(int resIcon) {
        this.resIcon = resIcon;
    }
}
