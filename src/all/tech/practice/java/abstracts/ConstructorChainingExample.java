package all.tech.practice.java.abstracts;

public class ConstructorChainingExample {
    static class A {
        public A() {
            System.out.println();
        }
    }

    public static class B extends A {
        public B(String name) {
            System.out.println(name);
        }

        public static void main(String[] args) {
            B b = new B("X");
        }
    }
}
