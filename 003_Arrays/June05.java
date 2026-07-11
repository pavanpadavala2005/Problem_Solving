
import java.util.HashMap;

public class June05 {
    public static int findNumbers(int[] nums) {
        // int count = 0;
        // for (int num : nums) {
        // int temp = num;
        // int ctr = 0;
        // while (temp > 0) {
        // temp &= (temp - 1);
        // ctr++;
        // }
        // if ((ctr & 1) == 0) {
        // count++;
        // System.out.println(num);
        // }
        // }
        // return count;

        // ! Using and Searching in the Range
        int count = 0;
        for (int i : nums)
            if ((i >= 10 && i < 100) || (i >= 1000 && i < 10000) || i >= 1000000)
                count++;
        return count;
    }

    public static int countKDifference(int[] nums, int k) {
        // ! Brute force Approach
        // int count = 0;
        // for (int i = 0; i < nums.length; i++)
        // for (int j = i + 1; j < nums.length; j++)
        // if (Math.abs(nums[i] - nums[j]) == k)
        // count++;
        // return count;

        // ! Better Approach
        HashMap<Integer, Integer> freq = new HashMap<>();
        int res = 0;
        for (int i : nums) {
            // int add = i + k;
            // int diff = i - k;
            // if (freq.containsKey(add)) {
            // res += freq.get(add);
            // freq.put(add, freq.get(add) + 1);
            // }
            // if (freq.containsKey(diff)) {
            // res += freq.get(diff);
            // freq.put(diff, freq.get(diff) + 1);
            // }
            // if (!freq.containsKey(i)) {
            // freq.put(i, 1);
            // } else {
            // freq.put(i, freq.get(i) + 1);
            // }

            res += freq.getOrDefault(i + k, 0);
            res += freq.getOrDefault(i - k, 0);
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        return res;
    }

    public static int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String s : operations) {
            // if (s.charAt(0) == '+' || s.charAt(2) == '+')
            // x++;
            // else
            // x--;
            x += (s.charAt(0) == '+' || s.charAt(2) == '+' ? 1 : -1);
        }
        return x;
    }

    public static int[] transformArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0)
                nums[i] = 0;
            else
                nums[i] = 1;
        }

        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != 1) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
        return nums;
    }
}
