package com.frantic.jiffysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frantic on 4/18/2016.
 */
public class ParentRow {
    private String title;
    private List<ChildRow> childRowList;

    public ParentRow(String title, List<ChildRow> childRowList) {
        this.title = title;
        this.childRowList = childRowList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ChildRow> getChildRowList() {
        return childRowList;
    }

    public void setChildRowList(List<ChildRow> childRowList) {
        this.childRowList = childRowList;
    }
}