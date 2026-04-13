package practice.thread;

public class MyThreadExample implements Runnable {
    public static void main(String[] args) {
        new Thread(new MyThreadExample()).start();
        new Thread(new MyThreadExample()).start();
        new Thread(new MyThreadExample()).start();
    }

    @Override
    public void run() {
        System.out.println("hello Prashant " + Thread.currentThread().getName() + " started.");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread now exited.");
    }
}
