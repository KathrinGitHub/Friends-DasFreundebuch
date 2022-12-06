package com.example.friends_dasfreundebuch;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class FriendProfile extends ListActivity {

    ArrayList listItems = new ArrayList<>();

    ArrayAdapter adapter;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.own_layout);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        ImageButton backBtn = findViewById(R.id.back_button_friend);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FriendProfile.this, MainActivity.class));
            }
        });
    }
}
