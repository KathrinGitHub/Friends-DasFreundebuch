package com.example.friends_dasfreundebuch;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
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
    ListView listView;
    PersonListAdapter listAdapter;
    ArrayList<dummyFriend> friends;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listFriends);

        friends = new ArrayList<>();
        //create dummy entries
        friends.add(new dummyFriend("Stella", "drawable://" +  R.drawable.q6d8h7l8));
        friends.add(new dummyFriend("ipsum", "drawable://" +  R.drawable.img159179884));
        friends.add(new dummyFriend("dolor", "drawable://" +  R.drawable.img51487947));
        friends.add(new dummyFriend("sit", "drawable://" +  R.drawable.q6d8h7l8));
        friends.add(new dummyFriend("lorem2", "drawable://" +  R.drawable.q6d8h7l8));
        friends.add(new dummyFriend("ipsum2", "drawable://" +  R.drawable.img159179884));
        friends.add(new dummyFriend("dolor2", "drawable://" +  R.drawable.img51487947));
        friends.add(new dummyFriend("sit2", "drawable://" +  R.drawable.q6d8h7l8));
        friends.add(new dummyFriend("lorem3", "drawable://" +  R.drawable.q6d8h7l8));
        friends.add(new dummyFriend("ipsum3", "drawable://" +  R.drawable.img159179884));
        friends.add(new dummyFriend("dolor3", "drawable://" +  R.drawable.img51487947));
        friends.add(new dummyFriend("sit3", "drawable://" +  R.drawable.q6d8h7l8));
        friends.add(new dummyFriend("lorem4", "drawable://" +  R.drawable.q6d8h7l8));
        friends.add(new dummyFriend("ipsum4", "drawable://" +  R.drawable.img159179884));
        friends.add(new dummyFriend("dolor4", "drawable://" +  R.drawable.img51487947));
        friends.add(new dummyFriend("sit4", "drawable://" +  R.drawable.q6d8h7l8));

        listAdapter = new PersonListAdapter(this, R.layout.friend_item, friends);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object friend = listView.getItemAtPosition(i);
                Intent intent = new Intent(MainActivity.this, FriendProfile.class);

                if (friend instanceof Parcelable) {
                    intent.putExtra("friendObject", (Parcelable) friend);
                    startActivity(intent);
                }
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
