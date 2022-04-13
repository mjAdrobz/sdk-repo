package com.adrobz.intelliconlibrary.Interface;

public interface ResponseCallback {
    void onSuccess(String response);

    void onError(String error);
}
