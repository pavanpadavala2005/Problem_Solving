
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
}
