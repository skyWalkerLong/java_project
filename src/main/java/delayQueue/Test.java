package delayQueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * TODO some word
 *
 * @author Long Chao
 * @version 1.0
 * @date 2019-05-24
 */
public class Test {

    public static void main(String[] args) {
        DelayQueue<Tasker> delayQueue = new DelayQueue<>();
        delayQueue.add(new Tasker(1,"hello", 20, TimeUnit.SECONDS));
        delayQueue.add(new Tasker(2,"world", 40, TimeUnit.SECONDS));

        System.out.println("tasker put done");

        while (! delayQueue.isEmpty()) {
            try {
                Tasker tasker = delayQueue.take();
                System.out.println(tasker.getId());
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
