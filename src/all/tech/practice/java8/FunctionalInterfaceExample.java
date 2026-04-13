package all.tech.practice.java8;

public class FunctionalInterfaceExample {
    @FunctionalInterface
    public interface AddFunctionalInterface {
        int add(int i);

        default int add(int a, int b) {
            return a + b;
        }

        default int minus(int a, int b) {
            return a - b;
        }

        static int add(int a, int b, int c) {
            return a + b + c;
        }

        static int minus(int a, int b, int c) {
            return a - b - c;
        }
    }

    public static void main(String[] args) {
        AddFunctionalInterface afi1 = i -> 4 + i;   // adds 4
        AddFunctionalInterface afi2 = i -> 6 + i;   // adds 6

        System.out.println(afi1.add(10)); // 14
        System.out.println(afi2.add(10)); // 16

        // Default methods can be called on the instance
        System.out.println(afi1.add(9, 6));    // 15
        System.out.println(afi1.minus(9, 6));  // 3

        // Static methods must be called on the interface
        System.out.println(AddFunctionalInterface.add(9, 6, 5));   // 20
        System.out.println(AddFunctionalInterface.minus(9, 6, 5)); // -2
    }
}
