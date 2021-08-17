package com.example.mybatis.mybatisdemo.model;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Scanner;

public class Test3 {
    //用作网络通信中的客户端
    public static void main(String[] args) throws IOException {
        //1：创建客户端通道，并且绑定服务端ip，端口
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9999));

        //2：切换非阻塞模式
        socketChannel.configureBlocking(false);

        //3：创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //4：往缓冲区写数据，在写到通道中
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.next();
            byteBuffer.put((new Date().toString()+"\n"+str).getBytes());
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        //5：关闭
        socketChannel.close();
    }
}
