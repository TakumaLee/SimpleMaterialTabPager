package com.github.takumalee.simplematerialtabpager.manager;

import android.support.v4.app.Fragment;
import android.view.View;

import com.github.takumalee.simplematerialtabpager.entity.MaterialPagerEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TakumaLee on 15/1/17.
 */
public class MaterialFragmentManager {

    private List<MaterialPagerEntity> entities = new ArrayList<MaterialPagerEntity>();

    public void createNewInstance(String title, Fragment fragment) {
        MaterialPagerEntity entity = new MaterialPagerEntity();
        entity.setTitle(title);
        entity.setFragment(fragment);
        entities.add(entity);
    }

    public void createNewInstance(String title, View view) {
        MaterialPagerEntity entity = new MaterialPagerEntity();
        entity.setTitle(title);
        entity.setView(view);
        entities.add(entity);
    }

    public void createNewInstance(View customTabView, Fragment fragment) {
        MaterialPagerEntity entity = new MaterialPagerEntity();
        entity.setCustomTabView(customTabView);
        entity.setFragment(fragment);
        entities.add(entity);
    }

    public void createNewInstance(View customTabView, View view) {
        MaterialPagerEntity entity = new MaterialPagerEntity();
        entity.setCustomTabView(customTabView);
        entity.setView(view);
        entities.add(entity);
    }

    public void createNewInstance(int resId, Fragment fragment) {
        MaterialPagerEntity entity = new MaterialPagerEntity();
        entity.setResIcon(resId);
        entity.setFragment(fragment);
        entities.add(entity);
    }

    public void createNewInstance(int resId, View view) {
        MaterialPagerEntity entity = new MaterialPagerEntity();
        entity.setResIcon(resId);
        entity.setView(view);
        entities.add(entity);
    }

    public List<MaterialPagerEntity> getEntities() {
        return entities;
    }
}
