package com.github.takumalee.simplematerialpager.example;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.takumalee.simplematerialpager.example.activity.CustomTabActivity;
import com.github.takumalee.simplematerialpager.example.activity.IconSampleActivity;
import com.github.takumalee.simplematerialpager.example.activity.TabNoActionBarActivity;
import com.github.takumalee.simplematerialpager.example.activity.TabTextActivity;


public class MainActivity extends AppCompatActivity {

    public static View getCustomTab(Context context, int position) {
        ImageView tab = new ImageView(context);
        int res = 0;
        switch (position) {
            case 0:
                res = R.drawable.tab_discover;
                break;
            case 1:
                res = R.drawable.tab_me;
                break;
            case 2:
                res = R.drawable.tab_drama_list;
                break;
            default:
                res = R.drawable.tab_discover;
                break;
        }
        tab.setImageResource(res);
        return tab;
    }

    public static int getTabIconRes(int position) {
        int res = 0;
        switch (position) {
            case 0:
                res = R.drawable.tab_discover;
                break;
            case 1:
                res = R.drawable.tab_me;
                break;
            case 2:
                res = R.drawable.tab_drama_list;
                break;
            default:
                res = R.drawable.tab_discover;
                break;
        }
        return res;
    }

    private RelativeLayout relativeLayout;
    private ListView listView;
    private SampleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = (RelativeLayout) findViewById(R.id.relative_Main);
        listView = new ListView(this);
        adapter = new SampleAdapter();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, TabTextActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, TabNoActionBarActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, CustomTabActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, IconSampleActivity.class));
                        break;
                    default:
                        startActivity(new Intent(MainActivity.this, TabTextActivity.class));
                        break;
                }
            }
        });
        relativeLayout.addView(listView);
    }

    public String[] SAMPLES = {
            "Tab Text Sample",
            "Tab No Action Bar Sample",
            "Tab with Custom",
            "Tab with Icon"
    };

    private class SampleAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return SAMPLES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_single_text, null);
            TextView textView = (TextView) view.findViewById(R.id.textView_SingleText_Adapter);
            textView.setText(SAMPLES[position]);
            return view;
        }
    }

}
