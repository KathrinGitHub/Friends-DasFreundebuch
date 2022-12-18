package com.example.friends_dasfreundebuch;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DataInit {

    private static ArrayList<dummyFriend> friends = new ArrayList<>();
    public static dummyFriend stella = new dummyFriend("Stella", "drawable://" + R.drawable.stella);

    public static ArrayList getFriendsList() {


        ArrayList attributes = new ArrayList<>();
        attributes.add(new Attribute("Birthday:", "31.12.1993", "drawable://" + R.drawable.attribute));
        attributes.add(new Attribute("Lieblingsfarbe:", "Blau", "drawable://" + R.drawable.attribute));
        attributes.add(new Attribute("mein Haustier:", "Filomena!", "drawable://" + R.drawable.attribute));
        attributes.add(new Attribute("wir kennen uns seid:", "05.07.2010", "drawable://" + R.drawable.attribute));

        ArrayList messages = new ArrayList<>();
        messages.add(new Message("I glaub du hast den Kontest für bestes Foto gewonnen :)", "drawable://" + R.drawable.img_dummy));

        stella.setMessages(messages);
        stella.setAttributes(attributes);
        //create dummy entries
        friends.add(stella);
        friends.add(new dummyFriend("ipsum", "drawable://" + R.drawable.img159179884));
        friends.add(new dummyFriend("dolor", "drawable://" + R.drawable.img51487947));
        friends.add(new dummyFriend("sit", "drawable://" + R.drawable.q6d8h7l8));
        friends.add(new dummyFriend("lorem2", "drawable://" + R.drawable.q6d8h7l8));
        friends.add(new dummyFriend("ipsum2", "drawable://" + R.drawable.img159179884));
        friends.add(new dummyFriend("dolor2", "drawable://" + R.drawable.img51487947));
        friends.add(new dummyFriend("sit2", "drawable://" + R.drawable.q6d8h7l8));
        friends.add(new dummyFriend("lorem3", "drawable://" + R.drawable.q6d8h7l8));
        friends.add(new dummyFriend("ipsum3", "drawable://" + R.drawable.img159179884));
        friends.add(new dummyFriend("dolor3", "drawable://" + R.drawable.img51487947));
        friends.add(new dummyFriend("sit3", "drawable://" + R.drawable.q6d8h7l8));
        friends.add(new dummyFriend("lorem4", "drawable://" + R.drawable.q6d8h7l8));
        friends.add(new dummyFriend("ipsum4", "drawable://" + R.drawable.img159179884));
        friends.add(new dummyFriend("dolor4", "drawable://" + R.drawable.img51487947));
        friends.add(new dummyFriend("sit4", "drawable://" + R.drawable.q6d8h7l8));
        return friends;
    }



    public static String toGson(){
        Type listType = new TypeToken<List<dummyFriend>>() {
        }.getType();

        Gson gson = new Gson();
        String json = gson.toJson(friends, listType);

        System.out.println(json);
        return json;
    }

    public void gsonToCollection(){

    }

}
