package scenario.java.questions;

public class CloenableTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        ShallowClass shallowObject = new ShallowClass();
        System.out.println(shallowObject);
        System.out.println("********** After Cloning **********");
        ShallowClass testClone1 = (ShallowClass) shallowObject.clone();
        System.out.println(testClone1);
        testClone1.i=110;
        System.out.println("After changing the value of i in cloned object");
        System.out.println(shallowObject);
        System.out.println(testClone1);

        // Example of Deep Cloning
        DeepClass deepObject = new DeepClass(10L, 20L, "TestClone");
        System.out.println(deepObject);
        System.out.println("********** After Deep Cloning **********");
        DeepClass deepClone = (DeepClass) deepObject.clone();
        System.out.println(deepClone);
        deepClone.i=120L;
        System.out.println("After changing the value of i in deep cloned object");
        System.out.println(deepObject);
        System.out.println(deepClone);

    }
}

class ShallowClass implements Cloneable {
    int i = 10;
    int j = 20;
    String name = "TestClone";

    @Override
    public Object clone() throws CloneNotSupportedException {
        //return this.clone();// this will get stackoverflow exception.
        return super.clone(); // this will work fine. // jvm will create a new object and copy all the values.(shallow)
    }

    @Override
    public String toString() {
        return "ShallowClass [i=" + i + ", j=" + j + ", name=" + name + "]";
    }
}

class DeepClass implements Cloneable {
    Long i;
    Long j;
    String name;

    public DeepClass(Long i, Long j, String name) {
        this.i = i;
        this.j = j;
        this.name = name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        DeepClass deep = (DeepClass) super.clone();
        deep.i = new Long(this.i);
        deep.j = new Long(this.j);
        deep.name = new String(this.name);
        return deep;
    }

    @Override
    public String toString() {
        return "DeepClass [i=" + i + ", j=" + j + ", name=" + name + "]";
    }
}