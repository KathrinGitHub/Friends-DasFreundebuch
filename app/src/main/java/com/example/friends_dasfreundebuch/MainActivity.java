package com.example.friends_dasfreundebuch;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ListView listView;
    private PersonListAdapter listAdapter;
    private ArrayList<DummyProfile> friends;
    private DataHandler dataHandler = new DataHandler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        listView = findViewById(R.id.listFriends);

        friends = new ArrayList<>();
        //create dummy entries
        friends.add(new DummyProfile("lorem", "drawable://" +  R.drawable.q6d8h7l8, "1"));
        friends.add(new DummyProfile("ipsum", "drawable://" +  R.drawable.img159179884, "2"));
        friends.add(new DummyProfile("dolor", "drawable://" +  R.drawable.img51487947, "3"));
        friends.add(new DummyProfile("sit", "drawable://" +  R.drawable.q6d8h7l8, "4"));
        friends.add(new DummyProfile("lorem2", "drawable://" +  R.drawable.q6d8h7l8, "5"));
        friends.add(new DummyProfile("ipsum2", "drawable://" +  R.drawable.img159179884, "6"));
        friends.add(new DummyProfile("dolor2", "drawable://" +  R.drawable.img51487947, "7"));
        friends.add(new DummyProfile("sit2", "drawable://" +  R.drawable.q6d8h7l8, "8"));
        friends.add(new DummyProfile("lorem3", "drawable://" +  R.drawable.q6d8h7l8, "9"));
        friends.add(new DummyProfile("ipsum3", "drawable://" +  R.drawable.img159179884, "10"));
        friends.add(new DummyProfile("dolor3", "drawable://" +  R.drawable.img51487947, "11"));
        friends.add(new DummyProfile("sit3", "drawable://" +  R.drawable.q6d8h7l8, "12"));
        friends.add(new DummyProfile("lorem4", "drawable://" +  R.drawable.q6d8h7l8, "13"));
        friends.add(new DummyProfile("ipsum4", "drawable://" +  R.drawable.img159179884, "14"));
        friends.add(new DummyProfile("dolor4", "drawable://" +  R.drawable.img51487947, "15"));
        friends.add(new DummyProfile("sit4", "drawable://" +  R.drawable.q6d8h7l8, "16"));


        listAdapter = new PersonListAdapter(this, R.layout.friend_item, friends);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listView.getItemAtPosition(i);
                Intent intent = new Intent(MainActivity.this, FriendProfile.class);
                startActivity(intent);
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Type here to search");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                listAdapter.getFilter().filter(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }


    public void gotToMyPage(View view) {
        Intent intent = new Intent(MainActivity.this, OwnProfile.class);
        startActivity(intent);
    }
}
