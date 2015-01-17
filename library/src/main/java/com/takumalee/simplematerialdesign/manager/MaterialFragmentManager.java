package com.takumalee.simplematerialdesign.manager;

import android.support.v4.app.Fragment;

import com.takumalee.simplematerialdesign.entity.MaterialPagerEntity;

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

    public List<MaterialPagerEntity> getEntities() {
        return entities;
    }
}
