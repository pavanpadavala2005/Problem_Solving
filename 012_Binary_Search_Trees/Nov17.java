import java.util.*;

public class Nov17 {
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int minVal = Integer.MAX_VALUE;

            int closeSum = nums[0] + nums[1] + nums[2];
            for (int i = 0; i < nums.length - 2; i++) {
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    int currSum = nums[i] + nums[j] + nums[k];

                    if (Math.abs(currSum - target) < Math.abs(closeSum - target))
                        closeSum = currSum;

                    if (currSum < target)
                        j++;

                    else if (currSum > target)
                        k--;

                    else
                        return closeSum;
                }
            }
            return closeSum;
        }
    }
}
