package com.example.mybatis.mybatisdemo.model;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.Scanner;

public class Java8Test {

    //用作网络通信中的客户端
    public static void main(String[] args) throws IOException {

        //1：创建客户端通道
        Pipe pipe = Pipe.open();

        //2：创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //3: pipe管道写入数据
        Pipe.SinkChannel sinkChannel = pipe.sink();
        byteBuffer.put("你好啊".getBytes());
        byteBuffer.flip();
        sinkChannel.write(byteBuffer);

        //读取缓冲区的数据
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);
        Pipe.SourceChannel source = pipe.source();
        int len = source.read(byteBuffer1);
        System.out.println(new String(byteBuffer1.array(),0,len));

        //5：关闭
        sinkChannel.close();
        source.close();
    }
}
