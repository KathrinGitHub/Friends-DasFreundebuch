package com.example.friends_dasfreundebuch;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class OwnProfile extends ListActivity {

    ArrayList listItems = new ArrayList<>();

    ArrayAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.own_layout);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
    }
}
