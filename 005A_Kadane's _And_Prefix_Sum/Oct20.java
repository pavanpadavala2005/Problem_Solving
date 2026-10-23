import java.util.HashMap;

public class Oct20 {
    // ! ============= LC152. Maximum Product Subarray ============
    /*
    @ TC --> O(N)
    @ SC --> O(1)
    */
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProd = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;

        for (int i = 0; i < n; i++) {
            if (prefix == 0)
                prefix = 1;
            if (suffix == 0)
                suffix = 1;
            prefix *= nums[i];
            suffix *= nums[i];
            maxProd = Math.max(maxProd, Math.max(prefix, suffix));
        }
        return maxProd;
    }

    // ! ============= LC2461. Maximum Sum of Distinct Subarrays With Length K ============
    /*
    @ TC --> O(N)
    @ SC --> O(100001) --> it Might me more but TC of Access --> O(1)
    */
    public static long maximumSubarraySumOptimal(int[] nums, int k) {
        int[] map = new int[100001];
        long sum = 0;
        long maxVal = 0;
        int count = 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            int right = nums[j];
            sum += right;
            if (map[right] == 0)
                count++;
            map[right]++;

            if (j > k - 1) {
                int left = nums[i++];
                sum -= left;
                map[left]--;
                if (map[left] == 0)
                    count--;
            }
            if (count == k)
                maxVal = Math.max(maxVal, sum);
        }
        return maxVal;
    }

    /*
    @ TC --> O(N)
    @ SC --> O(N) --> but there is Some additional TC included for keeping and removing items form Map --> [ O(log N) to O(N) ]
    */
    public long maximumSubarraySumBetter(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        long maxVal = 0;
        int count = 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            if (!map.containsKey(nums[j]))
                count++;
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            if (j - i + 1 == k) {
                if (count == k)
                    maxVal = Math.max(maxVal, sum);
                sum -= nums[i];

                map.put(nums[i], map.get(nums[i]) - 1);

                if (map.get(nums[i]) <= 0) {
                    count--;
                    map.remove(nums[i]);
                }
                i++;
            }
        }

        return maxVal;
    }

}
// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC152. Maximum Product Subarray ✅
// 2.LC2461. Maximum Sum of Distinct Subarrays With Length K ✅