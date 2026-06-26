package all.tech.practice.java21;


public class NestedRecordPatternExample {
    record Point(int x, int y) {
    }

    record Rectangle(NestedRecordPatternExample.Point leftTop, NestedRecordPatternExample.Point rightBottom) {
    }


    public static void main(String[] args) {
        Object rectangle = new Rectangle(new Point(0, 10), new Point(20, 0));
        if (rectangle instanceof Rectangle(NestedRecordPatternExample.Point(int x1, int y1), NestedRecordPatternExample.Point(int x2, int y2))) {
            System.out.println("TopLeft=(" + x1 + "," + y1 + ")");
            System.out.println("BottomRight=(" + x2 + "," + y2 + ")");
        }
    }
}
