package com.example.friends_dasfreundebuch;

import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {
    //start screen -> shows list of friends

    ListView listView;
    PersonListAdapter listAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listFriends);

        ArrayList<dummyFriend> friends = new ArrayList<>();
        //create dummy entries
        friends.add(new dummyFriend("lorem"));
        friends.add(new dummyFriend("ipsum"));
        friends.add(new dummyFriend("dolor"));
        friends.add(new dummyFriend("sit"));
        friends.add(new dummyFriend("amet"));
        friends.add(new dummyFriend("consectetur"));
        friends.add(new dummyFriend("adipiscing"));
        friends.add(new dummyFriend("elit"));
        friends.add(new dummyFriend("curabitur"));
        friends.add(new dummyFriend("vel"));

        listAdapter = new PersonListAdapter(this, R.layout.friend_item, friends);
        listView.setAdapter(listAdapter);
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


}
