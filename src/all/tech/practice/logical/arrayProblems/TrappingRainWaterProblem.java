package all.tech.practice.logical.arrayProblems;

public class TrappingRainWaterProblem {
    public static void main(String[] args) {
        int[] arr = {4, 2, 0, 3, 2, 5};   //expected = 9
        System.out.println(trap(arr));
        System.out.println(trap(4, 2, 9, 6, 8, 5, 2, 8, 6));  //expected = 13
    }

    public static int trap1(int... height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }

    // More cleaner version of above to understand code...
    public static int trap(int... height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, water = 0;

        // 4, 2, 9, 6, 8, 5, 2, 8, 6
        while (left < right) {
            if (height[left] <= height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }

    public static int waterTrapping(int... height) {
        // 4, 2, 9, 6, 8, 5, 2, 8, 6
        int left = 0;
        int right = height.length - 1;
        int waterSum = 0;
        int leftMax = 0;
        int rightMax = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                waterSum = waterSum + leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                waterSum = waterSum + rightMax - height[right];
                right--;
            }
        }
        return waterSum;
    }

}
