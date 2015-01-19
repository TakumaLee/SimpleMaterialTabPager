package com.takumalee.simplematerialpager.example;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.RelativeLayout;

import com.takumalee.simplematerialpager.activity.SimpleMaterialPagerDrawerActivity;
import com.takumalee.simplematerialpager.activity.SuperAwesomeCardFragment;
import com.takumalee.simplematerialpager.view.SimpleMaterialPagerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends SimpleMaterialPagerDrawerActivity {

    RelativeLayout relativeLayout;
    SimpleMaterialPagerView smPagerView;
    List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createNewPage("1", SuperAwesomeCardFragment.newInstance(1));
        createNewPage("2", SuperAwesomeCardFragment.newInstance(2));
        createNewPage("3", SuperAwesomeCardFragment.newInstance(3));
        createNewPage("4", SuperAwesomeCardFragment.newInstance(4));
        setMaterialPagerAdapter();
        getFrameContainer().addView(new View(this));
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
