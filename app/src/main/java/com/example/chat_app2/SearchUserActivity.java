package com.example.chat_app2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.chat_app2.adapter.SearchUserReciclerAdapter;
import com.example.chat_app2.model.UserModel;
import com.example.chat_app2.utils.FirbaseUtil;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.Query;

public class SearchUserActivity extends AppCompatActivity {
    EditText searchInput;
    ImageButton searchButton;
    ImageButton backButton;
    RecyclerView recyclerView;

    SearchUserReciclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);
        searchInput = findViewById(R.id.search_username_input);
        searchButton = findViewById(R.id.search_user_btn);
        backButton = findViewById(R.id.back_btn);
        recyclerView = findViewById(R.id.search_user_resycler_view);
        searchInput.requestFocus();
        backButton.setOnClickListener(v -> {
            onBackPressed();
        });
        searchButton.setOnClickListener(v -> {
            String searchTerm = searchInput.getText().toString();
            if (searchTerm.isEmpty() || searchTerm.length() < 3) {
                searchInput.setError("Invalied username");
                return;
            }
            setupSearchReciclerView(searchTerm);
        });
    }

    public void setupSearchReciclerView(String searchTerm) {
        Query query = FirbaseUtil.allUsersCollectionReference()
                .whereGreaterThanOrEqualTo("userName", searchTerm);
        FirestoreRecyclerOptions<UserModel> options = new FirestoreRecyclerOptions.Builder<UserModel>()
                .setQuery(query, UserModel.class).build();
        adapter = new SearchUserReciclerAdapter(options, getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.startListening();

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (adapter != null) {
            adapter.startListening();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (adapter != null) {
            adapter.stopListening();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (adapter != null) {
            adapter.startListening();
        }
    }
}