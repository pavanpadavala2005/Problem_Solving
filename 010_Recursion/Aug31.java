import java.util.*;

public class Aug31 {
    // ! ============== LC62. Unique Paths =============
    public static int uniquePaths(int m, int n) {
        return uniquePathsbrute(m, n);
    }

    public static int uniquePathsMemo(int m, int n, int[][] mat) {
        if (m == 0 || n == 0)
            return 1;
        if (mat[m][n] != 0)
            return mat[m][n];
        mat[m][n] = uniquePathsMemo(m, n - 1, mat) + uniquePathsMemo(m - 1, n, mat);
        return mat[m][n];
    }

    // @ TC --> O(2^(m*n)) --> it will take more time
    // @ SC --> O(1) --> we are not using anything other than variables
    public static int uniquePathsRec(int m, int n) {
        if (m == 0 || n == 0)
            return 1;
        return uniquePathsRec(m, n - 1) + uniquePathsRec(m - 1, n);
    }

    // @ TC --> O(M*N) --> two Loops
    // @ SC --> O(N*N) --> using a matrix to Store Data
    public static int uniquePathsbrute(int m, int n) {
        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    mat[i][j] = 1;
                else
                    mat[i][j] = mat[i][j - 1] + mat[i - 1][j];
            }
        }
        return mat[m - 1][n - 1];
    }

    // ! ============== GFG. Distinct Permutations of a String =============
    public static ArrayList<String> findPermutation(String s) {
        ArrayList<String> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        findPermutation(chars, new StringBuilder(), res, new boolean[s.length()]);
        return res;
    }

    public static void findPermutation(char[] chars, StringBuilder sb, ArrayList<String> res, boolean[] track) {
        if (sb.length() == chars.length) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (track[i] || (i > 0 && chars[i - 1] == chars[i] && !track[i - 1]))
                continue;
            track[i] = true;
            sb.append(chars[i]);
            findPermutation(chars, sb, res, track);
            sb.deleteCharAt(sb.length() - 1);
            track[i] = false;
        }
    }

    // ! ============== GFG. All String Permutations in Sorted Order =============
    // *https://www.geeksforgeeks.org/problems/permutations-of-a-given-string-1587115620/1
    public static ArrayList<String> permutation(String s) {
        ArrayList<String> res = new ArrayList<>();
        char[] arr = s.toCharArray();
        permutation(arr, 0, res);
        Collections.sort(res);
        return res;
    }

    // @ TC --> O(NlogN) + O(N) + O(N!) * O(N) + O(N) --> O(N!) --> recursion Tc ,
    // O(N) --> inside Loop, O(N)--> convert form chars Arr to String
    // @ SC --> O(N!) + O(N!)*O(N) --> N! --> recursion stack (Negligible), N!* N
    // --> size of Array List * size of String in result
    public static void permutation(char[] chars, int i, ArrayList<String> res) {
        if (i >= chars.length) {
            res.add(new String(chars));
        }
        for (int idx = i; idx < chars.length; idx++) {
            swap(chars, i, idx);
            permutation(chars, i + 1, res);
            swap(chars, i, idx);
        }
    }

    // ! ============== GFG. All Unique Permutations of an array =============
    // *https://www.geeksforgeeks.org/problems/all-unique-permutations-of-an-array/1
    public static ArrayList<ArrayList<Integer>> uniquePerms(int[] arr) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        uniquePermsOptimal(arr,
                new ArrayList<>(),
                res,
                new boolean[arr.length]);
        return res;
    }

    public static void uniquePermsOptimal(int[] nums, ArrayList<Integer> elems, ArrayList<ArrayList<Integer>> res,
            boolean[] track) {
        if (elems.size() == nums.length) {
            res.add(new ArrayList<>(elems));
            return;
        }
        for (int idx = 0; idx < nums.length; idx++) {
            if (track[idx] || (idx > 0 && nums[idx - 1] == nums[idx] && !track[idx - 1]))
                continue;
            track[idx] = true;
            elems.add(nums[idx]);
            uniquePermsOptimal(nums, elems, res, track);
            track[idx] = false;
            elems.remove(elems.size() - 1);
        }
    }

    public static void uniquePerms(int[] nums, int i, Set<ArrayList<Integer>> res) {
        if (i >= nums.length) {
            ArrayList<Integer> result = new ArrayList<>();
            for (int num : nums)
                result.add(num);
            if (!res.contains(result))
                res.add(result);
        }
        for (int idx = i; idx < nums.length; idx++) {
            swap(nums, idx, i);
            uniquePerms(nums, i + 1, res);
            swap(nums, idx, i);
        }
    }

    // ! ============== UTILITY METHODS (Not included in daily) =============
    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}