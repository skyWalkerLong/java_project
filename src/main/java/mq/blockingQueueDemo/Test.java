package mq.blockingQueueDemo;

import java.util.concurrent.*;

/**
 * @author longchao
 * @date 2018/6/12.
 */
public class Test {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);

        ExecutorService executorServiceConsumer = Executors.newFixedThreadPool(1);

        for(int i = 0;i<20;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String temp =  Thread.currentThread().getName()+"：生产线程";
                        queue.put(temp);//向队列中放数据，如果队列是满的话，会阻塞当前线程
                        System.out.println(Thread.currentThread().getName()+"--------生产完成");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        executorServiceConsumer.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(10000);
                        System.out.println(Thread.currentThread().getName() + "准备消费...");
                        String temp = queue.take();//从队列中取任务消费，如果队列为空，会阻塞当前线程
                        System.out.println(Thread.currentThread().getName() + " 消费完成 " + temp);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            });
    }

}
