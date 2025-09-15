package javacore.multithreadFirst;



public class Main {
    public static void main(String[] args) {
        testCounter(new UnsynchronizedCounter(), 50);

        testCounter(new VolatileCounter(), 50);
        testCounter(new SynchronizedBlockCounter(), 50);
        testCounter(new AtomicIntegerCounter(), 50);
        testCounter(new ReentrantLockCounter(), 50);
    }

    private static void testCounter(SiteVisitCounter counter, int numThreads) {
        MultithreadingSiteVisitor visitor = new MultithreadingSiteVisitor(counter);
        visitor.visitMultithread(numThreads);
        visitor.waitUntilAllVisited();

        System.out.println(counter.getClass().getSimpleName() + ":");
        System.out.println("Final count = " + visitor.getFinalCount());
        System.out.println("Time = " + visitor.getTotalTimeOfHandling() + " sec");
        System.out.println("-----------------------------");
    }
}

