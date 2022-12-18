package com.example.friends_dasfreundebuch;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

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
        friends.add(new DummyProfile("Franz",  "1"));
        friends.add(new DummyProfile("Harald",  "2"));
        friends.add(new DummyProfile("Sebs",  "3"));
        friends.add(new DummyProfile("Benj",  "4"));
        friends.add(new DummyProfile("Bence",  "5"));
        friends.add(new DummyProfile("Pasqual",  "6"));
        friends.add(new DummyProfile("Andi",  "7"));
        friends.add(new DummyProfile("Elli",  "8"));
        friends.add(new DummyProfile("Isi",  "9"));
        friends.add(new DummyProfile("Robert",  "10"));
        friends.add(new DummyProfile("Samuel",  "11"));
        friends.add(new DummyProfile("Noah",  "12"));
        friends.add(new DummyProfile("Stefan",  "13"));
        friends.add(new DummyProfile("Phillip",  "14"));
        friends.add(new DummyProfile("Jakob",  "15"));
        friends.add(new DummyProfile("Jeremia", "16"));

        listAdapter = new PersonListAdapter(this, R.layout.friend_item, friends);
        listView.setAdapter(listAdapter);
        updateListViewHeight(listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listView.getItemAtPosition(i);
                Intent intent = new Intent(MainActivity.this, FriendProfile.class);
                startActivity(intent);
            }
        });

        FloatingActionButton menuBtn = findViewById(R.id.floatingActionButton3);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FloatingActionButton add = findViewById(R.id.miniFloatingActionButton1);
                FloatingActionButton qr = findViewById(R.id.miniFloatingActionButton2);

                if(add.getVisibility() == View.GONE) {
                    add.setVisibility(View.VISIBLE);
                    qr.setVisibility(View.VISIBLE);
                    menuBtn.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                }
                else if(add.getVisibility() == View.VISIBLE) {
                    add.setVisibility(View.GONE);
                    qr.setVisibility(View.GONE);
                    menuBtn.setImageResource(R.drawable.ic_baseline_more_vert_24);
                }

                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this, QrCodeScanner.class));
                    }
                });

                qr.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this, QrCode.class));
                    }
                });
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
        Bundle b = new Bundle();
        b.putString("Content", "Pizza");
        b.putString("Category", "Lieblingsessen");
        intent.putExtras(b);
        startActivity(intent);
    }

    public void updateListViewHeight(ListView myListView) {
        PersonListAdapter listAdapter = (PersonListAdapter)myListView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        // get listview height
        int totalHeight = 0;
        int adapterCount = listAdapter.getCount();
        Log.d("count", String.valueOf(adapterCount));

        for (int size = 0; size < adapterCount; size++) {
            View listItem = listAdapter.getView(size, null, myListView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        // Change Height of ListView
        ViewGroup.LayoutParams params = myListView.getLayoutParams();
        Log.d("getDivider", String.valueOf(myListView.getDividerHeight()));
        Log.d("height", String.valueOf(totalHeight));
        //params.height = (int) (totalHeight + (myListView.getDividerHeight() * (adapterCount)));
        params.height = (adapterCount + 2) * 80;
        myListView.setLayoutParams(params);
    }
}
