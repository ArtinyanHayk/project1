package com.example.chat_app2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
BottomNavigationView bottomNavigationView;
ImageButton search_btn;
ChatFragment chatFragment;
ProfileFragment profileFragment;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      chatFragment = new ChatFragment();
      profileFragment = new ProfileFragment();
      bottomNavigationView = findViewById(R.id.bottom_navigation);
    search_btn = findViewById(R.id.search_btn);
    search_btn.setOnClickListener(v -> {
        Intent intent = new Intent(MainActivity.this,SearchUserActivity.class);
        startActivity(intent);

    });
     bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
         @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if(item.getItemId() == R.id.menu_chat){
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_layout,chatFragment).commit();
            }
            if(item.getItemId() == R.id.menu_profile){
                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_layout,profileFragment).commit();
            }
            return true;
        }
    });
    bottomNavigationView.setSelectedItemId(R.id.menu_chat);
    }
}