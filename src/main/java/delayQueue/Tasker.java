package delayQueue;

import lombok.Data;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * TODO some word
 *
 * @author Long Chao
 * @version 1.0
 * @date 2019-05-24
 */
@Data
public class Tasker implements Delayed {
    private int id;
    private String body;
    private long delayTime;
    private TimeUnit timeUnit;
    private long executorTime;

    public Tasker(int id, String body, long delayTime, TimeUnit timeUnit) {
        this.id = id;
        this.body = body;
        this.timeUnit = timeUnit;
        this.executorTime = System.currentTimeMillis() + timeUnit.toMillis(delayTime);
    }

    @Override
    public int compareTo(Delayed o) {
        Tasker tasker = (Tasker)o;
        if (this.executorTime > tasker.executorTime) {
            return 1;
        } else if (this.executorTime < tasker.executorTime) {
            return -1;
        }
        return 0;
    }

    @Override
    public long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(this.executorTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }
}
