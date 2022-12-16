package com.example.friends_dasfreundebuch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FriendProfile extends AppCompatActivity {

    private static final String TAG = "FriendProfile";
    private ListView listView;
    private ListView messageListView;
    private AttributeListAdapter listAdapter;
    private MessageListAdapter messageListAdapter;
    private ArrayList<Attribute> attributes;
    private ArrayList<Message> messages;

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private EditText message;
    private Button sendButton;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friend_layout);
        listView = findViewById(R.id.listAttributes);
        messageListView = findViewById(R.id.messages);

        attributes = new ArrayList<>();
        attributes.add(new Attribute("Birthday:", "31.12.1993", "drawable://" + R.drawable.attribute));
        attributes.add(new Attribute("Lieblingsfarbe:", "Blau", "drawable://" + R.drawable.attribute));
        attributes.add(new Attribute("mein Haustier:", "Filomena!", "drawable://" + R.drawable.attribute));
        attributes.add(new Attribute("wir kennen uns seid:", "05.07.2010", "drawable://" + R.drawable.attribute));


        ImageButton backBtn = findViewById(R.id.back_button);
        dummyFriend friend = getIntent().getParcelableExtra("friendObject");
        TextView tv = findViewById(R.id.friendName);
        tv.setText(friend.getName());
        ImageView iv = (ImageView) findViewById(R.id.user);
        iv.setImageResource(R.drawable.stella);


        listAdapter = new AttributeListAdapter(this, R.layout.attribute_item, attributes);
        listView.setAdapter(listAdapter);

        messages = new ArrayList<>();
        messages.add(new Message("I glaub du hast den Kontest für bestes Foto gewonnen :)", "drawable://" + R.drawable.img_dummy));

        messageListAdapter = new MessageListAdapter(this, R.layout.message_item, messages);
        messageListView.setAdapter(messageListAdapter);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FriendProfile.this, MainActivity.class));
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FriendProfile.this, MainActivity.class));
            }
        });

        Button b = (Button)findViewById(R.id.sendMessage);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createSendMessageDialog();
            }
        });
    }

    private void createSendMessageDialog() {
        dialogBuilder = new AlertDialog.Builder(this);
        final View messagePopupView = getLayoutInflater().inflate(R.layout.message_popup, null);
        message = (EditText) messagePopupView.findViewById(R.id.messageTextPopup);
        sendButton = (Button) messagePopupView.findViewById(R.id.sendMessagePopUp);

        dialogBuilder.setView(messagePopupView);
        dialog = dialogBuilder.create();
        dialog.show();

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

                Toast.makeText(getApplicationContext(), "SEND MESSAGE: " + message.getText(), Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}
