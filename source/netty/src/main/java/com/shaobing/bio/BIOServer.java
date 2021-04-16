package com.shaobing.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer {
    public static void main(String[] args) throws IOException {
        //1.创建线程池
        ExecutorService service = Executors.newCachedThreadPool();
        //2.如果有客户端连接，就创建一个线程，进行通讯，单独写一个方法
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器启动....");
        while (true){
            //监听，等待客户端连接
            final Socket socket = serverSocket.accept();
            System.out.println("客户端连接...");
            //就创建一个线程，与之通讯（单独写一个方法）
            service.execute(new Runnable() {
                public void run() {//重写run方法
                    handler(socket);
                }
            });
        }
    }
    //编写handle方法，和客户端进行通讯
    public static void handler(Socket socket){
        byte[] bytes = new byte[1024];
        try {
            //通过socker获取输入流
            InputStream inputStream = socket.getInputStream();
            while (true){
                int read = inputStream.read(bytes);
                if (read!=-1){
                    System.out.println(new String(bytes,0,read));
                }else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("关闭连接....");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
