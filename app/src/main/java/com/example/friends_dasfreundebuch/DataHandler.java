package com.example.friends_dasfreundebuch;

import java.util.HashMap;

public class DataHandler {

    private HashMap<String, String> personalDataStorage;

    public DataHandler() {
        personalDataStorage = new HashMap<String, String>();
    }

    public void addItems(String key, String value) {
        personalDataStorage.put(key, value);
    }

    public String getItem(String key) {
        return personalDataStorage.get(key);
    }




    /*
    @Override
    public String toString() {
        Set<String> keys = personalDataStorage.keySet();
        String str = "";
        for (String key:keys) {
            str.concat(key + ";" + this.getItem(key) + "\n");
        }
        return str;
    }*/

    
}
