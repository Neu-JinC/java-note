package book.concurrent.beautiful.chapter.six;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

public class FIFOMutex {
    private final AtomicBoolean locked = new AtomicBoolean(Boolean.FALSE);
    private final Queue<Thread> waiter = new ConcurrentLinkedQueue<Thread>();

    public void lock() {
        boolean wasInterrupted = Boolean.FALSE;
        Thread current = Thread.currentThread();
        waiter.add(current);

        //只有队首线程可以获取锁
        while (waiter.peek() != current || !locked.compareAndSet(false, true)) {
            LockSupport.park();
            if (Thread.interrupted()) {
                wasInterrupted = true;
            }
        }

        waiter.remove();

        if(wasInterrupted) {
            current.interrupt();
        }
    }

    public void unlock() {
        locked.set(false);
        LockSupport.unpark(waiter.peek());
    }
}
