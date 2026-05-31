
import java.util.*;

public class May30 {

    // https://www.naukri.com/code360/problems/longest-subarray-with-sum-k_6682399?leftPanelTabValue=PROBLEM
    public static int longestSubArraySumKPositives(int[] nums, int k) {
        // @ When we have +ves and -ves the Hashmap Method will Work Well

        // ! When our Array is only Having +ve's then The Sliding window Will Work
        int n = nums.length;
        int runSum = 0;
        int maxLen = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            runSum += nums[right];
            while (left <= right && runSum > k) {
                runSum -= nums[left];
                left++;
            }
            if (runSum == k)
                maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    // https://leetcode.com/problems/two-sum/description/
    public static int[] twoSum(int[] nums, int target) {
        // ! BruteForce --> Checking Every Pair --> O(N2)
        // int n = nums.length;
        // for (int i = 0; i < n; i++)
        // for (int j = 0; j < n; j++)
        // if (nums[i] + nums[j] == target)
        // return new int[] { i, j };
        // return new int[] { -1, -1 };

        // ! Better Solution --> Using Prefix but storing how much Required
        // ! [ target-nums[i] ] stored at each index position i
        // int n = nums.length;
        // int[] needArr = new int[n];
        // for (int i = 0; i < n; i++) {
        // int need = target - nums[i];
        // for (int j = i; j >= 0; j--)
        // if (needArr[j] == nums[i])
        // return new int[] { j, i };
        // needArr[i] = need;
        // }
        // return new int[] { -1, -1 };

        // ! Optimal Approach --> using HashMap
        // ! But here TC --> inserting into Hashmap ordered --> O(N log N) , unordered
        // ! --> O(N) or O(N2) sometimes
        // @ SC --> we are using Hashmap in worst case O(N) all elements
        int n = nums.length;
        HashMap<Integer, Integer> req = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (req.containsKey(nums[i]))
                return new int[] { req.get(nums[i]), i };
            req.put(target - nums[i], i);
        }
        return new int[] { -1, -1 };
    }

    // public static ArrayList<Pair<Integer>> twoSumPairs(ArrayList<Integer> nums,
    // int target) {
    // ArrayList<Pair<Integer>> res = new ArrayList<>();
    // HashMap<Integer, Integer> req = new HashMap<>();
    // int n = nums.size();
    // for (int i = 0; i < n; i++) {
    // if (req.containsKey(nums.get(i))) {
    // if (req.get(nums.get(i)) != i) {
    // System.out.println("Yes");
    // }
    // }
    // }
    // return res;
    // }

    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();
        HashMap<Integer, Integer> req = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int need = 0 - arr[i];
            if (req.containsKey(need))
                pairs.add(new ArrayList<>(List.of(arr[req.get(need)], arr[i])));
            else
                req.put(arr[i], i);
        }
        return pairs;
    }

    // public static int numIdenticalPairs(int[] nums) {
    // HashMap<Integer, ArrayList<Integer>> freq = new HashMap<>();
    // int ctr = 0;
    // for (int i = 0; i < nums.length; i++) {
    // if (freq.containsKey(nums[i]))
    // ctr += freq.get(nums[i]).size();
    // else {
    // ArrayList<Integer> resArr = freq.getOrDefault(i, new ArrayList<>());
    // resArr.add(i);
    // System.out.println(resArr);
    // freq.put(nums[i], resArr);
    // }
    // }
    // System.out.println(freq);
    // return ctr;
    // }

    public static int numIdenticalPairs(int[] nums) {
        int count = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (freq.containsKey(nums[i])) {
                count += freq.get(nums[i]);
                freq.put(nums[i], freq.getOrDefault(nums[i], 1) + 1);
            } else
                freq.put(nums[i], 1);
        }
        return count;
    }

}
