package all.tech.practice.java.multithreading.core;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueDemo {

    public static void main(String[] args) throws Exception {
        int capacity = 5;
        boolean fair = true; // try false to see different behavior under contention
        // If fair is false , It means any Thread waiting for long will not get priority.(random)
        // So Older Thread will be starvation to get occupy.
        // If fair is true , Longer waiting thread will get first access.
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(capacity, fair);

        System.out.println("=== ArrayBlockingQueue Demo ===");
        System.out.println("Capacity: " + capacity + ", fair=" + fair);

        // Start producers/consumers to demonstrate blocking semantics
        startProducersAndConsumers(queue);

        // Let them run a bit
        Thread.sleep(3000);

        // Showcase key methods on a fresh queue for deterministic output
        methodsShowcase();

        System.out.println("\nDemo complete.");
    }

    // ------------------- Producer / Consumer demo -------------------
    static void startProducersAndConsumers(ArrayBlockingQueue<String> queue) {
        // Producer that uses put() (blocks when full)
        Runnable blockingProducer = () -> {
            for (int i = 0; i < 10; i++) {
                String item = "P:" + Thread.currentThread().getName() + "-" + i;
                try {
                    queue.put(item); // blocks if queue is full
                    System.out.println(ts() + " [producer-put] queued " + item +
                            " | size=" + queue.size() + " remainingCapacity=" + queue.remainingCapacity());
                    Thread.sleep(150); // simulate production rate
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        };

        // Producer that uses offer(timeout) (bounded wait)
        Runnable timeoutProducer = () -> {
            for (int i = 0; i < 10; i++) {
                String item = "TP:" + Thread.currentThread().getName() + "-" + i;
                try {
                    boolean ok = queue.offer(item, 200, TimeUnit.MILLISECONDS); // bounded wait if full
                    System.out.println(ts() + " [producer-offer] enqueue " + item + " -> " + ok +
                            " | size=" + queue.size());
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        };

        // Consumer that uses take() (blocks when empty)
        Runnable blockingConsumer = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    String item = queue.take(); // blocks if empty
                    System.out.println(ts() + " [consumer-take] got " + item +
                            " | size=" + queue.size() + " remainingCapacity=" + queue.remainingCapacity());
                    Thread.sleep(250); // simulate processing
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        };

        // Consumer that uses poll(timeout) (bounded wait)
        Runnable timeoutConsumer = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    String item = queue.poll(300, TimeUnit.MILLISECONDS); // waits up to 300ms
                    System.out.println(ts() + " [consumer-poll] got=" + item);
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        };

        // Launch a couple of producers and consumers
        new Thread(blockingProducer, "BP-1").start();
        new Thread(timeoutProducer, "TP-1").start();
        new Thread(blockingConsumer, "BC-1").start();
        new Thread(timeoutConsumer, "TC-1").start();
    }

    // ------------------- Methods showcase on a fresh queue -------------------
    static void methodsShowcase() throws InterruptedException {
        System.out.println("\n=== Methods Showcase ===");
        ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<>(3, true);

        // add() throws IllegalStateException if full
        System.out.println("add(1) -> " + q.add(1));
        System.out.println("add(2) -> " + q.add(2));

        // offer() returns false if full, true otherwise
        System.out.println("offer(3) -> " + q.offer(3));
        System.out.println("offer(4) when full -> " + q.offer(4));

        // offer with timeout waits for space (bounded)
        System.out.println("offer(5, 200ms) when full -> " + q.offer(5, 200, TimeUnit.MILLISECONDS));

        // peek() returns head without removing; element() throws if empty
        System.out.println("peek() -> " + q.peek());
        System.out.println("element() -> " + q.element()); // throws NoSuchElementException if empty

        // remove() removes head; remove(Object) removes first match
        System.out.println("remove() -> " + q.remove());
        System.out.println("remove(Object=99) -> " + q.remove(Integer.valueOf(99)));
        System.out.println("contains(2) -> " + q.contains(2));
        System.out.println("size() -> " + q.size() + ", remainingCapacity() -> " + q.remainingCapacity());

        // put() blocks if full; take() blocks if empty
        q.put(42); // will succeed (capacity was freed by remove())
        System.out.println("put(42); size=" + q.size());

        System.out.println("take() -> " + q.take()); // removes head, blocks if empty

        // poll() returns null if empty
        System.out.println("poll() -> " + q.poll());

        // drainTo(Collection) moves all elements atomically and efficiently
        q.add(7); q.add(8); q.add(9);
        List<Integer> sink = new ArrayList<>();
        int drained = q.drainTo(sink);
        System.out.println("drainTo(list) drained=" + drained + ", sink=" + sink + ", size=" + q.size());

        // clear() empties the queue
        q.add(10); q.add(11);
        System.out.println("before clear: size=" + q.size());
        q.clear();
        System.out.println("after clear:  size=" + q.size() + ", isEmpty=" + q.isEmpty());

        // iterator() snapshot (weakly consistent)
        q.offer(21); q.offer(22);
        System.out.print("iterator() -> ");
        for (Integer x : q) System.out.print(x + " ");
        System.out.println();
    }

    static String ts() {
        return String.format("%1$tT.%1$tL", System.currentTimeMillis());
    }
}
