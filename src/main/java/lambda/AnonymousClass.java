package lambda;

/**
 * @Author longchao
 * @Date 2018/1/24.
 */
public class AnonymousClass {
    public static void main(String[] args) {
        /**
         * 匿名内部类方式
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("ok");
            }
        }).start();

        /**
         * lambda方式
         */
        new Thread(() -> System.out.println("lambda ok")).start();
    }
}
