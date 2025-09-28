package javacore.multithreadSecond;

import java.util.List;
import java.util.concurrent.Callable;

public class CalculateSumTask implements Callable<Integer> {
    private final List<Integer> numbers;
    private final String taskName;

    public CalculateSumTask(List<Integer> numbers, String taskName) {
        this.numbers = numbers;
        this.taskName = taskName;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Запуск " + taskName + " в потоке " + Thread.currentThread().getName());
        Thread.sleep(200); // таймер долгой работы
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        return sum;
    }


}
