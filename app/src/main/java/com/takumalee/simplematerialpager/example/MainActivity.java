package com.takumalee.simplematerialpager.example;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.RelativeLayout;

import com.takumalee.simplematerialpager.view.SimpleMaterialBarView;


public class MainActivity extends ActionBarActivity {

    RelativeLayout relativeLayout;
//    SimpleMaterialPagerView smPagerView;
//    List<Fragment> fragmentList = new ArrayList<>();
    private SimpleMaterialBarView mPagerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = (RelativeLayout) findViewById(R.id.relative_Main);
        mPagerView = new SimpleMaterialBarView(this);
//        mPagerView.createNewPage("1", SuperAwesomeCardFragment.newInstance(1));
//        mPagerView.createNewPage("2", SuperAwesomeCardFragment.newInstance(2));
//        mPagerView.createNewPage("3", SuperAwesomeCardFragment.newInstance(3));
//        mPagerView.setMaterialPagerAdapter();
        mPagerView.changeColor(getResources().getColor(android.R.color.holo_red_light));
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
