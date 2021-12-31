package com.adrobz.intelliconlibrary.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestRequest {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("body")
    @Expose
    private String body;

    @SerializedName("userId")
    @Expose
    private String userId;
}

