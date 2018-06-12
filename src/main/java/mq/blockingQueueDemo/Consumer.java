//package mq.blockingQueueDemo;
//
//import java.util.Random;
//import java.util.concurrent.BlockingQueue;
//
///**
// * @author longchao
// * @date 2018/6/12.
// */
//public class Consumer implements Runnable {
//    BlockingQueue<String> queue;
//    public Consumer(BlockingQueue<String> queue) {
//        this.queue = queue;
//    }
//    @Override
//    public void run() {
//        Random random = new Random();
//        try {
//            while(true){
//                Thread.sleep(3000);
//                System.out.println(Thread.currentThread().getName()+ "准备消费...");
//                String temp = queue.take();//从队列中取任务消费，如果队列为空，会阻塞当前线程
//                System.out.println(Thread.currentThread().getName() + " 获取到工作任务==== " +temp);
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
