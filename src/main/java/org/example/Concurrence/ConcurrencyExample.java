package org.example.Concurrence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrencyExample {
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        // Create ExecutorService with a fixed thread pool size
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        // Submit tasks for concurrent execution
        for (int i = 1; i <= THREAD_POOL_SIZE; i++) {
            executorService.execute(new Task("Task " + i));
        }

        // Shutdown the ExecutorService
        executorService.shutdown();
    }

    static class Task implements Runnable {
        private final String taskName;

        public Task(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public void run() {
            // Simulate some task execution
            for (int i = 1; i <= 3; i++) {
                System.out.println(taskName + " - Step " + i);
                try {
                    // Simulate a task taking some time
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}