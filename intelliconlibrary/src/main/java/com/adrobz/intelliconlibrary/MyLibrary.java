package com.adrobz.intelliconlibrary;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.adrobz.intelliconlibrary.API.Api;
import com.adrobz.intelliconlibrary.Interface.SocketInterface;
import com.adrobz.intelliconlibrary.Interface.ResponseCallback;
import com.adrobz.intelliconlibrary.Socket.SocketHandler;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class MyLibrary {

    public Socket mSocket;
    final Activity mContext;

    public MyLibrary(Activity mContext) {
        this.mContext = mContext;
    }

    public void myToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public void fetchUserToken(String endPoint, String id, String userId, Context context, ResponseCallback responseCallback) {
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        params.put("userId", userId);
        try {
            Api.httpPostRequest(context,
                    params,
                    endPoint,
                    new ResponseCallback() {
                        @Override
                        public void onSuccess(String response) {
                            responseCallback.onSuccess(response);
                        }

                        @Override
                        public void onError(String error) {
                            responseCallback.onError(error);
                        }
                    });
        } catch (Exception exception) {
            myToast(context, exception.getMessage());
        }

    }

    public void initializeSocket(String token, String configs) {

        SocketHandler socketHandler = new SocketHandler();
        socketHandler.setSocket(token, configs);
        mSocket = socketHandler.getSocket();
        mSocket.on(Socket.EVENT_CONNECT_ERROR, onConnectError);
        mSocket.on(Socket.EVENT_CONNECT, onConnect);
        mSocket.on(Socket.EVENT_DISCONNECT, onDisconnect);
        mSocket.connect();
    }

    public Emitter.Listener onConnect = args -> {
        Log.d("Hello socket", "My Library Socket Connected!");
    };

    public final Emitter.Listener onConnectError = args -> {
        Log.d("error", args[0] + "");
    };
    public final Emitter.Listener onDisconnect = args -> {
        Log.d("mSocket.id() Disco", mSocket.id() + "");
        Log.d("TAG", "Socket Disconnected!");
    };

    public void initiateChat(String message) {
        JSONObject obj = new JSONObject();
        try {
            obj.put("text", message);
            obj.put("cid", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mSocket.emit("letsChat", obj);
    }

    public void sendMessage(String message, String cId) {
        JSONObject obj = new JSONObject();
        try {
            obj.put("text", message);
            obj.put("cid", cId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mSocket.emit("message", obj);
    }

    public void fetchUserConversation(String userId, SocketInterface callback) {
        JSONObject obj = new JSONObject();
        try {
            obj.put("userId", userId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mSocket.emit("fetchConversation", obj);
    }

    public void fetchConversationResponse(SocketInterface callback) {
        Emitter.Listener onNewMessage = args -> {
            callback.onResponse(args[0].toString());
        };
        mSocket.on("fetchConversationResponse", onNewMessage);
    }

    public void fetchMessage(SocketInterface callback) {
        Emitter.Listener onNewMessage = args -> callback.onResponse(args[0].toString());
        mSocket.on("message", onNewMessage);
    }

    public void letsChatResponse(SocketInterface callback) {
        Emitter.Listener letsChatResponse = args -> {
            callback.onResponse(args[0].toString());
        };
        mSocket.on("letsChatResponse", letsChatResponse);
    }

}
