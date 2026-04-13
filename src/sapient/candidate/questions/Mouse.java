package sapient.candidate.questions;

public class Mouse {

    public static int ctr = 0;
    public Mouse() { ctr++; }

    public static void main(String[] args)
    {
        Mouse mouse1 = new Mouse();
        Mouse mouse2 = new Mouse();
        Mouse mouse3 = new Mouse();
        System.out.println("Mouse number " + mouse2.ctr);
    }
}