
import java.util.*;

public class May31 {
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void sortColors(int[] nums) {
        // ! Better Approach --> O(2N)

        // int n = nums.length;
        // int[] freq = new int[3];
        // for (int i : nums)
        // freq[i]++;
        // int idx = 0;
        // for (int j = 0; j < 3; j++) {
        // while (freq[j] > 0) {
        // nums[idx] = j;
        // freq[j]--;
        // idx++;
        // }
        // }
        // System.out.println(Arrays.toString(nums));

        // ! Optimal Approach --> using Dutch National Flag algorithm
        // int low = 0;
        // int high = nums.length - 1;
        // int mid = 0;
        // while (mid <= high) {
        // if (nums[mid] == 0) {
        // swap(nums, mid, low);
        // mid++;
        // low++;
        // } else if (nums[mid] == 1)
        // mid++;
        // else {
        // swap(nums, mid, high);
        // high--;
        // }
        // }
        // System.out.println(Arrays.toString(nums));

        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            int pivot = nums[high];
            if (nums[mid] < pivot) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == pivot)
                mid++;
            else {
                swap(nums, mid, high);
                high--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static int majorityElement(int[] nums) {
        // ! Brute --> Using two for Loops and Searching for ELement and count and
        // ! maintaining a max variable
        // @ TC --> O(N2)
        // @ SC --> O(1)

        // int elem = -1;
        // int n = nums.length;
        // for (int i = 0; i < n; i++) {
        // int ctr = 0;
        // for (int j = 0; j < n; j++)
        // if (nums[i] == nums[j])
        // ctr++;
        // if (ctr > n / 2)
        // elem = nums[i];
        // }
        // return elem;

        // ! Better Approach --> Using a HashTable and count
        // @ TC --> O(2N) --> 2 conseq for loops
        // @ SC --> O(N) --> Worst case scenario(All elements are Unique)
        // HashMap<Integer, Integer> freq = new HashMap<>();
        // for (int i : nums)
        // freq.put(i, freq.getOrDefault(i, 0) + 1);
        // System.out.println(freq);
        // for (int i : freq.keySet())
        // if (freq.get(i) > (nums.length / 2))
        // return i;
        // return -1;

        // ! Optimal Approach --> using Moore majority vote algorithm
        // @ Pass - 1 finding Element
        // @ Pass - 2 Checking Correct Element or NOt
        int elem = -1;
        int ctr = 0;
        for (int i : nums) {
            if (ctr == 0)
                elem = i;
            ctr += (elem == i) ? 1 : -1;
        }
        for (int i : nums) {
            if (ctr == 0)
                elem = i;
            ctr += (elem == i) ? 1 : -1;
        }
        return elem;
    }

    public static List<Integer> majorityElement2(int[] nums) {
        // ! Better Approach --> Using Frequency
        // @ This can be optimized
        ArrayList<Integer> res = new ArrayList<>();
        LinkedHashMap<Integer, Integer> freq = new LinkedHashMap<>();
        for (int i : nums)
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        for (int i : freq.keySet())
            if (freq.get(i) > nums.length / 3)
                res.add(i);
        return res;

        // ! Optimal Approach is Using Voting Algorithm

    }

    public static boolean majorityElementSortedArray(int[] nums) {
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[left])
                left++;
            if (right - left + 1 > (nums.length / 2))
                return true;
        }
        return false;
    }

    public static int returnVal(int a, int b) {
        int x = 10;
        int y = 11;
        return (a > b) ? x : (b > a ? y : (x > y ? y : x));
    }

    public static int maxSumOfSubArray(int[] nums) {
        // ! Very Brute force -->O(N2)
        // int maxSum = Integer.MIN_VALUE;
        // for (int i = 0; i < nums.length; i++) {
        // int sum = 0;
        // for (int j = i; j < nums.length; j++) {
        // sum += nums[j];
        // maxSum = Math.max(sum, maxSum);
        // }
        // }
        // return maxSum;

        // ! Optimal Approach using Kadane's Algorith
        // @ Best Time complexity -->O(N)
        int maxSum = Integer.MIN_VALUE;
        int runSum = 0;
        int idx = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            runSum += nums[i];
            if (runSum > maxSum) {
                maxSum = runSum;
                maxLen = Math.max(maxLen, i - idx + 1);
                idx = i;
            }
            if (runSum < 0)
                runSum = 0;
        }
        return maxSum;
    }
}
