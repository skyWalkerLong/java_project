package MultiThread;

/**
 * @Author longchao
 * @Date 2017/12/19.
 */
public class ThreadSynchronizedTest implements Runnable {
    private static int a = 0;
    private String name;
    //方法1：synchronized代码块
//    @Override
//    public void run() {
//        synchronized (this) {
//            System.out.println("enter");
//            try {
//                //Thread.sleep(2000);
//                a++;
//                System.out.println("name=" + Thread.currentThread().getName() + " id=" + Thread.currentThread().getId() + " a=" + a);
//                Thread.sleep(2000);
//            } catch (Exception e) {
//                System.out.println(e.toString());
//            }
//
//        }
//
//    }

    //方法2：synchronized修饰方法
    @Override
    public synchronized void run() {
        System.out.println("enter");
        try {
            //Thread.sleep(2000);
            a++;
            System.out.println("name=" + Thread.currentThread().getName() + " id=" + Thread.currentThread().getId() + " a=" + a);
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void main(String[] args) {
        ThreadSynchronizedTest myThread = new ThreadSynchronizedTest();//对象唯一
        Thread thread1 = new Thread(myThread, "t1");
        Thread thread2 = new Thread(myThread, "t2");
        thread1.start();
        thread2.start();
    }
}

//输出结果如下：
//enter
//name=t1 id=11 a=1
//enter
//name=t2 id=12 a=2

//synchronized作用在方法上，作用域是该类的同一对象；synchronized作用在静态方法上，作用域是该类的所有对象