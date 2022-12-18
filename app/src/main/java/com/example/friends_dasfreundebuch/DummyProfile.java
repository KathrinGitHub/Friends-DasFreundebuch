package com.example.friends_dasfreundebuch;

public class DummyProfile {

    /*public int image;*/
    private String name;
    private String ID;
    private int day = 01;
    private int month = 01;
    private int year = 1999;


    public DummyProfile(String name, String ID) {
        setName(name);
        setID(ID);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return getID() + ";" + getName() + ";" + getDay() + ";" + getMonth() + ";" + getYear();
    }
}
