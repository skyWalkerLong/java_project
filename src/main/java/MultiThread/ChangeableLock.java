package MultiThread;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 多样锁，随意控制同时有多少个线程获取锁
 *
 * @author Long Chao
 * @version 1.0
 * @date 2019-09-04
 */
public class ChangeableLock {

    private Sync sync;

    public ChangeableLock(int count) {
        sync = new Sync(count);
    }

    private static final class Sync extends AbstractQueuedSynchronizer {
        Sync(int count) {
            if (count <= 0) {
                throw new IllegalArgumentException("count must large than zero");
            }
            setState(count);
        }

        /**
         * 共享锁要用shared
         * @param reduceCount
         * @return
         */
        @Override
        public int tryAcquireShared(int reduceCount) {
            for(;;) {
                int current = getState();
                int newCount = current - reduceCount;
                if (newCount < 0 || compareAndSetState(current, newCount)) {
                    return newCount;
                }
            }
        }

        @Override
        public boolean tryReleaseShared(int returnCount) {
            for(;;) {
                int current = getState();
                int newCount = current + returnCount;
                if (compareAndSetState(current, newCount)) {
                    return true;
                }
            }
        }
    }

    public void lock() {
        sync.acquireShared(1);
    }

    public void unlock() {
        sync.releaseShared(1);
    }
}
