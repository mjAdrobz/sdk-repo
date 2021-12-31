package com.adrobz.intelliconlibrary.Model;

import com.google.gson.annotations.SerializedName;

public class TestResponse {

    @SerializedName("title")
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    String title;

    @SerializedName("body")
    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    String body;

    @SerializedName("userId")
    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    int userId;

    @SerializedName("id")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;
}

