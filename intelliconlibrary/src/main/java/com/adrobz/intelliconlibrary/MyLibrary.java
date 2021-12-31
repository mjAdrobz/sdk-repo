package com.adrobz.intelliconlibrary;

import android.content.Context;
import android.widget.Toast;

import com.adrobz.intelliconlibrary.API.Api;
import com.adrobz.intelliconlibrary.Interface.ResponseCallback;

import java.util.HashMap;
import java.util.Map;

public class MyLibrary {

    public void myToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public void fetchRecord(String title, String body, String userId, Context context, ResponseCallback callback) {
        Map<String, String> params = new HashMap<>();
        params.put("userId", userId);
        params.put("body", body);
        params.put("title", title);
        try {

            Api.httpPostRequest(context,
                    params,
                    "posts",
                    new ResponseCallback() {
                        @Override
                        public void onSuccess(String response) {
                            callback.onSuccess(response);
                        }

                        @Override
                        public void onError(String error) {
                            callback.onError(error);
                        }
                    });
        } catch (Exception exception) {
            myToast(context, exception.getMessage());
        }

    }

}
