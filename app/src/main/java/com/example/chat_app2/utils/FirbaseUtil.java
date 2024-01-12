package com.example.chat_app2.utils;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.auth.FirebaseAuth;

public class FirbaseUtil {
    public static String currentUsersId() {
        return FirebaseAuth.getInstance().getUid();
    }

    public static DocumentReference currentUsersDetails() {
        return FirebaseFirestore.getInstance().collection("users").document(currentUsersId());
    }

    public static boolean isLoggedIn() {
        if (currentUsersId() != null) {
            return true;

        }
        return false;
    }

    public static CollectionReference allUsersCollectionReference() {
        return FirebaseFirestore.getInstance().collection("users");
    }

    public static DocumentReference getChatroomReherence(String ChatroomId) {

        return FirebaseFirestore.getInstance().collection("chatrooms").document(ChatroomId);
    }
    public static String getChatroomId(String userId1,String userId2){
        if(userId1.hashCode() < userId2.hashCode()){
            return userId1 + "_" + userId2;
        }else
            return userId2 + "_" + userId1;
    }
}
