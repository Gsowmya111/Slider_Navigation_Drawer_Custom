package com.example.sowmyaram.slider_navigation_drawer_custom;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private String[] mnavigationItems;
    private DrawerLayout mdrawerLayout;
    private ListView mdrawerlist;
    Toolbar toolbar;
    private CharSequence mTitle;
    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mnavigationItems = getResources().getStringArray(R.array.navi_drwa_item_array);
        mdrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mdrawerlist = (ListView) findViewById(R.id.left_drawer);

       setupToolbar();

        DataModel[] datamodelitems=new DataModel[3];
        datamodelitems[0]=new DataModel(R.drawable.connect,"Connect");
        datamodelitems[1]=new DataModel(R.drawable.fixtures,"Fixtures");
        datamodelitems[2]=new DataModel(R.drawable.table,"Table");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);


        Drawer_Item_Custom_adapter customadapter = new Drawer_Item_Custom_adapter(this,R.layout.list_view_item_row,datamodelitems);
        mdrawerlist.setAdapter(customadapter);
        mdrawerlist.setOnItemClickListener(new DrawerItemclicklistenr());
        mdrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mdrawerLayout.setDrawerListener(mDrawerToggle);
        setupDrawerToggle();

    }

    void setupDrawerToggle(){
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,mdrawerLayout,toolbar,R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    void setupToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }


    private class DrawerItemclicklistenr implements ListView.OnItemClickListener {


        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            selectItem(position);
        }
    }


    private void selectItem(int position) {
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new Connect_fragment();
                break;
            case 1:
                fragment = new Fixture_fragment();
                break;
            case 2:
                fragment = new Table_fragment();
                break;

        }
        if (fragment != null) {
            FragmentManager fragmentManager =getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame,fragment).commit();

            mdrawerlist.setItemChecked(position,true);
            mdrawerlist.setSelection(position);
            mdrawerLayout.closeDrawer(mdrawerlist);
        }


    }


}
