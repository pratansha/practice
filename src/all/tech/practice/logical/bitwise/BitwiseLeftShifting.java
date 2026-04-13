package all.tech.practice.logical.bitwise;

public class BitwiseLeftShifting {
    public static void main(String[] args) {
        int x = 10;  //  00001010
        System.out.println(x); //  0000 1010
        System.out.println(x << 1);  // 0001 0100  =20
        System.out.println(x << 2);  // 0010 1000  =40
        System.out.println(x << 3);  // 0101 0000  =80
        System.out.println(x << 7);  // 0000 0101 0000 0000 =   1024+256 = 1280
        System.out.println(2 << 29); // 1073741824 i.e. maximum 2^32 is allowed only.
    }
}
