package com.adrobz.intelliconlibrary.Model.UserConversation;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Conversation {
    @SerializedName("cid")
    public int cid;
    @SerializedName("messages")
    public ArrayList<AllChatMessages> messages;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public ArrayList<AllChatMessages> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<AllChatMessages> messages) {
        this.messages = messages;
    }
}
