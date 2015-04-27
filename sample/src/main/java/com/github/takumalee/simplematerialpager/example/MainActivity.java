package com.github.takumalee.simplematerialpager.example;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.RelativeLayout;

import com.github.takumalee.simplematerialpager.example.fragment.SuperAwesomeCardFragment;
import com.github.takumalee.simplematerialpager.view.SimpleMaterialPagerView;


public class MainActivity extends ActionBarActivity {

    RelativeLayout relativeLayout;
    private SimpleMaterialPagerView mPagerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = (RelativeLayout) findViewById(R.id.relative_Main);
        mPagerView = new SimpleMaterialPagerView(this);
        mPagerView.setFitsSystemWindows(false);
        mPagerView.createNewPage("1", SuperAwesomeCardFragment.newInstance(1));
        mPagerView.createNewPage("2", SuperAwesomeCardFragment.newInstance(2));
//        mPagerView.createNewPage("3", SuperAwesomeCardFragment.newInstance(3));
//        mPagerView.createNewPage("4", SuperAwesomeCardFragment.newInstance(4));
        mPagerView.setMaterialPagerAdapter();
        mPagerView.changeAllColor(getResources().getColor(android.R.color.holo_blue_bright));
        mPagerView.changeStatusBarColor(getResources().getColor(android.R.color.holo_blue_bright));
        relativeLayout.addView(mPagerView);
//        createNewPage("1", SuperAwesomeCardFragment.newInstance(1));
//        createNewPage("2", SuperAwesomeCardFragment.newInstance(2));
//        createNewPage("3", SuperAwesomeCardFragment.newInstance(3));
//        createNewPage("4", SuperAwesomeCardFragment.newInstance(4));
//        setMaterialPagerAdapter();
//        getFrameContainer().addView(new View(this));
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
