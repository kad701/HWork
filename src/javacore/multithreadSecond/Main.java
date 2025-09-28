package javacore.multithreadSecond;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        DataProcessor processor = new DataProcessor(10);

        // Запуск 100 задач
        for (int i = 0; i < 100; i++) {
            List<Integer> numbers = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
            processor.submitTask(numbers);
        }

        // Ждем завершения всех запущенных задач
        while (processor.getActiveTasksCount() > 0) {
            System.out.println("Активных задач: " + processor.getActiveTasksCount());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        //  Результаты
        for (int i = 1; i <= 100; i++) {
            String taskName = "task" + i;
            System.out.println(taskName + " результат: " + processor.getResult(taskName).orElse(null));
        }

        processor.shutdown();
    }
}
