package all.tech.practice.logical.bitwise;

public class BitwiseRightShifting {
    public static void main(String[] args) {
        int x = 10;  //  00001010
        System.out.println(x); //  0000 1010  = 10
        System.out.println(x >> 1);  // 0000 0101  =5
        System.out.println(x >> 2);  // 0000 0010  =2
        System.out.println(x >> 3);  // 0000 0001  =1
        System.out.println(x >> 4);  // 0000 0000  =0
        System.out.println(x >> 7);  // 0000 0000  =0

        System.out.println("=============");
        System.out.println(10 & (10-1));

    }
}
