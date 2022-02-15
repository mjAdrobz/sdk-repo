package com.adrobz.intelliconlibrary.Socket;


import java.net.URI;

import io.socket.client.IO;
import io.socket.client.Manager;
import io.socket.client.Socket;


public class SocketHandler {
    private Socket mSocket;
    private Manager manager;
    IO.Options options = new IO.Options();
    private static final String URL = "https://dbcsm.contegris.com:50000/mobile";

    public void setSocket(String token, String config) {
        options.transports = new String[]{"websocket", "polling"};
        options.query = "token=" + token + "&configs=" + config;
        options.path = "/cx9dev/socket/mobile";
        try {
            manager = new Manager(new URI(URL), options);
            mSocket = manager.socket("/mobile");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Socket getSocket() {
        return mSocket;
    }
}
