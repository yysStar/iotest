package io.client;

import io.handler.AsyncTimeClientHandler;

/**
 * AIO 客户端
 */
public class TimeClient3 {
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0){
            port = Integer.parseInt(args[0]);
        }
        new Thread(new AsyncTimeClientHandler("127.0.0.1", port),
                "AIO-AsyncTimeClientHandler-001").start();
    }
}
