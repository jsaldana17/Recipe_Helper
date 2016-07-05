package com.example.jesus.myapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MyListAdapter extends ArrayAdapter<Item>
{
    //CONSTANTS
    private final int TOTAL_OPTIONS = 3;

    //FIELDS
    private boolean isReadyToAddItemElseNotYet = false;
    private String food_title;
    private String url;
    private ArrayList<String> current = new ArrayList<String>(Arrays.asList("Gourmet Item", "Ingredients", "URL"));
    private int field_num;
    private TextView titleHolder;


    private int layout;
    private List<Item> mObjects;
    private String m_Text = "";

    public MyListAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
        mObjects = objects;
        layout = resource;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder mainViewholder = null;
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(layout, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.thumbnail = (ImageView) convertView.findViewById(R.id.list_item_thumbnail);
            viewHolder.title = (TextView) convertView.findViewById(R.id.list_item_text);
            titleHolder = (TextView) convertView.findViewById(R.id.list_item_text); //holder to set title later
            viewHolder.button = (Button) convertView.findViewById(R.id.list_item_btn);
            convertView.setTag(viewHolder);
        }
        mainViewholder = (ViewHolder) convertView.getTag();
        mainViewholder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                field_num = TOTAL_OPTIONS - 1;
                for (int i = 0; i < TOTAL_OPTIONS; i++, field_num--) {
                    setText(current.get(field_num));
                }
                field_num = 0;


                    /*Item item = new Item("Cheesecake", new ArrayList<String>(Arrays.asList("xyz", "abc")), "www.test.com");
                    data.add(item);
                    ListView lv = (ListView) findViewById(R.id.listview);
                    lv.setAdapter(new MyListAdaper(this, R.layout.activity_add_new_item, data));*/

                Toast.makeText(getContext(), "Button was clicked for list item " + position, Toast.LENGTH_SHORT).show();
            }
        });
        // mainViewholder.title.setText(getItem(position));

        return convertView;
    }

    private void setText(String current)
    {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(current);

        // Set up the input
        final EditText input = new EditText(getContext());
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = input.getText().toString();
                whichField(field_num, m_Text);
                if(isReadyToAddItemElseNotYet){ addItemButton(food_title, url);}
                //addItemButton(m_Text);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();

    }

    private void addItemButton(String text, String url) {
        //*****CHANGE ORDER IN WHICH IT ADDS TO LIST, addLast, not addFirst(current)

        this.insert(new Item(text, new ArrayList<String>(Arrays.asList("xyz", "abc")), url), mObjects.size()-1);
        isReadyToAddItemElseNotYet = false; //set flag since add was made
        titleHolder.setText(text); //set title
    }

    private void whichField(int field_Identity, String txt)
    {
        switch (field_Identity)
        {
            case 0:     food_title = txt;
                        field_num++;
                        break;

            case 1:     field_num++;
                        break;

            case 2:     url = txt;
                        field_num++;
                        isReadyToAddItemElseNotYet = true; //url should be the last case
                        break;

            default:
        }
    }



    public class ViewHolder
    {

        ImageView thumbnail;
        TextView title;
        Button button;
    }
}



