package com.example.friends_dasfreundebuch;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DataHandler {

    private HashMap<String, String> personalDataStorage;

    private ArrayList<ArrayList<String>> friendsList;

    private File correctPath = Environment.getExternalStorageDirectory();

    public DataHandler() {
        friendsList = csvToList("files/friend_List.csv");
    }

    public void addItems(String key, String value) {
        personalDataStorage.put(key, value);
    }

    public String getItem(String key) {
        return personalDataStorage.get(key);
    }

    public ArrayList<ArrayList<String>> getFriendsList() {
        return friendsList;
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
        } catch (IOException e) {
        } catch (IndexOutOfBoundsException e) {
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


    public ArrayList<ArrayList<String>> csvToList(String path){

        friendsList = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new FileReader(path)).useDelimiter(",|;\n");

            while (scanner.hasNextLine()){

                ArrayList<String> friend = new ArrayList<>();
                friend.add(scanner.next());
                friend.add(scanner.next());
                friendsList.add(friend);


            }
            scanner.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return friendsList;
    }



    
}
