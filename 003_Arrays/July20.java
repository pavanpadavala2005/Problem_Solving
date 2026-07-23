public class July20 {
    // ! =============== 209 MINIMUM SIZE SUB ARRAY SUM =============
    public static int minSumHelper(int[] nums, int target) {
        int sum = 0;
        int ln = Integer.MAX_VALUE;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum > target) {
                ln = Math.min(ln, i - j + 1);
                sum -= nums[j];
                j++;
            }
        }
        return ln;
    }

}
