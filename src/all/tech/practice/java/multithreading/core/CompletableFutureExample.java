package all.tech.practice.java.multithreading.core;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
CompletableFuture is for async backend orchestration, not frontend waiting.
thenAccept is mainly used for non‑blocking continuations and side‑effects after async completion.
Four things here :
==================
    thenAccept use to register the callback.
    thenSupply() vs thenCompose() Vs thenCombine difference ?

 */
public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Main thread started....");
        //Example 1: Basic async task
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello";
        });
        System.out.println("Main thread continues...");
        System.out.println(future.get()); // This should avoid otherwise main thread will be block, get() is a blocking call.
        future.thenAccept(System.out::println); // This is registration of callback when task will complete then this line will print. It is not blocking.
        System.out.println("final result");

        // Example 2: Chaining operations (thenApply) - No blocking.
        CompletableFuture<String> future2 =
                CompletableFuture.supplyAsync(() -> "java")
                        .thenApply(String::toUpperCase) // Get output from first then call this.
                        .thenApply(str -> "Result: " + str); // Get output from 2nd then call this.

        future2.thenAccept(System.out::println);

        // Example 3: Async + async dependency (thenCompose) => Flattens CompletableFuture<CompletableFuture<T>>
        CompletableFuture<String> userFuture = CompletableFuture.supplyAsync(() -> "user123");
        CompletableFuture<String> profileFuture = userFuture.thenCompose(user -> // then compose dependent upon previous result.
                CompletableFuture.supplyAsync(() -> "Profile of " + user)
        );
        profileFuture.thenAccept(System.out::println);

        // Example 4: Run tasks in parallel and combine results - Both Run on Parallel , combined once both will complete.
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> 20);
        CompletableFuture<Integer> combined = f1.thenCombine(f2, (resultFromFirst, resultFromSecond) -> resultFromFirst - resultFromSecond);
        combined.thenAccept(System.out::println); // -10

        // Example 5: Error handling (very important)
        CompletableFuture<Integer> exceptionFuture =
                CompletableFuture.supplyAsync(() -> {
                    if (true) throw new RuntimeException("Error!");
                    return 10;
                }).exceptionally(ex -> {
                    System.out.println("Error occurred: " + ex.getMessage());
                    return 0;
                });
        exceptionFuture.thenAccept(System.out::println);

        // Example 6: Chaining operations (thenApply) - No blocking.
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> System.out.println("hello run async , I am Runnable., I can not accept callable."));
        completableFuture.thenAccept(System.out::println);

        // We can override by providing our own executor by default it takes - ForkJoinPool.commonPool() executor pool.
        ExecutorService pool = Executors.newFixedThreadPool(10);
        // 1. CustomPool with RunAsync example :
        CompletableFuture<Void> completableFutureWithCustomPool = CompletableFuture.runAsync(() -> System.out.println("hello run async , I am Runnable., I can not accept callable."), pool);
        completableFutureWithCustomPool.thenAccept(System.out::println);
        // 2. CustomPool with SupplyAsync example :
        CompletableFuture<String> profileFutureWithCustomPool = userFuture.thenCompose(user ->
                CompletableFuture.supplyAsync(() -> "Profile of " + user, pool)
        );
        profileFutureWithCustomPool.thenAccept(System.out::println);
        pool.shutdown();
    }
}