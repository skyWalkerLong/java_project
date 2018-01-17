package asynchronous;

import java.util.concurrent.CompletableFuture;

/**
 * @Author longchao
 * @Date 2018/1/16.
 */
public class CompletableFutureTest {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        try {
            long startTime = System.currentTimeMillis();
            CompletableFuture<Object> baseInfo = CompletableFuture.supplyAsync(() -> test(a));//启动第一个线程执行方法

            CompletableFuture<Object> timeInfo = CompletableFuture.supplyAsync(() -> test(b));//启动第二个线程执行方法

            CompletableFuture[] futures = {baseInfo, timeInfo};
            CompletableFuture.allOf(futures).join();//等待两个线程结果执行完
            long endTime = System.currentTimeMillis();
            System.out.println(endTime-startTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print("ok");
    }

    public static Object test(Integer s) {
        String a ="01";
        System.out.println(Integer.valueOf(a));
        return s;
    }
}
