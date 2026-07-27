public class July27 {
    // ! =========== SINGLE NUMBER II ===========
    public static int singleNumberII(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & (1 << i)) != 0)
                    count++;
            }
            if (count % 3 != 0)
                ans |= (1 << i);
        }
        return ans;
    }
}