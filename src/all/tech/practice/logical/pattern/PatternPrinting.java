package all.tech.practice.logical.pattern;

/* Print this in this fashion...
"   * * * * * * *
      * * * * *
        * * *
          *        "
 */
public class PatternPrinting {
    public static void main(String[] args) {
        printNumberOfStarsByGivingInput(7);
        System.out.println("=========================");
        printNumberOfStarsByGivingInput(11);
        System.out.println("=========================");
        printNumberOfStarsByGivingInput(10);
        System.out.println("=========================");
        printNumberOfStarsByGivingInput(5);
        System.out.println("=========================");

    }

    private static void printNumberOfStarsByGivingInput(int n) {
        /* Print this in this fashion...
        "   * * * * * * *
              * * * * *
                * * *
                  *        "
 */
        int height = (n / 2) + 1;
        for (int i = 0; i < height; i++) {
            int k = i;
            while (0 < k) {
                System.out.print(" ");
                k--;
            }

            for (int j = i; j < n - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
