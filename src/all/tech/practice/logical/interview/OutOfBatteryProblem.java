package all.tech.practice.logical.interview;

/*
1. Your phone is out of battery, but you must use it for t more minutes.
2. You have multiple spare batteries. For battery i:
   a. It can run the phone for capacity[i] minutes when fully charged.
   b.After those capacity[i] minutes, it becomes depleted and needs recharge[i] minutes to become fully charged again.
3. You use batteries in the given order, and after one is fully depleted, you try the next one.
4. If the next battery is still recharging, you skip it and try the next, continuing cyclically.

The task line in the image says (paraphrased but faithful):
1. Return the number of fully depleted (“full”) batteries used during the t minutes.
2. If at any time it’s impossible to keep the phone running because all batteries are recharging, return -1.

Also shown in the note:
A solution with time complexity not worse than approximately O(t · number_of_batteries) is acceptable.
And the code template visible on the right indicates a signature like:*/

public class OutOfBatteryProblem {
    public static void main(String[] args) {
        countBatteries(8, new int[]{2, 5, 2}, new int[]{10, 1, 10});   // expected = 2
        countBatteries(7, new int[]{3, 4}, new int[]{10, 10});   // expected = 2
        countBatteries(6, new int[]{3, 4}, new int[]{10, 10});   // expected = 1
        countBatteries(5, new int[]{2, 2}, new int[]{10, 10});   // expected = -1
        countBatteries(8, new int[]{2, 5, 2}, new int[]{10, 1, 10});   // expected = 2
        countBatteries(6, new int[]{2}, new int[]{1});   // expected = -1
        countBatteries(0, new int[]{3, 3}, new int[]{10, 10});   // expected = 0
    }

    // This is not completed Solution(Incomplete).......!!
    private static void countBatteries(int t, int[] capacity, int[] recharge) {
        int[] nextAvailable = new int[capacity.length];
        int count = 0;
        int sum = 0;
        for (int i = 0; i < capacity.length; i++) {
            if (t > sum) {
                count++;
                sum = sum + capacity[i];
                nextAvailable[i] = sum + recharge[i];
            } else if (t < sum) {
                break;
            } else {
                count++;
                break;
            }
        }
        if (sum > t) {
            count--;
        }
        int i = 0;
        while (t > sum) {
            if (nextAvailable[i] <= t) {
                sum = sum + nextAvailable[i];
                count++;
            }
            i++;
        }

        if (t > sum) {
            count = -1;
        }
        System.out.println("Total used are : " + count);
    }

    // This is correct Solution.
    public static int solution(int t, int[] capacity, int[] recharge) {
        int n = capacity.length;
        if (t <= 0) return 0;
        if (n == 0) return -1;

        // When each battery becomes usable again
        long[] nextAvailable = new long[n];

        long time = 0;           // minutes elapsed
        int remaining = t;       // minutes still needed
        int idx = 0;             // next index to try
        int fullUsed = 0;        // number of fully depleted batteries

        while (remaining > 0) {
            // Find the next available battery in cyclic order
            int chosen = -1;
            for (int k = 0; k < n; k++) {
                int j = (idx + k) % n;
                if (time >= nextAvailable[j]) {
                    chosen = j;
                    break;
                }
            }

            // If none is available, phone cannot run continuously
            if (chosen == -1) return -1;

            idx = chosen;

            // If a battery has non-positive capacity, it can never help
            if (capacity[idx] <= 0) return -1;

            // Use this battery
            int use = Math.min(remaining, capacity[idx]);
            time += use;
            remaining -= use;

            // If fully depleted, count it and schedule recharge completion
            if (use == capacity[idx]) {
                fullUsed++;
                nextAvailable[idx] = time + recharge[idx];
                idx = (idx + 1) % n; // next try starts from next battery
            } else {
                // We finished the required time in the middle of this battery
                break;
            }
        }
        return fullUsed;
    }


}
