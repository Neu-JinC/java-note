package nio.netty.demo;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
/**
 * 处理服务端通道
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter{ //(1)
    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg){ //(2)
        //默默的丢弃接收到的数据
        ((ByteBuf) msg).release(); //(3)
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){ //(4)
        //出现异常时关闭链接
        cause.printStackTrace();
        ctx.close();
    }
}
