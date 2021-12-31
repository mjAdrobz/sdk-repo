package com.adrobz.intelliconlibrary.API;

import android.content.Context;

import com.adrobz.intelliconlibrary.Interface.ResponseCallback;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

public class Api {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    public static void httpGetDataRequest(Context context, String url, ResponseCallback callback) {

        StringRequest request = new StringRequest(BASE_URL + url, response -> {

            System.out.println(response);
            callback.onSuccess(response);
        }, error -> callback.onError(error.toString()));

        RequestQueue queue = Volley.newRequestQueue(context);
        request.setRetryPolicy(new DefaultRetryPolicy(30000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);
    }


    public static void httpPostRequest(Context context, Map<String, String> requestBody, String url, ResponseCallback callback) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest jsonObjectRequest = new StringRequest(Request.Method.POST, BASE_URL + url, response -> {
            System.out.println(response);
            callback.onSuccess(response);
        }, error -> callback.onError(error.getMessage())
        ) {
            @Override
            protected Map<String, String> getParams() {
                return requestBody;
            }

        };
        requestQueue.add(jsonObjectRequest);
    }


}
