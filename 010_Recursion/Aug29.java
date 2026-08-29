
import java.util.*;

public class Aug29 {
    // ! =============== Combination SumII ================
    public static void combinationSumII(int[] nums, int target) {
        Arrays.sort(nums);
        combinationSumII(nums, 0, target, new ArrayList<>());
    }

    public static void combinationSumII(int[] nums, int i, int target, ArrayList<Integer> res) {
        if (target == 0) {
            System.out.println(res);
            return;
        }
        if (i >= nums.length || target < 0)
            return;
        for (int idx = i; idx < nums.length; idx++) {
            if (idx > i && nums[idx - 1] == nums[idx])
                continue;
            res.add(nums[idx]);
            combinationSumII(nums, idx + 1, target - nums[idx], res);
            res.remove(res.size() - 1);
        }
    }

    // ! =============== Combination SumI ================
    public static List<List<Integer>> combinationSumI(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSumI(nums, 0, target, new ArrayList<Integer>(), res);
        return res;
    }

    public static void combinationSumI(int[] nums, int i, int target,
            ArrayList<Integer> elems,
            List<List<Integer>> res) {
        if (i == nums.length) {
            if (target == 0)
                System.out.println(elems);
            return;
        }
        elems.add(nums[i]);
        combinationSumI(nums, i + 1, target - nums[i], elems, res);
        elems.remove(elems.size() - 1);
        combinationSumI(nums, i + 1, target, elems, res);
    }

    // ! =============== One subsequence sum equals K ================
    public static ArrayList<Integer> returnOneSubSequence(int[] nums, int i, ArrayList<Integer> res, int target) {
        if (target < 0) {
            return new ArrayList<>();
        }
        if (i >= nums.length) {
            if (target == 0)
                return res;
            return new ArrayList<>();
        }
        res.add(nums[i]);
        ArrayList<Integer> left = returnOneSubSequence(nums, i + 1, res, target - nums[i]);
        if (!left.isEmpty())
            return left;
        res.remove(res.size() - 1);
        ArrayList<Integer> right = returnOneSubSequence(nums, i + 1, res, target);
        if (!right.isEmpty())
            return right;
        return new ArrayList<>();
    }

    public static boolean printOneSubSequence(int[] nums, int i, ArrayList<Integer> res, int target) {
        if (target == 0) {
            System.out.println(res);
            return true;
        }
        if (i >= nums.length) {
            if (target == 0) {
                System.out.println(res);
                return true;
            }
            return false;
        }
        res.add(nums[i]);
        boolean left = printOneSubSequence(nums, i + 1, res, target - nums[i]);
        if (left)
            return true;
        res.remove(res.size() - 1);
        boolean right = printOneSubSequence(nums, i + 1, res, target);
        if (right)
            return true;
        return false;
    }

    // ! =============== subsequences sum equals K ================
    public static void subSequencesSumK(int[] nums, int i, ArrayList<Integer> res, int target) {
        if (i >= nums.length) {
            if (target == 0)
                System.out.println(res);
            return;
        }
        res.add(nums[i]);
        subSequencesSumK(nums, i + 1, res, target - nums[i]);
        res.remove(res.size() - 1);
        subSequencesSumK(nums, i + 1, res, target);
    }

    // ! =============== LC704. Binary Search ================
    public static int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public static int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end)
            return -1;
        int mid = start + (end - start) / 2;
        if (nums[mid] < target)
            return binarySearch(nums, mid + 1, end, target);
        else if (nums[mid] > target)
            return binarySearch(nums, start, mid - 1, target);
        return mid;
    }

}
// ! Target Min -> 3 , Max -> 5 (Quality Problems Only)
// 1. LC704. Binary Search ✅