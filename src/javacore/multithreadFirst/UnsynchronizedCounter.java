package javacore.multithreadFirst;

public class UnsynchronizedCounter implements SiteVisitCounter {
    private int counter = 0;

    @Override
    public void incrementVisitCount() {
        try {
            Thread.sleep(100); // имитация нагрузки
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
