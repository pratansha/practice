package practice.multithreading.threadcommunication;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThreadCommunicationExample {
    public static void main(String[] args) {

        AtomicInteger ai = new AtomicInteger(1);
        Supplier<Integer> integerSupplier = ai::getAndIncrement;
        List<Integer> list = Stream.generate(integerSupplier).limit(10).collect(Collectors.toList());

        list.forEach(System.out::println);
        System.out.println("After Printing the Thread.....");
        MyThread1 thread1 = new MyThread1(list);
        new Thread(thread1).start();
        MyThread2 thread2 = new MyThread2(list);
        new Thread(thread2).start();
    }
}

class MyThread1 implements Runnable {
    private List<Integer> list;

    public MyThread1(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            list.wait();
            while (!list.isEmpty()) {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "---------" + list.get(0));
                list.remove(0);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class MyThread2 implements Runnable {
    private List<Integer> list;

    public MyThread2(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            while (!list.isEmpty()) {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + "---------" + list.get(0));
                list.remove(0);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}