package netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;

public class EchoServerHandler extends ChannelHandlerAdapter {
    int counter = 0;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
//        String body = new String(req, "UTF-8");
//        String body = (String) msg;
//        byte[] req = body.getBytes();
//        body = new String(req, "UTF-8");
        String body = new String(req, "GBK");
//        body = new String(req, "GB2312");
        System.out.println("Receive client:[" + body + "]");
//        System.out.println("This is " + ++counter  + " times receive client:[" + body + "]");
//        body += "$_";
        ByteBuf echo = Unpooled.copiedBuffer(body.getBytes());
        ctx.writeAndFlush(echo);
    }

//    @Override
//    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception{
//        //发送缓冲区中消息
//        ctx.flush();
//    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
