package javacore.multithreadFirst;

public class SynchronizedBlockCounter implements SiteVisitCounter{
    private int counter=0;
    @Override
    public synchronized void  incrementVisitCount() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        counter++;
    }

    @Override
    public int getVisitCount() {
        return counter;
    }
}
