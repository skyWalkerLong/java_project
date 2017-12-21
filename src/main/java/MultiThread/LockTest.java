package MultiThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author longchao
 * @Date 2017/12/20.
 */
public class LockTest implements Runnable{
    private static int a = 0;
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        lock.lock();//获取锁
            System.out.println("enter");
            try {
                a++;
                System.out.println("name=" + Thread.currentThread().getName() + " id=" + Thread.currentThread().getId() + " a=" + a);
            } catch (Exception e) {
                System.out.println(e.toString());
            }finally {
                lock.unlock();//一定要释放锁，否则一直阻塞
            }


    }

    public static void main(String[] args) {
        LockTest myThread = new LockTest();
        Thread thread1 = new Thread(myThread, "t1");
        Thread thread2 = new Thread(myThread, "t2");
        thread1.start();
        thread2.start();
    }
}
