package io.client;

import io.handler.TimeClientHandle;

/**
 * NIO 客户端s
 */
public class TimeClient2 {
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0){
            port = Integer.parseInt(args[0]);
        }
        new Thread(new TimeClientHandle("127.0.0.1", port), "NIO-TimeClient-001").start();
    }
}
