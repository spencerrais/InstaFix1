package com.example.spencer.instafix.panels;

/**
 * Created by spencer on 12.11.2016.
 */


public class ListItem {

    private String itemTitle;

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public ListItem(String title){
        this.itemTitle = title;
    }
}
