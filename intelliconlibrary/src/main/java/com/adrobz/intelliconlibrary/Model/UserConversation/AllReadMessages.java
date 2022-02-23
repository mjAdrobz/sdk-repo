package com.adrobz.intelliconlibrary.Model.UserConversation;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class AllReadMessages {
    @SerializedName("_id")
    public String _id;
    @SerializedName("username")
    public String username;
    @SerializedName("timestamp")
    public Date timestamp;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
