//package mq.blockingQueueDemo;
//
//import java.util.concurrent.BlockingQueue;
//
///**
// * @author longchao
// * @date 2018/6/12.
// */
//public class Product implements Runnable{
//    BlockingQueue<String> queue;
//    public Product(BlockingQueue<String> queue) {
//
//        this.queue = queue;
//    }
//    @Override
//    public void run(){
//        try {
//            System.out.println(Thread.currentThread().getName()+"开始生产");
//            String temp =  Thread.currentThread().getName()+"：生产线程";
//            queue.put(temp);//向队列中放数据，如果队列是满的话，会阻塞当前线程
//            System.out.println(Thread.currentThread().getName()+"--------生产完成");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
