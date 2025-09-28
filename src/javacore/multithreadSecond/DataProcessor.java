package javacore.multithreadSecond;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class DataProcessor {
    private final ExecutorService executorService;
    private final AtomicInteger taskCounter = new AtomicInteger(0);
    private final AtomicInteger activeTasks = new AtomicInteger(0);


    private final Map<String, Integer> results = new HashMap<>();

    public DataProcessor(int threads) {
        this.executorService = Executors.newFixedThreadPool(threads);
    }

    public void submitTask(List<Integer> numbers) {
        String taskName = "task" + taskCounter.incrementAndGet();
        CalculateSumTask task = new CalculateSumTask(numbers, taskName);

        activeTasks.incrementAndGet();

        Future<Integer> future = executorService.submit(task);

        // обработка результата
        executorService.submit(() -> {
            try {
                Integer result = future.get();
                synchronized (results) {
                    results.put(taskName, result);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                activeTasks.decrementAndGet();
            }
        });
    }

    public int getActiveTasksCount() {
        return activeTasks.get();
    }

    public Optional<Integer> getResult(String taskName) {
        synchronized (results) {
            return Optional.ofNullable(results.get(taskName));
        }
    }

    public void shutdown() {
        executorService.shutdown();
    }
}

