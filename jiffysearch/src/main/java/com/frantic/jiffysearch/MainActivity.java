package com.frantic.jiffysearch;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener,SearchView.OnCloseListener {

    private SearchManager searchManager;
    private SearchView searchView;
    private MenuItem searchItem;
    private ExpandableListAdapter adapter;
    private ExpandableListView listView;
    private ArrayList<ParentRow> parentRowList;
    private ArrayList<ParentRow> showparentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        searchManager= (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        parentRowList = new ArrayList<>();
        showparentList = new ArrayList<>();
        displayAll();
        //expandAll();

    }

    private void displayAll() {
        loadData();
        listView = (ExpandableListView) findViewById(R.id.expandableListView_Search);
        adapter = new MyExpandableListAdapter(MainActivity.this,parentRowList);
        listView.setAdapter(adapter);
    }

    private void loadData() {
        List<ChildRow> childRowList = new ArrayList<>();
        ParentRow parentRow = null;
        childRowList.add(new ChildRow(R.drawable.ic_card,"Dell"));
        childRowList.add(new ChildRow(R.drawable.ic_card,"Lenevo"));
        childRowList.add(new ChildRow(R.drawable.ic_card,"HP"));
        childRowList.add(new ChildRow(R.drawable.ic_card,"Asus"));
        parentRow = new ParentRow("Laptops",childRowList);
        parentRowList.add(parentRow);
        childRowList = new ArrayList<>();
        childRowList.add(new ChildRow(R.drawable.ic_card,"Nokia"));
        childRowList.add(new ChildRow(R.drawable.ic_card,"Samsung"));
        childRowList.add(new ChildRow(R.drawable.ic_card,"Iphone"));
        childRowList.add(new ChildRow(R.drawable.ic_card,"HTC"));
        parentRow = new ParentRow("Mobiles",childRowList);
        parentRowList.add(parentRow);
    }

    private void expandAll(){
        int count = adapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            listView.expandGroup(i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        /*searchItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(this);
        searchView.requestFocus();*/
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

    @Override
    public boolean onClose() {
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
