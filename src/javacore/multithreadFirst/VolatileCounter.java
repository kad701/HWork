package javacore.multithreadFirst;

public class VolatileCounter  implements SiteVisitCounter{
    private volatile int counter = 0;

    @Override
    public void incrementVisitCount() {
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
