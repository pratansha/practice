package sapient.candidate.questions;

import java.io.IOException;

public class Test {
    Test t;

    public Test() {
        t = new Test();
    }

    public static void main(String[] args) {

    }
}


class Parent extends RuntimeException{
    protected void mac1() throws Exception {

    }

}

class Child extends Parent {
    public void mac1() throws IOException {

    }
}

