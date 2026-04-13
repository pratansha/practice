package all.tech.practice.java.multithreading.core;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreExample {
    private static final Semaphore SEMAPHORE = new Semaphore(3); // 3 permits

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 10; i++) {
            int taskId = i;
            System.out.println("Task initilized :" + taskId);
            pool.submit(() -> {
                try {
                    System.out.println("Task " + taskId + " waiting for permit...");
                    SEMAPHORE.acquire(); // blocks if no permit
                    System.out.println("Task " + taskId + " acquired permit. Running...");

                    // simulate DB/API work
                    Thread.sleep(2000);

                    System.out.println("Task " + taskId + " finished.");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    SEMAPHORE.release(); // MUST release
                    System.out.println("Task " + taskId + " released permit.");
                }
            });
        }
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);
    }
}

