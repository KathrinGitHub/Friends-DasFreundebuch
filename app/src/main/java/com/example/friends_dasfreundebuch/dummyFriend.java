package com.example.friends_dasfreundebuch;

import android.media.Image;

public class dummyFriend {

    /*public int image;*/
    public String name;
    private String imgURL;

    public dummyFriend(String name, String imgURL) {
        this.name = name;
        this.imgURL = imgURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    @Override
    public String toString() {
        return name;
    }
}
