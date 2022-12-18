package com.example.friends_dasfreundebuch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class OwnEditProfile extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getIntent().getExtras();
        setContentView(R.layout.own_layout_edit_view);
        EditText categoryEdit = findViewById(R.id.category_edit);
        EditText contentEdit = findViewById(R.id.content_edit);
        categoryEdit.setText(b.getString("Category"));
        contentEdit.setText(b.getString("Content"));
        ImageButton closeBtn = findViewById(R.id.close_button);
        FloatingActionButton addButton = findViewById(R.id.addButton);


        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OwnEditProfile.this, OwnProfile.class);
                Bundle b = new Bundle();
                b.putString("Content", contentEdit.getText().toString());
                b.putString("Category", categoryEdit.getText().toString());
                intent.putExtras(b);
                startActivity(intent);
                startActivity(intent);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout list = findViewById(R.id.list);
                View item = getLayoutInflater().inflate(R.layout.profile_content_item_edit, list, false);
                list.addView(item);
            }
        });

    }


}
