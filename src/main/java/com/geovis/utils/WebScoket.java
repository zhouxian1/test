package com.geovis.utils;

import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;

/**
 * Created by Administrator on 2019/1/11.
 */
public class WebScoket {

    public static WebSocketClient client;

    public static void main(String[] args){
        try {
            client = new WebSocketClient(new URI("ws://localhost:18670/websocket/1-343"),new Draft_17()) {

                @Override
                public void onOpen(ServerHandshake arg0) {
                    System.out.println("打开链接");
                }

                @Override
                public void onMessage(String arg0) {
                    System.out.println("收到消息"+arg0);
                }

                @Override
                public void onError(Exception arg0) {
                    arg0.printStackTrace();
                    System.out.println("发生错误已关闭");
                }

                @Override
                public void onClose(int arg0, String arg1, boolean arg2) {
                    System.out.println("链接已关闭");
                }

                @Override
                public void onMessage(ByteBuffer bytes) {
                    try {
                        System.out.println(new String(bytes.array(),"utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }


            };
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        client.connect();

        while(!client.getReadyState().equals(WebSocket.READYSTATE.OPEN)){
            System.out.println("还没有打开");
        }
        System.out.println("打开了");
        client.send("hello world");
    }
}
