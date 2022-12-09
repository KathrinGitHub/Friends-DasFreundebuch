package com.example.friends_dasfreundebuch;

import android.media.Image;

public class dummyFriend {

    /*public int image;*/
    public String name;

    public dummyFriend(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
