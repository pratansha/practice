package multithreading.core;

import java.util.LinkedHashMap;
import java.util.Queue;
import java.util.concurrent.*;

public class CallableThreadCreation {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> task = () -> {
            Thread.sleep(2000);
            return "A return task of String type";
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        System.out.println("started..............");
        Future<String> future = executorService.submit(task);
        boolean result = future.isDone();
        System.out.println(result);
        System.out.println(future.get());
        executorService.shutdown();

        //ThreadPoolExecutor tgThreadPoolExecutor =   new ThreadPoolExecutor(executorService
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(30);
        queue.put(() -> System.out.println("I am executing..........."));

        new Thread(queue.take()).start();

        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();


    }
}

class CallableThread<S> implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "hello I have done this...";
    }
}
