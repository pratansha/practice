package practice;

public class ExceptionTest {
    public static void main(String[] args) throws Throwable {
        ExceptionTest ob = new SubClass();
        ob.show();
    }

    // Parent method declares a checked exception
    void show() throws NullPointerException {
    }

}

class SubClass extends ExceptionTest {
    @Override
    void show() throws NullPointerException {
    }
}