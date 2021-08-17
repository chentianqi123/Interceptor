package com.example.mybatis.mybatisdemo.model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

public class Java8Test1 {

    //用作网络通信的服务端
    public static void main(String[] args) throws IOException {
        //1：建立服务端通道
        DatagramChannel datagramChannel = DatagramChannel.open();

        //2：切换非阻塞模式
        datagramChannel.configureBlocking(false);

        //3:绑定服务端的端口号，用于给客户端使用
        datagramChannel.bind(new InetSocketAddress("127.0.0.1", 9999));

        //4：获取选择器
        Selector selector = Selector.open();

        //5：将通道注册到选择器上，并且指定“监听接收事件”
        datagramChannel.register(selector, SelectionKey.OP_READ);

        //6：轮询式的获取选择器上已经“准备就绪”的事件
        while(selector.select() > 0){
            //7：获取当前选择器上所有注册的“选择键（已就绪的监听事件）”
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            while(keyIterator.hasNext()){
                //8：获取准备就绪的事件
                SelectionKey key = keyIterator.next();
                if(key.isReadable()){

                    // 9:读取数据
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    datagramChannel.receive(byteBuffer);
                    byteBuffer.flip();
                    System.out.println(new String(byteBuffer.array(),0,byteBuffer.limit()));
                    byteBuffer.clear();

                }

            }
            //10：取消选择键
            keyIterator.remove();
        }

        //8：关闭
        datagramChannel.close();

    }
}
