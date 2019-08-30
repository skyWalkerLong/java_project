package MultiThread;

import java.util.concurrent.locks.LockSupport;

/**
 * wait与park的区别
 *
 * @author Long Chao
 * @version 1.0
 * @date 2019-08-30
 */
public class WaitTest {
    public static void main(String[] args) throws Exception{
        Thread t = Thread.currentThread();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("start unpark");
                LockSupport.unpark(t);
            }
        }).start();

        System.out.println("start block thread");
        LockSupport.park();
        System.out.println("out");

        Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock) {
                    System.out.println("start notify");
                    lock.notify();
                }
            }
        }).start();
        synchronized (lock) {
            System.out.println("start block");
            lock.wait();
        }
        System.out.println("out");
    }
}
