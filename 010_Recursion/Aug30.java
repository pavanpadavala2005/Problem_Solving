import java.util.*;

public class Aug30 {
    // ! ============== LC46. Permutations =============
    public static List<List<Integer>> permute(int[] nums) {
        // Set<List<Integer>> res = new HashSet<>();
        // int n = nums.length;
        // int[] newArr = new int[n * 2];
        // for (int i = 0; i < n; i++) {
        // newArr[i] = nums[i];
        // newArr[i + n] = nums[i];
        // }
        // permuteHelper(newArr, 0, new ArrayList<>(), res);
        // return new ArrayList<>(res);
        List<List<Integer>> res = new ArrayList<>();
        // permute(nums, new ArrayList<>(), res, new boolean[nums.length]);
        permuteOptimal(nums, 0, new ArrayList<>(), res);
        return res;
    }

    // @ TC --> ( O(N!) * O(N) ) + O(N * N!) --> in last only Executing
    // @ SC --> O(N!) + O(N) --> recursive Stack Space only
    public static void permuteOptimal(int[] nums, int i, ArrayList<Integer> elems, List<List<Integer>> res) {
        if (i >= nums.length) {
            ArrayList<Integer> result = new ArrayList<>();
            for (int num : nums)
                result.add(num);
            res.add(result);
            return;
        }
        for (int idx = i; idx < nums.length; idx++) {
            swap(nums, i, idx);
            permuteOptimal(nums, i + 1, elems, res);
            swap(nums, i, idx);
        }
    }

    // @ TC --> O(N! * N) --> Every Time running a Loop for size of Array times
    // @ SC --> O(N!) + O(N) + O(N) --> (N!)--> for Answer, O(N)--> for Tracking
    // elements, O(N)--> for Recursion Depth of Recursion
    public static void permute(int[] nums, ArrayList<Integer> elems, List<List<Integer>> res, boolean[] map) {
        if (elems.size() == nums.length) {
            res.add(new ArrayList<>(elems));
            return;
        }
        for (int i = 0; i < map.length; i++) {
            if (!map[i]) {
                elems.add(nums[i]);
                map[i] = true;
                permute(nums, elems, res, map);
                elems.remove(elems.size() - 1);
                map[i] = false;
            }
        }
    }

    // @ TC --> O(N!) * O(N) * O(N) --> for loop when we find the size ==
    // nums.length
    // @ SC --> O(N!) + O(N) + O(N) --> O(N!) for Answer, O(N) --> recursive Stack
    // Spaces,O(N) --> for copying every Permutation
    public static void permuteTesting(int[] nums, ArrayList<Integer> elems, List<List<Integer>> res) {
        if (elems.size() == nums.length) {
            ArrayList<Integer> result = new ArrayList<>();
            for (int i : elems)
                result.add(nums[i]);
            res.add(result);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!elems.contains(i)) {
                elems.add(i);
                permuteTesting(nums, elems, res);
                elems.remove(elems.size() - 1);
            }
        }
    }

    // ! ⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️ This is Wrong --> Not printing Perfectly ⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️
    public static void permuteHelper(int[] nums, int i, ArrayList<Integer> elems, Set<List<Integer>> res) {
        if (i >= nums.length) {
            // if (elems.size() == 3)
            // res.add(new ArrayList<>(elems));
            System.out.println(elems);
            return;
        }
        boolean isPick = false;
        if (!elems.contains(nums[i])) {
            elems.add(nums[i]);
            isPick = true;
        }
        permuteHelper(nums, i + 1, elems, res);
        if (isPick) {
            elems.remove(elems.size() - 1);
        }
        permuteHelper(nums, i + 1, elems, res);
    }

    // ! ============== LC90. Subsets II =============
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        // Set<List<Integer>> res = new HashSet<>();
        // subsetsWithDupBrute(nums, 0, new ArrayList<>(), res);
        // return new ArrayList<>(res);

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        subsetsWithDupBetter(nums, 0, new ArrayList<>(), res);
        return res;
    }

    // @ TC --> O(2^unq(N)) * O(N) --> in every recursion call we are calling only
    // UNQ elements , O(N) --> every time copying elements to the Res
    // @ SC --> O(2^N) * K --> ultimately we have 2^N subsets and each subset having
    // an average size of K (ASSUME)
    public static void subsetsWithDupBetter(int[] nums, int i, ArrayList<Integer> elems, List<List<Integer>> res) {
        if (i >= nums.length)
            return;
        for (int idx = i; idx < nums.length; idx++) {
            if (idx > i && nums[idx - 1] == nums[idx])
                continue;
            elems.add(nums[idx]);
            res.add(new ArrayList<>(elems)); // @ TC -> O(K) --> creating a new List with K ELements
            subsetsWithDupBetter(nums, idx + 1, elems, res);
            elems.remove(elems.size() - 1);
        }
    }

    // @ TC --> O(2^N) * O(K) --> O(K) for copying elements to Res and adding to Set
    // @ SC --> O(2^N) * K --> K elements and 2^n subsets
    public static void subsetsWithDupBrute(int[] nums, int i, ArrayList<Integer> elems, Set<List<Integer>> res) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(elems)); // @ O(K) --> copying K Elements and creating new List
            return;
        }
        elems.add(nums[i]);
        subsetsWithDupBrute(nums, i + 1, elems, res);
        elems.remove(elems.size() - 1);
        subsetsWithDupBrute(nums, i + 1, elems, res);
    }

    // TODO : LOOK BACK IN DP SERIES
    // ! ============== GFG. Count Subsets with Sum =============
    // * https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1
    // @ TC --> O(2^n)
    // @ SC --> O(2^n) --> recursive Stack Space --> negligible
    static int perfectSum(int arr[], int sum) {
        Arrays.sort(arr);
        return perfectSum(arr, 0, sum);
    }

    static int perfectSum(int arr[], int i, int target) {
        if (i >= arr.length) {
            if (target == 0)
                return 1;
            return 0;
        }
        if (arr[i] > target)
            return 0;
        int left = perfectSum(arr, i + 1, target - arr[i]);
        int right = perfectSum(arr, i + 1, target);
        return left + right;
    }

    // ! ============== GFG. Subset Sum Problem =============
    // * https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
    // @ TC --> O(2^n)
    // @ SC --> O(2^n) --> recursive Stack Space --> negligible
    static boolean isSubsetSum(int arr[], int sum) {
        return isSubsetSum(arr, 0, sum);
    }

    static boolean isSubsetSum(int arr[], int i, int target) {
        if (target == 0)
            return true;
        if (i >= arr.length || target < 0) {
            return false;
        }
        boolean left = isSubsetSum(arr, i + 1, target - arr[i]);
        if (left)
            return true;
        boolean right = isSubsetSum(arr, i + 1, target);
        if (right)
            return true;
        return false;
    }

    // ! ============== GFG. Subset Sum =============
    // * https://www.geeksforgeeks.org/problems/subset-sums2234/1

    // @ TC --> O(2^N) --> using recursion
    // @ SC --> O(n^2) --> because we are generating subsets
    public static ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        subsetSums(arr, 0, 0, res);
        return res;
    }

    public static void subsetSums(int[] arr, int i, int sum, ArrayList<Integer> res) {
        if (i >= arr.length) {
            res.add(sum);
            return;
        }
        subsetSums(arr, i + 1, sum + arr[i], res);
        subsetSums(arr, i + 1, sum, res);
    }

    // ! ============== UTILITY METHODS (Not included in daily) =============
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// ! Target Min -> 3 , Max -> 5 (Quality Problems Only)
// 1. GFG. Subset Sum ✅
// 2. GFG. Subset Sum Problem ✅`
// 3. GFG. Count Subsets with Sum - DP (look back in DP series)❌
// 4. LC90. Subsets II ✅
// 5. LC46. Permutations ✅