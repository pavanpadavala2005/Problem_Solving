import java.util.*;

public class Aug27 {
    // ! =============== LC40. Combination Sum II ================
    public static List<List<Integer>> combinationSum2Better(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(candidates);

        combinationSum2BetterHelperV1(
                candidates,
                0,
                target,
                new ArrayList<>(),
                res
        //
        );
        return new ArrayList<>(res);
    }

    public static void combinationSum2BetterHelperV1(
            int[] nums,
            int idx,
            int target,
            ArrayList<Integer> elems,
            Set<List<Integer>> res)
    //
    {
        if (target == 0) {
            res.add(new ArrayList<>(elems));
            return;
        }
        if (idx >= nums.length || nums[idx] > target)
            return;
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1])
                continue;
            if (nums[i] > target)
                break;
            elems.add(nums[i]);
            combinationSum2BetterHelperV1(nums, i + 1, target - nums[i], elems, res);
            elems.remove(elems.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum2Brute(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        combinationSum2BruteHelperV1(
                candidates,
                0,
                target,
                new ArrayList<>(),
                res
        //
        );
        return new ArrayList<>(res);
    }

    public static void combinationSum2BruteHelperV1(
            int[] nums,
            int i,
            int target,
            ArrayList<Integer> elems,
            Set<List<Integer>> res)
    //
    {
        if (target == 0) {
            List<Integer> resList = new ArrayList<>(elems);
            Collections.sort(resList);
            res.add(resList);
            return;
        }
        if (i >= nums.length)
            return;
        elems.add(nums[i]);
        combinationSum2BruteHelperV1(nums, i + 1, target - nums[i], elems, res);
        elems.remove(elems.size() - 1);
        combinationSum2BruteHelperV1(nums, i + 1, target, elems, res);
    }

    // ! =============== Print all Three Combinations ================
    public static void printCombo(int[] nums, int i, ArrayList<Integer> res) {
        if (i >= nums.length)
            return;
        if (res.size() == nums.length) {
            System.out.println(res);
            return;
        }
        res.add(nums[i]);
        printCombo(nums, i, res);
        res.remove(res.size() - 1);
        printCombo(nums, i + 1, res);
    }

    // ! =============== LC39. Combination Sum ================
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        recV3(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    // @ Submitted In Leetcode
    // @ O(2^t) * O(K) --> where t --> number of same recursion made by same element
    // @ where k--> size of pair copying and putting into res --> O(K)
    public static void recV3(int[] nums, int i, int sum, ArrayList<Integer> pair, List<List<Integer>> res) {
        if (sum == 0) {
            res.add(new ArrayList<>(pair)); // * Here we copying all elements in pair to create a new ArrayList -> O(K)
            return;
        }
        if (sum < 0 || i >= nums.length)
            return;
        pair.add(nums[i]);
        recV3(nums, i, sum - nums[i], pair, res);
        pair.remove(pair.size() - 1);
        recV3(nums, i + 1, sum, pair, res);
    }

    //
    // @ Which will return the result --> Functional Recursion and BackTracking
    public static List<ArrayList<Integer>> recV2(int[] nums, int i, int sum, ArrayList<Integer> res) {
        if (sum < 0)
            return new ArrayList<>();
        if (i >= nums.length) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            if (sum == 0)
                result.add(new ArrayList<>(res));
            return result;
        }
        res.add(nums[i]);
        List<ArrayList<Integer>> left = recV2(nums, i, sum - nums[i], res);
        res.remove(res.size() - 1);
        List<ArrayList<Integer>> right = recV2(nums, i + 1, sum, res);
        List<ArrayList<Integer>> output = new ArrayList<>();
        output.addAll(left);
        output.addAll(right);
        return output;
    }

    // @ Little Bit Optimized
    public static void rec(int[] nums, int i, int sum, ArrayList<Integer> res) {
        if (sum < 0)
            return;
        if (i >= nums.length) {
            if (sum == 0)
                System.out.println(res);
            return;
        }
        res.add(nums[i]);
        rec(nums, i, sum - nums[i], res);
        res.remove(res.size() - 1);
        rec(nums, i + 1, sum, res);
    }

    // @ This is the function which will print the Combination sum recursively -->
    // BruteForce
    // @ TC --> O()
    public static void combinationSumRecV1(int[] nums, int i, int sum, ArrayList<Integer> res) {
        if (i >= nums.length) {
            if (sum == 0)
                System.out.println(res);
            return;
        }
        if (sum - nums[i] < 0)
            return;
        if (sum == 0) {
            System.out.println(res);
            return;
        }
        res.add(nums[i]);
        combinationSumRecV1(nums, i, sum - nums[i], res);
        res.remove(res.size() - 1);
        combinationSumRecV1(nums, i + 1, sum, res);
    }
}

// Target Min -> 3 , Max -> 5 (Quality Problems Only)
// 1. GEN. Print all Three Combinations ✅
// 2. LC39. Combination Sum ✅