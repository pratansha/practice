package all.tech.practice.java21;


public class Test {
    public static void main(String[] args) {
        Thread r = Thread.startVirtualThread(() -> {
            System.out.println("Running on virtual thread");
        });
    }
}