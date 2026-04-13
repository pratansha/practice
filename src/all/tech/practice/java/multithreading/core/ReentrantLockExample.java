package all.tech.practice.java.multithreading.core;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Runnable task = () -> {
            boolean isLocked ;
            try {
                isLocked = lock.tryLock(1000, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (isLocked) {
                try {

                    System.out.println(Thread.currentThread().getName() + " acquired lock");
                    reentrantMethod();
                } finally {
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName() + " released lock");
                }
            }
        };
        new Thread(task, "Thread-1").start();
        new Thread(task, "Thread-2").start();
    }

    static void reentrantMethod() {
        lock.tryLock();  // same thread re-acquires lock
        try {
            System.out.println(Thread.currentThread().getName() + " re-entered lock");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
