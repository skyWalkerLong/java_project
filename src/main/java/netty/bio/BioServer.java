package netty.bio;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 阻塞io服务端
 *
 * bio轮询检查是否有新的socket连接，来一个连接，就创建一个线程来处理该连接，即使该连接没有数据可读
 *
 * @author Long Chao
 * @version 1.0
 * @date 2019-09-06
 */
public class BioServer {

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(8080);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("block..." + Thread.currentThread().getName());
                        //若没有新连接，accept()方法会阻塞
                        Socket socket = serverSocket.accept();
                        System.out.println("unblock" + Thread.currentThread().getName());
                        System.out.println("socket:" + socket.toString());
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    byte[] data = new byte[1024];
                                    InputStream inputStream = socket.getInputStream();
                                    while (true) {
                                        int len;
                                        while ((len = inputStream.read(data)) != -1) {
                                            System.out.println(Thread.currentThread().getName() + "--" + new String(data, 0, len));
                                        }
                                    }
                                } catch (Exception e) {

                                }
                            }
                        }).start();
                    } catch (Exception e) {

                    }
                }

            }
        }).start();
    }
}

