
import java.util.*;

public class Example2 {
    public static int[] intersectionSorted(int[] nums1, int[] nums2) {
        // ! BruteForce
        int n1 = nums1.length, n2 = nums2.length;
        boolean[] taken = new boolean[n2];
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (nums1[i] == nums2[j] && !taken[j]) {
                    res.add(nums1[i]);
                    taken[j] = true;
                }
                if (nums2[j] > nums1[i])
                    break;
            }
        }
        int[] resArr = new int[res.size()];
        for (int idx = 0; idx < res.size(); idx++) {
            resArr[idx] = res.get(idx);
        }
        return resArr;
        // ! Optimal Approach
        // int i = 0, j = 0, n1 = nums1.length, n2 = nums2.length;
        // ArrayList<Integer> res = new ArrayList<>();
        // while (i < n1 && j < n2) {
        // if (nums1[i] < nums2[j])
        // i++;
        // else if (nums2[j] < nums1[i])
        // j++;
        // else {
        // if (res.size() <= 0 || res.get(res.size() - 1) != nums1[i]) {
        // res.add(nums1[i]);
        // }
        // i++;
        // j++;
        // }
        // }
        // int[] resArr = new int[res.size()];
        // for (int idx = 0; idx < res.size(); idx++) {
        // resArr[idx] = res.get(idx);
        // }
        // return resArr;
    }

    public static int findMissingNumber(int[] nums, int n) {
        // ! Brute Force --> Linear Search of Array
        // for (int i = 1; i <= n; i++) {
        // boolean flag = false;
        // for (int j = 0; j < nums.length; j++) {
        // if (nums[j] == i) {
        // flag = true;
        // break;
        // }
        // }
        // if (!flag) {
        // return i;
        // }
        // }
        // return -1;

        // ! Better --> Using hash Array

        // ! Best --> using XOR
        // ! 0^5 = 5
        // ! 5^5 = 0
        // @ res = (1^2^3^4^5) ^ (1^2^4^5^0) --> 3
        int res = 0;
        for (int i = 1; i <= n - 1; i++) {
            res ^= i;
            res ^= nums[i - 1];
        }
        return res ^ n;
    }

    public static int maxConsequtiveOnes(int[] nums) {
        // ! Brute force Approach --> Checking for Every start of 1's
        // int max = 0, n = nums.length;
        // for (int i = 0; i < n; i++) {
        // int ctr = 0;
        // for (int j = i; j < n; j++) {
        // if (nums[j] == 1)
        // ctr++;
        // else
        // break;
        // }
        // max = Math.max(max, ctr);
        // }
        // return max;

        // ! Optimal --> Tracking Max with a Counter
        int max = 0, ctr = 0;
        for (int i : nums) {
            if (i == 1)
                ctr++;
            else {
                max = Math.max(max, ctr);
                ctr = 0;
            }
        }
        max = Math.max(max, ctr);
        return max;
    }

    public static int numberAppearsOnce(int[] nums) {
        // ! Brute Force --> Checking and counting Every Element

        // int n = nums.length;
        // HashMap<Integer, Integer> freq = new HashMap<>();
        // for (int i : nums) {
        // if (freq.containsKey(i)) {
        // freq.put(i, freq.get(i) + 1);
        // } else {
        // freq.put(i, 0);
        // }
        // }
        // System.out.println(freq);
        // for (int key : freq.keySet()) {
        // if (freq.get(key) == 1) {
        // return key;
        // }
        // }
        // return -1;

        // ! Better Approach --> Using A HashMap to count frequency
        // int n = nums.length;
        // HashMap<Integer, Integer> freq = new HashMap<>();
        // for (int i : nums) {
        // freq.put(i, freq.getOrDefault(i, 0) + 1);
        // }
        // for (int item : freq.keySet()) {
        // if (freq.get(item) == 1)
        // return item;
        // }
        // return -1;

        // ! Another Approach Adding All
        // @ But Sorting O(N log N) + O(N) --> iterating

        Arrays.sort(nums);
        int sum = 0;
        boolean toggle = false;
        for (int i : nums) {
            if (toggle)
                sum += i;
            else
                sum -= i;
            toggle = !toggle;
        }
        return sum < 0 ? -sum : sum;

        // ! Optimal --> Using XOR Operator to get Element
    }

    public static long longestSubArraySumKPositives(int[] nums, int k) {
        // ! Brute Force --> Checking every Sub Array
        // int max = -1, n = nums.length;
        // for (int i = 0; i < n; i++) {
        // int sum = 0;
        // for (int j = i; j < n; j++) {
        // sum += nums[j];
        // if (sum == k) {
        // max = Math.max(max, (j - i) + 1);
        // }
        // if (sum > k)
        // break;
        // }
        // }
        // return max;

        // ! Better --> Using Prefix Sum Method
        // int n = nums.length;
        // int[] prefix = new int[n];
        // prefix[0] = nums[0];
        // for (int i = 1; i < n; i++) {
        // prefix[i] = nums[i] + prefix[i - 1];
        // }
        // int maxLen = 0;
        // for (int i = 0; i < n; i++) {
        // if (prefix[i] == k)
        // maxLen = i + 1;
        // int req = prefix[i] - k;
        // for (int j = i; j >= 0; j--) {
        // if (prefix[j] == req) {
        // maxLen = Math.max(maxLen, i - j);
        // }
        // }
        // }

        // return maxLen;

        // ! Optimal Approach --> using HashMap
        int n = nums.length;
        long currSum = 0, maxLen = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            currSum += nums[i];
            if (currSum == k)
                maxLen = i + 1;
            long rem = currSum - k;
            if (map.containsKey(rem))
                maxLen = Math.max(maxLen, i - map.get(rem));
            map.put(currSum, i);
        }
        return maxLen;
    }

    public static int longestSubArraySumKNegatives(int[] nums, int k) {

        // ! Better Approach --> It will take
        // @ for HashMap Avg Case --> O(log N) , Worst Case --> O(N2)
        // @ And we are taking more space also O(N) in the Worst case

        // int n = nums.length, currSum = 0, maxLen = 0;
        // HashMap<Integer, Integer> map = new HashMap<>();
        // map.put(0, -1); // Ensures -ve numbers also
        // for (int i = 0; i < n; i++) {
        // currSum += nums[i];
        // int rem = currSum - k;
        // if (map.containsKey(rem))
        // maxLen = Math.max(maxLen, i - map.get(rem));

        // if (!map.containsKey(currSum))
        // map.put(currSum, i);
        // }
        // return maxLen;

        // ! Optimal Approach --> using two pointers i and j
        int runSum = 0;
        int n = nums.length;
        int maxLen = 0;

        int left = 0;

        for (int right = 0; right < n; right++) {

            runSum += nums[right];

            while (left <= right && runSum > k) {
                runSum -= nums[left];
                left++;
            }

            if (runSum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            System.out.println(runSum + " " + maxLen);
        }

        return maxLen;
    }
}
