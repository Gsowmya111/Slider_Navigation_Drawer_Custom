package com.example.sowmyaram.slider_navigation_drawer_custom;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sowmyaram on 7/5/2017.
 */

class Drawer_Item_Custom_adapter extends ArrayAdapter<DataModel> {


    Context mContext;
    int layoutResourceId;
    DataModel data[] = null;


    public Drawer_Item_Custom_adapter(Context context, int layoutresourceId, DataModel[] data) {
        super(context,layoutresourceId,data);
        this.layoutResourceId=layoutresourceId;
        this.mContext=context;
        this.data=data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItem = convertView;

        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        listItem = inflater.inflate(layoutResourceId, parent, false);

        ImageView imageViewIcon = (ImageView) listItem.findViewById(R.id.imageViewIcon);
        TextView textViewName = (TextView) listItem.findViewById(R.id.textViewName);

        DataModel folder = data[position];


        imageViewIcon.setImageResource(folder.icon);
        textViewName.setText(folder.name);

        return listItem;
    }
}
