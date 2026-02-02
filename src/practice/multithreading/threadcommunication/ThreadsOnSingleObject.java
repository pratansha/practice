package practice.multithreading.threadcommunication;

import java.util.List;

public class ThreadsOnSingleObject {
    public static void main(String[] args) {
        SharedResource1 resource1 = new SharedResource1();


    }
}

class SharedResource1 {
    List<Integer> list;

    public synchronized void produce() {
        for (int i = 0; i < 10; i++) list.add(i);
    }

    public synchronized void consume() {

    }
}