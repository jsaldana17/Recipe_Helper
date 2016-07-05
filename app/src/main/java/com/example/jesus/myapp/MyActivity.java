package com.example.jesus.myapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class MyActivity extends AppCompatActivity {

    private ArrayList<Item> data = new ArrayList<Item>();
    private MyListAdapter adapter;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        lv = (ListView) findViewById(R.id.listview);
        generateStartingNode();
        adapter = new MyListAdapter(this, R.layout.activity_add_new_item, data);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MyActivity.this, "List item was clicked at " + position, Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), item_screen.class);
                i.putExtra("Item", data.get(position));
                startActivity(i);
            }
        });
        //addItemButton();
    }


    public class viewHolderHelper
    {

        ImageView thumbnail;
        TextView title;
        Button button;
    }

    private void generateStartingNode()
    {
        Item item;
        item = new Item("STARTING NODE", new ArrayList<String>(Arrays.asList("add Ingredient")), "www.dummy_Node.com");
        data.add(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
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