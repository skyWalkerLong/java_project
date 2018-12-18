package MultiThread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS实例，1000个线程同时对共享变量做累加操作
 *
 * @author Long Chao
 * @version 1.0
 * @data 2018-12-18
 */
public class CASTest {
    private static AtomicInteger a = new AtomicInteger(0);

    public static void main(String[] args) {
        for(int i=0;i<1000;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //while中的代码为incrementAndGet()的源码，我们可以自定义next的值，而incrementAndGet()只能+1
                    while (true) {
                        //获取当前a的int值
                        int current = a.get();
                        //期望值
                        int next = current+1;
                        //a.compareAndSet(current, next) cas原理，拿current跟内存中的a比较，相等说明此时a未被其他线程修改，就将a设置为next，并返回true
                        //上述过程是一个原子操作，故能保证安全性
                        if(a.compareAndSet(current, next)){
                            System.out.println(next);
                            return;
                        }
                    }

//                    System.out.println(a.incrementAndGet());
                }
            }).start();
        }
    }
}
