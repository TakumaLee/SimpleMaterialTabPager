package com.github.takumalee.simplematerialpager.example.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.github.takumalee.simplematerialpager.example.MainActivity;
import com.github.takumalee.simplematerialpager.example.R;
import com.github.takumalee.simplematerialpager.example.fragment.SuperAwesomeCardFragment;
import com.github.takumalee.simplematerialtabpager.view.SimpleMaterialTabPagerView;

public class IconSampleActivity extends AppCompatActivity {

    private RelativeLayout relativeLayout;
    private SimpleMaterialTabPagerView mPagerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon_sample);
        relativeLayout = (RelativeLayout) findViewById(R.id.relative_IconTab);
        mPagerView = new SimpleMaterialTabPagerView.Builder()
                .addNewPage(MainActivity.getTabIconRes(0), SuperAwesomeCardFragment.newInstance(1))
                .addNewPage(MainActivity.getTabIconRes(1), SuperAwesomeCardFragment.newInstance(2))
                .addNewPage(MainActivity.getTabIconRes(2), SuperAwesomeCardFragment.newInstance(3))
                .build(this);
        mPagerView.setFitsSystemWindows(false);
//        mPagerView.createNewPage("3", SuperAwesomeCardFragment.newInstance(3));
//        mPagerView.createNewPage("4", SuperAwesomeCardFragment.newInstance(4));
        mPagerView.setIconMaterialTabAdapter(getSupportFragmentManager());
        mPagerView.changePrimaryTitleColor(Color.WHITE);
        mPagerView.changeTopicColor(getResources().getColor(android.R.color.holo_blue_bright));
        mPagerView.changeStatusBarColor(getResources().getColor(android.R.color.holo_blue_bright));
        mPagerView.getToolbar().setTitleTextColor(getResources().getColor(android.R.color.white));
        relativeLayout.addView(mPagerView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_icon_sample, menu);
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
