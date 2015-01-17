package com.takumalee.simplematerialdesign.example;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.takumalee.simplematerialdesign.activity.SimpleMaterialPagerDrawerActivity;
import com.takumalee.simplematerialdesign.activity.SuperAwesomeCardFragment;
import com.takumalee.simplematerialdesign.view.SimpleMaterialPagerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends SimpleMaterialPagerDrawerActivity {

    RelativeLayout relativeLayout;
    SimpleMaterialPagerView smPagerView;
    List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (int i = 0; i < 4; i++)
            fragmentList.add(SuperAwesomeCardFragment.newInstance(i));
        setMaterialPagerAdapter(new String[]{"1", "3", "5", "8"}, fragmentList);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
