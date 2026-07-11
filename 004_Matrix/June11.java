public class June11 {
    public static int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum > k) {
                sum -= nums[left];
                left++;
            }
            if (sum == k) {
                System.out.println("Hi" + " " + sum);
                count++;
            }
        }
        return count;
    }
}