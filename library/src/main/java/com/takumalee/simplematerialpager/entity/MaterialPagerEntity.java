package com.takumalee.simplematerialpager.entity;

import android.support.v4.app.Fragment;

/**
 * Created by TakumaLee on 15/1/17.
 */
public class MaterialPagerEntity {
    private Fragment fragment;
    private String title;

    public Fragment getFragment() {
        return fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setFragment(Fragment fragment) {

        this.fragment = fragment;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
