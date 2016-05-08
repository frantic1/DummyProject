package com.frantic.jiffysearch;

/**
 * Created by Frantic on 4/18/2016.
 */
public class ChildRow {
    private int icon;
    private String title;

    public ChildRow(int icon, String title) {
        this.icon = icon;
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
