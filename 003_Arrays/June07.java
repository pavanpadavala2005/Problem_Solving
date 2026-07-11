
import java.util.HashSet;

public class June07 {
    private static boolean linearSearch(int[] nums, int elem) {
        for (int i : nums)
            if (i == elem)
                return true;
        return false;
    }

    public static int longestConsecutive(int[] nums) {
        // ! Brute Force Solution --> O(N2)
        // int longest = 1;
        // for (int i = 0; i < nums.length; i++) {
        // int elem = nums[i];
        // int ctr = 1;
        // while (linearSearch(nums, elem + 1) == true) {
        // ctr++;
        // elem++;
        // }
        // longest = Math.max(longest, ctr);
        // }
        // return longest;

        // ! Better Solution --> Using sorting and Linear Search
        // ! Sorting --> O(N log N) search O(N) --> O(N log N)+O(N)
        // Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        // int longest = 1;
        // int count = 1;
        // int prev = nums[0];
        // for (int i = 1; i < nums.length; i++) {
        // if (prev == nums[i])
        // continue;
        // else if (prev + 1 == nums[i]) {
        // count++;
        // prev = nums[i];
        // } else {
        // prev = nums[i];
        // count = 1;
        // }
        // longest = Math.max(longest, count);
        // }
        // return longest;

        // ! Optimal Solution --> Using an Unordered Set

        HashSet<Integer> set = new HashSet<>();
        for (int i : nums)
            set.add(i);

        int longest = 1;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int ctr = 1;
                int x = nums[i];
                while (set.contains(x)) {
                    ctr++;
                    x++;
                }
                longest = Math.max(longest, ctr);
            }
        }
        return longest;
    }
}