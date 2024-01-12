package com.example.chat_app2.utils;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.chat_app2.model.UserModel;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AndroidUtil {
   public  static void showToast(Context context, String message){
       Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
    public static void passUserModelAsIntent(Intent intent, UserModel userModel){
       intent.putExtra("userName", userModel.getUserName());
        intent.putExtra("phone", userModel.getPhone());
        intent.putExtra("userId", userModel.getUserId());
    }
    public static UserModel getUserModelFromIntent(Intent intent) {
        UserModel usermodel = new UserModel();
        usermodel.setUserName(intent.getStringExtra("userName"));
        usermodel.setPhone(intent.getStringExtra("phone"));
        usermodel.setUserId(intent.getStringExtra("userId"));
        return usermodel;
    }


}
