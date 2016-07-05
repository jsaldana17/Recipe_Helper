package com.example.jesus.myapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jesus on 6/28/2016.
 */

public class Item implements Serializable //implements *Serializable* in order to pass intent to activity
{
    private String title;
    private ArrayList<String> ingredients;
    private String url;

    public Item()
    {
        title = "Change_Me";
        ingredients = new ArrayList<String>();
        url = "www.google.com";
    }

    public Item(String title, ArrayList<String> ingredients, String url)
    {
        this.title = title;
        this.ingredients = ingredients;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
