package netty.handler;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import model.SubscribeReq;

/**
 * 测试 NIO 序列化 客户端
 */
public class SubReqClientHandler extends ChannelHandlerAdapter {

    /**
     * 无参构造方法
     */
    public SubReqClientHandler() {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx){
        for(int i = 0; i < 10; i++){
            ctx.write(subReq(i));
        }
        ctx.flush();
    }

    private SubscribeReq subReq(int i){
        SubscribeReq req = new SubscribeReq();
        req.setAddress("杭州市滨江区建业路浙大科技园");
        req.setPhoneNumber("15869133169");
        req.setProductName("Netty 权威指南 学习");
        req.setSubReqID(i);
        req.setUserName("yuyansen");
        return req;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
        System.out.println("Receive server response : [" + msg + "]");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx){
        ctx.flush();
    }

    /**
     * 遇异常,关闭
     * @param ctx
     * @param cause
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }
}
