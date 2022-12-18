package com.example.friends_dasfreundebuch;

import android.util.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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



    //for future data loading
    private void readFile(String path) {

        try {
            List<String> csv = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(path));
            while(reader.ready()) {
                csv.add(reader.readLine());
            }
            for (String line:csv) {
                String[] array = line.split(";");
                for (int i = 0; i < array.length - 1; i++) {
                    if(i == 0) {
                        addItems("Id", array[1]);
                        continue;
                    }
                    addItems(array[i], array[i + 1]);
                }
            }
            reader.close();
            Log.d("test", "successful");
        } catch (IOException e) {
            Log.d("test", "not working or end of file");
        } catch (IndexOutOfBoundsException e) {
            Log.d("Exception", e.getMessage());
        }


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
