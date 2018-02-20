package com.example.sowmyaram.slider_navigation_drawer_custom;

/**
 * Created by sowmyaram on 7/5/2017.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by anupamchugh on 10/12/15.
 */
public class Table_fragment extends Fragment {

    public Table_fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_table, container, false);

        return rootView;
    }

}
