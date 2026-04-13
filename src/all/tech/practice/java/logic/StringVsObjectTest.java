package all.tech.practice.java.logic;

public class StringVsObjectTest {
    static class Test1 {
        public void test(Object str) {
            System.out.println("I am object test " + str);
        }
    }

    static class Test2 extends Test1 {
        public void test(String str) {
            System.out.println("I am string test " + str);
        }

        public void test(Object str) {
            System.out.println("I am overridden string test " + str);
        }
    }

    public static void main(String[] args) {
        String s = "hello";
        Test2 ob = new Test2();
        ob.test(s);
    }
}