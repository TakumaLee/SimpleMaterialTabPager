package com.github.takumalee.simplematerialpager.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.takumalee.simplematerialpager.example.activity.TabTextActivity;


public class MainActivity extends ActionBarActivity {

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
                    default:
                        startActivity(new Intent(MainActivity.this, TabTextActivity.class));
                        break;
                }
            }
        });
        relativeLayout.addView(listView);
    }

    public String[] SAMPLES = {
            "Tab Text Sample"
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
