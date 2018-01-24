package asynchronous;

import java.util.concurrent.CountDownLatch;

/**
 * @Author longchao
 * @Date 2018/1/16.
 */
public class ThreadApplication {
    public static void main(String[] args) {
        System.out.println("111");
        CountDownLatch countDownLatch = new CountDownLatch(2);//等待多少个线程
        //实际项目中不建议使用new的方式来创建线程，spring中通过线程池来创建线程，线程池只要配置一下就可以使用
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("222");
                countDownLatch.countDown();
            }
        }).start();//线程创建方式1

        new Thread(
                () -> {System.out.println("333");
                countDownLatch.countDown();}
        ).start();//线程创建方式2，lambda表达式


        try {
            countDownLatch.await();//等待上述定义的线程数执行完毕

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("444");

    }
}
