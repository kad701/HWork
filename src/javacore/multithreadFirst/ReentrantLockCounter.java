package javacore.multithreadFirst;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter implements SiteVisitCounter {
    private int counter = 0;
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void incrementVisitCount() {
        lock.lock();
        try {
            Thread.sleep(100); // sleep внутри критической секции
            counter++;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int getVisitCount() {
        return counter;
    }
}
