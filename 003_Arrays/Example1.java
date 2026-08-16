
public class Example1 {

    // ! =============== GFG. Largest Element in an Array ================
    public static int maxElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        // Brute Force: Sorting
        // Time Complexity: O(N log N)
        /*
         * Arrays.sort(nums);
         * return nums[nums.length - 1];
         */

        // Optimal: Linear Traversal
        // Time Complexity: O(N)
        // Space Complexity: O(1)
        int maxElement = nums[0];

        for (int i = 1; i < nums.length; i++)
            maxElement = Math.max(maxElement, nums[i]);

        return maxElement;
    }

    // ! =============== GFG. Second Largest Element in an Array ================
    public static int secondLargest(int[] nums) {
        if (nums == null || nums.length < 2)
            return -1;

        // Brute Force: Sorting
        // Time Complexity: O(N log N)
        /*
         * Arrays.sort(nums);
         * int largest = nums[nums.length - 1];
         * 
         * for (int i = nums.length - 2; i >= 0; i--) {
         * if (nums[i] != largest)
         * return nums[i];
         * }
         * 
         * return -1;
         */

        // Optimal: Single Traversal
        // Time Complexity: O(N)
        // Space Complexity: O(1)
        long largest = Long.MIN_VALUE;
        long secondLargest = Long.MIN_VALUE;

        for (int num : nums) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        return secondLargest == Long.MIN_VALUE ? -1 : (int) secondLargest;
    }

    // ! =============== GFG. Second Smallest Element in an Array ================
    public static int secondSmallest(int[] nums) {
        if (nums == null || nums.length < 2)
            return -1;

        // Optimal: Single Traversal
        // Time Complexity: O(N)
        // Space Complexity: O(1)
        long smallest = Long.MAX_VALUE;
        long secondSmallest = Long.MAX_VALUE;

        for (int num : nums) {
            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num < secondSmallest && num != smallest) {
                secondSmallest = num;
            }
        }

        return secondSmallest == Long.MAX_VALUE ? -1 : (int) secondSmallest;
    }

    // ! =============== GFG. Check if an Array Is Sorted ================
    public static boolean isSorted(int[] nums) {
        if (nums == null)
            return false;

        // Time Complexity: O(N)
        // Space Complexity: O(1)
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                return false;
        }

        return true;
    }

    // ! =============== LC 26. Remove Duplicates from Sorted Array ================
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        // Brute Force: LinkedHashSet
        // Time Complexity: O(N)
        // Space Complexity: O(N)

        // Optimal: Two Pointers
        // Time Complexity: O(N)
        // Space Complexity: O(1)
        int uniqueIndex = 0;

        for (int currentIndex = 1; currentIndex < nums.length; currentIndex++) {
            if (nums[uniqueIndex] != nums[currentIndex])
                nums[++uniqueIndex] = nums[currentIndex];
        }

        return uniqueIndex + 1;
    }

    // ! =============== GFG. Left Rotate an Array by One Position ================
    public static int[] leftRotateOne(int[] nums) {
        if (nums == null || nums.length <= 1)
            return nums;

        // Time Complexity: O(N)
        // Space Complexity: O(1)
        int firstElement = nums[0];

        for (int i = 1; i < nums.length; i++)
            nums[i - 1] = nums[i];

        nums[nums.length - 1] = firstElement;
        return nums;
    }

    // ! =============== GFG. Left Rotate an Array by K Positions ================
    public static int[] leftRotateK(int[] nums, int k) {
        if (nums == null || nums.length <= 1)
            return nums;

        int n = nums.length;
        k = ((k % n) + n) % n;

        if (k == 0)
            return nums;

        // Reversal Algorithm
        // Time Complexity: O(N)
        // Space Complexity: O(1)
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        reverse(nums, 0, n - 1);

        return nums;
    }

    // ! =============== LC 189. Rotate Array ================
    public static int[] rightRotateK(int[] nums, int k) {
        if (nums == null || nums.length <= 1)
            return nums;

        int n = nums.length;
        k = ((k % n) + n) % n;

        if (k == 0)
            return nums;

        // Reversal Algorithm
        // Time Complexity: O(N)
        // Space Complexity: O(1)
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);

        return nums;
    }

    // ! =============== Helper Method: Reverse an Array Range ================
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    // ! =============== LC 283. Move Zeroes ================
    public static int[] moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1)
            return nums;

        // Optimal: Two Pointers
        // Time Complexity: O(N)
        // Space Complexity: O(1)
        int insertionIndex = 0;

        for (int num : nums) {
            if (num != 0)
                nums[insertionIndex++] = num;
        }

        while (insertionIndex < nums.length)
            nums[insertionIndex++] = 0;

        return nums;
    }
}