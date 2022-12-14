package com.example.friends_dasfreundebuch;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

public class dummyFriend implements Parcelable {

    /*public int image;*/
    public String name;
    private String imgURL;

    public dummyFriend(String name, String imgURL) {
        this.name = name;
        this.imgURL = imgURL;
    }

    protected dummyFriend(Parcel in) {
        name = in.readString();
        imgURL = in.readString();
    }

    public static final Creator<dummyFriend> CREATOR = new Creator<dummyFriend>() {
        @Override
        public dummyFriend createFromParcel(Parcel in) {
            return new dummyFriend(in);
        }

        @Override
        public dummyFriend[] newArray(int size) {
            return new dummyFriend[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(imgURL);
    }
}
