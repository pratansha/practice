package multithreading.core;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        Runnable task = () -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " acquired lock");

                reentrantMethod();

            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " released lock");
            }
        };

        new Thread(task, "Thread-1").start();
        new Thread(task, "Thread-2").start();


    }

    static void reentrantMethod() {
        lock.lock();  // same thread re-acquires lock
        try {
            System.out.println(Thread.currentThread().getName() + " re-entered lock");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
