package com.example.friends_dasfreundebuch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class OwnProfile extends AppCompatActivity {

    private static final String TAG = "OwnProfile";

    public ArrayList listItems = new ArrayList<>();

    private ArrayAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getIntent().getExtras();
        setContentView(R.layout.own_layout);
        //adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        TextView category = findViewById(R.id.category);
        TextView content = findViewById(R.id.content);
        category.setText(b.getString("Category"));
        content.setText(b.getString("Content"));
        ImageButton editBtn = findViewById(R.id.edit_button);
        ImageButton backBtn = findViewById(R.id.back_button);


        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OwnProfile.this, OwnEditProfile.class);
                Bundle b = new Bundle();
                b.putString("Content", content.getText().toString());
                b.putString("Category", category.getText().toString());
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OwnProfile.this, MainActivity.class));
            }
        });
    }


}
