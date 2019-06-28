package io.server;

import io.handler.AsyncTimeServerHandler;

/**
 * AIO 服务器
 */
public class TimeServer4 {

    public static void main(String[] args) {
        int port = 8080;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);

        new Thread(timeServer, "AIO-AsyncTimeServerHandler-001").start();
    }
}
