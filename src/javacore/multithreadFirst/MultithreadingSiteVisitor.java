package javacore.multithreadFirst;

import java.util.ArrayList;
import java.util.List;

public class MultithreadingSiteVisitor {
    private final SiteVisitCounter counter;
    private final List<Thread> threads = new ArrayList<>();
    private long startTime;
    private long endTime;

    public MultithreadingSiteVisitor(SiteVisitCounter counter) {
        this.counter = counter;
    }

    public void visitMultithread(int numOfThreads) {
        startTime = System.currentTimeMillis();
        for (int i = 0; i < numOfThreads; i++) {
            Thread t = new Thread(counter::incrementVisitCount);
            threads.add(t);
            t.start();
        }
    }

    public void waitUntilAllVisited() {
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        endTime = System.currentTimeMillis();
    }

    public double getTotalTimeOfHandling() {
        return (endTime - startTime) / 1000.0;
    }

    public int getFinalCount() {
        return counter.getVisitCount();
    }
}

