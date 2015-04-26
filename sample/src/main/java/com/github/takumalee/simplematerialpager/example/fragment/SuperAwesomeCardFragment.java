package com.github.takumalee.simplematerialpager.example.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.takumalee.simplematerialpager.example.R;

/**
 * Created by TakumaLee on 15/4/27.
 */
public class SuperAwesomeCardFragment extends Fragment {

    private static final String ARG_POSITION = "position";

    private TextView textView;

    private int position;

    public static SuperAwesomeCardFragment newInstance(int position) {
        SuperAwesomeCardFragment f = new SuperAwesomeCardFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt(ARG_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_card, container, false);
        textView = (TextView) rootView.findViewById(R.id.textView);
        ViewCompat.setElevation(rootView, 50);
        textView.setText("CARD " + position);
        return rootView;
    }

}
