import java.util.HashMap;

public class June18 {
    public static int countSubArraysWithXor(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int count = 0;
        int prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix ^= nums[i];
            if (prefix == k)
                count++;
            int y = prefix ^ k;
            if (freq.containsKey(y)) {
                count += freq.get(y);
                freq.put(y, freq.get(y) + 1);
            } else {
                freq.put(y, 1);
            }
        }
        return count;
    }

    public static int countSubArraysSumK(int[] nums, int k) {
        HashMap<Integer, Integer> prev = new HashMap<>();
        prev.put(0, 1);
        int count = 0;
        int prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int req = prefix - k;
            if (prev.containsKey(req)) {
                count += prev.get(req);
                prev.put(req, prev.get(req) + 1);
            }
            if (!prev.containsKey(prefix)) {
                prev.put(prefix, 1);
            }
        }
        return count;
    }
}