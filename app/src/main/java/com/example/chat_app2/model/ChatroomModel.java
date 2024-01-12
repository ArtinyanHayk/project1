package com.example.chat_app2.model;

import com.google.firebase.Timestamp;

import java.util.List;

public class ChatroomModel {
    String ChatroomId;
    List<String> userIds;
    Timestamp LastMessageTimestamp;
    String lastMessageSenderId;

    public ChatroomModel() {
    }

    public ChatroomModel(String chatroomId, List<String> userIds, Timestamp lastMessageTimestamp, String lastMessageSenderId) {
        ChatroomId = chatroomId;
        this.userIds = userIds;
        LastMessageTimestamp = lastMessageTimestamp;
        this.lastMessageSenderId = lastMessageSenderId;
    }

    public String getChatroomId() {
        return ChatroomId;
    }

    public void setChatroomId(String chatroomId) {
        ChatroomId = chatroomId;
    }

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }

    public Timestamp getLastMessageTimestamp() {
        return LastMessageTimestamp;
    }

    public void setLastMessageTimestamp(Timestamp lastMessageTimestamp) {
        LastMessageTimestamp = lastMessageTimestamp;
    }

    public String getLastMessageSenderId() {
        return lastMessageSenderId;
    }

    public void setLastMessageSenderId(String lastMessageSenderId) {
        this.lastMessageSenderId = lastMessageSenderId;
    }

}
