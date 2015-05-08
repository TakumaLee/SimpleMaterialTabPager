package com.github.takumalee.simplematerialpager.example.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.github.takumalee.simplematerialpager.example.R;
import com.github.takumalee.simplematerialpager.example.fragment.SuperAwesomeCardFragment;
import com.github.takumalee.simplematerialtabpager.view.MTP;
import com.github.takumalee.simplematerialtabpager.view.SimpleMaterialTabPagerView;

public class XmlActivity extends ActionBarActivity {

    private SimpleMaterialTabPagerView mPagerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml);
        mPagerView = (SimpleMaterialTabPagerView) findViewById(R.id.smtp_pager);
        mPagerView.commit(
                new SimpleMaterialTabPagerView.Builder(MTP.DEFAULT)
                        .addSection("1", SuperAwesomeCardFragment.newInstance(1))
                        .addSection("2", SuperAwesomeCardFragment.newInstance(2)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_xml, menu);
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
