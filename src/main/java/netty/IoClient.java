package netty;

import java.net.Socket;
import java.util.Date;

/**
 * TODO some word
 *
 * @author Long Chao
 * @version 1.0
 * @date 2019-09-06
 */
public class IoClient {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Socket socket1 = new Socket("127.0.0.1", 8080);
                    Socket socket2 = new Socket("127.0.0.1", 8080);

                    System.out.println(socket1.toString());
                    System.out.println(socket2.toString());

                    while(true) {
                        socket1.getOutputStream().write((new Date() + ": hello world1").getBytes());
                        socket1.getOutputStream().flush();

                        socket2.getOutputStream().write((new Date() + ": hello world2").getBytes());
                        socket2.getOutputStream().flush();
                        Thread.sleep(5000);
                    }
                } catch (Exception e) {

                }
            }
        }).start();
    }
}
