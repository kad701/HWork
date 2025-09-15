package javacore.multithreadFirst;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerCounter implements SiteVisitCounter{
    private final AtomicInteger counter = new AtomicInteger(0);
    @Override
    public synchronized void  incrementVisitCount() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        counter.incrementAndGet();
    }

    @Override
    public int getVisitCount() {
        return counter.get();
    }
}
