package multithreading.core;

// 3 Threads prints number starting from 1 to 25 one by one
// Thread-1  will print => 1,4,7,10,13,16,19...
// Thread-2  will print => 2,5,8,11,14,17,20...
// Thread-3  will print => 3,6,9,12,15,18,21...
public class ThreeThreadNumberPrintInSequence {
    public static void main(String[] args) {
        NumberPrinter numberPrinter = new NumberPrinter();
        Runnable run1 = () -> {
            for (int i = 1; i < 10; i++) {
                try {
                    numberPrinter.print(1);  //  Thread number 1 print.
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable run2 = () -> {
            for (int i = 1; i < 10; i++) {
                try {
                    numberPrinter.print(2);   // Thread number 2 print.
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable run3 = () -> {
            for (int i = 1; i < 10; i++) {
                try {
                    numberPrinter.print(3);  // Thread number 3 print.
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        new Thread(run1, "Thread-1").start();
        new Thread(run2, "Thread-2").start();
        new Thread(run3, "Thread-3").start();

    }
}

class NumberPrinter {
    int pointer = 1;
    int turn = 1;

    public synchronized void print(int threadNumber) throws InterruptedException {
        while (turn != threadNumber) {
            this.wait();
        }
        System.out.println("printing :" + pointer + " by " + Thread.currentThread().getName());
        pointer++;
        turn = (turn % 3) + 1;
        this.notifyAll();
    }
}
