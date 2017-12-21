package MultiThread;

/**
 * @Author longchao
 * @Date 2017/12/19.
 */
public class TestCreateThread {
    public static void main(String[] args){
        MyThread thread1 = new MyThread("thread1");
        thread1.start();
        System.out.println("主线程="+Thread.currentThread());

        MyThread thread2 = new MyThread("thread2");
        thread2.run();

        Thread thread3 = new Thread(new MyRunnable("Thread3"));
        thread3.start();
    }
}

//返回结果：
//主线程=Thread[main,5,main]
//name=thread2Thread[main,5,main]
//name=thread1Thread[Thread-0,5,main]
//name=Thread3Thread[Thread-2,5,main]
//说明调用run()方法并不会启用新的线程
