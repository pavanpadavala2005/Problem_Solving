public class July07 {
    public static int findMinInSortedArray(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[i] <= nums[j]) {
                return nums[i];
            }
            if (nums[i] <= nums[mid]) {
                min = Math.min(nums[i], min);
                i = mid + 1;
            } else if (nums[mid] <= nums[j]) {
                min = Math.min(nums[mid], min);
                j = mid - 1;
            }
        }
        return min;
    }
}