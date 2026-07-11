import java.util.HashMap;

public class June01 {

    public static int[] minSumSubArray(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        // for (int i = 0; i < nums.length; i++) {
        // int sum = 0;
        // for (int j = i; j < nums.length; j++) {
        // sum += nums[j];
        // minSum = Math.min(sum, minSum);
        // }
        // }
        // return minSum;
        int runSum = 0;
        int lastIdx = 0;
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            runSum += nums[i];
            if (runSum < minSum) {
                minSum = runSum;
                len = Math.max(len, i - lastIdx + 1);
                lastIdx = i;
            }
            if (runSum > 0) {
                runSum = 0;
            }
        }
        return new int[] { len, minSum };
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int runSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runSum += nums[i];
            maxSum = Math.max(runSum, maxSum);
            runSum = Math.max(runSum, 0);
        }
        maxSum = Math.max(runSum, maxSum);
        return maxSum;
    }
    // User function Template for Java

    class Solution {
        public int longestSubarray(int[] nums, int k) {
            // code here
            int n = nums.length, currSum = 0, maxLen = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, -1); // Ensures -ve numbers also
            for (int i = 0; i < n; i++) {
                currSum += nums[i];
                int rem = currSum - k;
                if (map.containsKey(rem))
                    maxLen = Math.max(maxLen, i - map.get(rem));

                if (!map.containsKey(currSum))
                    map.put(currSum, i);
            }
            return maxLen;
        }
    }

import java.util.*;

// Class containing the sliding window algorithm
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        // To store the maximum length of the subarray
        int maxLen = 0;
        // Pointers for sliding window
        int left = 0, right = 0;
        // Sum of the current window
        int sum = nums[0];
        // Traverse through the array
        while (right < n) {
            // Shrink the window if sum exceeds k
            while (left <= right && sum > k) {
                sum -= nums[left];
                left++;
            }
            // Update max length if sum equals k
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            // Expand the window to the right
            right++;
            if (right < n) {
                sum += nums[right];
            }
        }
        return maxLen;
    }
}
