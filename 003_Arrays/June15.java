
import java.util.HashMap;

public class June15 {
    public static int longestSubArrayWithSumZero(int[] nums) {
        int longest = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == 0) {
                    longest = Math.max(longest, j - i + 1);
                }
            }
        }
        return longest;
    }

    public static int longestSubArrayWithSumZeroBetter(int[] nums, int target) {
        int longest = 0;
        int prefix = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            if (prefix == target)
                longest = i + 1;
            if (freq.containsKey(prefix))
                longest = Math.max(longest, i - freq.get(prefix));
            if (!freq.containsKey(prefix))
                freq.put(prefix, i);
        }
        return longest;
    }
}
