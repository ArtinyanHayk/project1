package com.example.chat_app2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.chat_app2.model.ChatroomModel;
import com.example.chat_app2.model.UserModel;
import com.example.chat_app2.utils.AndroidUtil;
import com.example.chat_app2.utils.FirbaseUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentSnapshot;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ChatActivity extends AppCompatActivity {
    UserModel otherUser;
    ChatroomModel chatroomModel;
    ImageButton messageInput;
    ImageButton sendMessageButton;
    ImageButton backButton;
    TextView otherUsername;
    RecyclerView recyclerView;
    String chatroomId;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        //get UserModel
        otherUser = AndroidUtil.getUserModelFromIntent(getIntent());
        chatroomId = FirbaseUtil.getChatroomId(FirbaseUtil.currentUsersId(), otherUser.getUserId());

        messageInput = findViewById(R.id.chat_messege_input);
        sendMessageButton = findViewById(R.id.message_send_btn);
        backButton = findViewById(R.id.back_btn);
        otherUsername = findViewById(R.id.other_username);
        recyclerView = findViewById(R.id.chat_recycler_view);

        otherUsername.setText(otherUser.getUserName());

        backButton.setOnClickListener(v -> {
            onBackPressed();
        });
        getOrCreateChatroomModel();


    }

    void getOrCreateChatroomModel() {
        FirbaseUtil.getChatroomReherence(chatroomId).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                chatroomModel = task.getResult().toObject(ChatroomModel.class);
                if (chatroomModel == null) {
                    //first time
                    chatroomModel = new ChatroomModel(chatroomId,
                            Arrays.asList(FirbaseUtil.currentUsersId(), otherUser.getUserId()), Timestamp.now(), "");


                }
                FirbaseUtil.getChatroomReherence(chatroomId).set(chatroomModel);

            }
        });

    }
}