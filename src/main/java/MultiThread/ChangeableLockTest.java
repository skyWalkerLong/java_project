package MultiThread;

import org.junit.Test;

/**
 * 多样锁测试用例
 *
 * @author Long Chao
 * @version 1.0
 * @date 2019-09-04
 */
public class ChangeableLockTest {
    @Test
    public void testLock() throws InterruptedException {
        ChangeableLock lock = new ChangeableLock(1);

        class Worker extends Thread {
            @Override
            public void run() {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "-locked");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + "-unlock");
                    lock.unlock();
                }
            }
        }

        for (int a = 0; a < 200; a++) {
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }

        Thread.sleep(10000000);
    }
}
