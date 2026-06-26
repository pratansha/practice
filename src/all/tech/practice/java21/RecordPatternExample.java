package all.tech.practice.java21;

public class RecordPatternExample {
    public static void main(String[] args) {
        Object obj = new Point(10, 20);

        // This is java21 record pattern syntax of writing..
        if (obj instanceof Point(int x, int y)) {
            System.out.println("x=" + x + ", y=" + y);
        }

        // Without record pattern (older style)
        Object obj2 = new Point(10, 20);
        if (obj2 instanceof Point p) {
            int x = p.x();
            int y = p.y();
            System.out.println("x=" + x + ", y=" + y);
        }
    }
}

