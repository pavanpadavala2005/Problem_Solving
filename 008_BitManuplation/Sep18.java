import java.util.*;

public class Sep18 {
    // ! ============== LC1310. XOR Queries of a Subarray =============
    // @ TC --> O(N)+O(Q) --> length of Arr + length of Queries
    // @ SC --> O(1) + O(Q) --> O(Q) for returning answer only so Not considerable
    public static int[] xorQueries(int[] arr, int[][] queries) {
        // int[] xorArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i > 0)
                arr[i] = arr[i - 1] ^ arr[i];
        }
        int[] resArr = new int[queries.length];
        int idx = 0;
        for (int[] q : queries) {
            if (q[0] == 0)
                resArr[idx++] = arr[q[1]];
            else
                resArr[idx++] = arr[q[0] - 1] ^ arr[q[1]];
            // idx++;
        }
        return resArr;
    }

    // ! ============== LC1720. Decode XORed Array =============
    // @ TC --> O(N);
    // @ SC --> O(N+1) --> returning answer only so Not considerable
    public static int[] decode(int[] encoded, int first) {
        int n = encoded.length;
        int[] resArr = new int[n + 1];
        resArr[0] = first;
        for (int i = 1; i <= n; i++)
            resArr[i] = encoded[i - 1] ^ resArr[i - 1];
        System.out.println(Arrays.toString(resArr));
        return resArr;
    }

    // ! ============== LC1486. XOR Operation in an Array =============
    // * VERY VERY Interesting Problem
    // @ TC --> O(1) -- No Loop just logic
    // @ SC --> O(1)
    public static int xorOperation(int n, int start) {
        int left = start;
        int right = start + 2 * (n - 1);
        if (left % 4 <= 1) {
            if (n % 4 == 1)
                return right;
            else if (n % 4 == 2)
                return 2;
            else if (n % 4 == 3)
                return 2 ^ right;
            return 0;
        } else {
            if (n % 4 == 1)
                return left;
            else if (n % 4 == 2)
                return left ^ right;
            else if (n % 4 == 3)
                return left ^ 2;
            return left ^ 2 ^ right;
        }
    }

    // ! ============== LC90. Subsets II =============
    // @ TC --> O(N log N) + O(2ⁿ)*O(N) --> Sorting and getting subsets and
    // getting unq subsets
    // @ SC --> O(2ⁿ) --> returning answer only so Not considerable
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> elems = new ArrayList<>();
            boolean isValid = true;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    if (j > 0 && nums[j - 1] == nums[j] && (i & (1 << (j - 1))) == 0) {
                        isValid = false;
                        break;
                    }
                    elems.add(nums[j]);
                }
            }
            if (isValid)
                res.add(elems);
        }
        return res;
    }

    // ! ============== LC371. Sum of Two Integers =============
    // @ TC --> O(32) --> iterating through 32 bits Each time
    // @ SC --> O(1) --> using only integer and 32 bits
    public static int getSumBrute(int a, int b) {
        int carry = 0;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = res | (carry << i);
            carry = 0;
            if ((a & (1 << i)) != 0) {
                if ((res & (1 << i)) != 0) {
                    res = res & ~(1 << i);
                    carry = 1;
                } else
                    res = res | (1 << i);
            }
            if ((b & (1 << i)) != 0) {
                if ((res & (1 << i)) != 0) {
                    res = res & ~(1 << i);
                    carry = 1;
                } else
                    res = res | (1 << i);
            }
        }
        return res;
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC371. Sum of Two Integers ✅
// 2. LC90. Subsets II ✅
// 3. LC1486. XOR Operation in an Array ✅ 💆
// 4. LC1720. Decode XORed Array ✅
// 5. LC1310. XOR Queries of a Subarray ✅