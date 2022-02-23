package com.adrobz.intelliconlibrary.Model.UserConversation;

import com.google.gson.annotations.SerializedName;

public class UserConversation {
    @SerializedName("conversation")
    public Conversation conversation;

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
}
