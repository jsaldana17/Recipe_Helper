package com.example.jesus.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class item_screen extends Activity {
    // globals
    TextView titleTxtView;
    TextView urlTxtView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_screen);

        //get object
        Intent i = getIntent();
        Item item = (Item)i.getSerializableExtra("Item");


        titleTxtView = (TextView)findViewById(R.id.titleTxtView);
        urlTxtView = (TextView)findViewById(R.id.urlTxtView);

        titleTxtView.setText(item.getTitle());
        urlTxtView.setText(item.getUrl());


    }
}
