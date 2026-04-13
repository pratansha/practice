package multithreading.core;

import java.util.concurrent.*;

public class ProducerConsumerCommunication {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(5);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(new Producer(blockingQueue));
        executorService.execute(new Consumer(blockingQueue));

        executorService.shutdown();

        /*if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
            executorService.shutdown();
        }*/

    }
}

class Producer implements Runnable {
    BlockingQueue<Integer> blockingQueue;

    public Producer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 20; i++) {
                blockingQueue.put(i);
                System.out.println("inserted : " + i);
                Thread.sleep(500);
            }

            blockingQueue.put(-1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}

class Consumer implements Runnable {
    BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int v = blockingQueue.take();
                if (v == -1) {
                    break;
                }
                System.out.println("consumed : ===> " + v);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}