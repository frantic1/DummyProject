package com.example.parsegson.Others;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Frantic on 5/3/2016.
 */
public class Data {

    @SerializedName("cat_id")
    String id;

    String name;
    String short_text;
    String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShort_text() {
        return short_text;
    }

    public void setShort_text(String short_text) {
        this.short_text = short_text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
