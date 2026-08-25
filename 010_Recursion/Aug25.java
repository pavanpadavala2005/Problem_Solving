import java.util.*;

public class Aug25 {

    // ! =============== Gen. Merge Sort ================
    // @ TC --> O(N) * O(log N) --> every time dividing by 2 --> O(log N)
    // @ --> in every division running loop of divided Part if divided part is N
    // --> O(N)

    // @ SC --> O(N)
    public static void mergeSot(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int mid = (left + right) / 2;
        // for (int i = left; i <= mid; i++)
        // System.out.print(arr[i] + " ");
        // System.out.println();
        mergeSot(arr, left, mid); // ! Left Recursion
        // for (int i = mid + 1; i <= right; i++)
        // System.out.print(arr[i] + " ");
        // System.out.println();
        mergeSot(arr, mid + 1, right); // ! Right Recursion
        merge(arr, left, mid, right); // ! Merging Left and Right Recursively
    }

    public static int[] merge(int[] arr, int left, int mid, int right) {
        int i = left, j = mid + 1;
        int[] resArr = new int[right - left + 1];
        int ptr = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                resArr[ptr++] = arr[i++];
                // i++;
            } else {
                resArr[ptr++] = arr[j++];
                // j++;
            }
            // ptr++;
        }
        while (i <= mid) {
            resArr[ptr++] = arr[i++];
            // i++;
            // ptr++;
        }
        while (j <= right) {
            resArr[ptr++] = arr[j++];
            // j++;
            // ptr++;
        }
        for (int k = 0; k < resArr.length; k++)
            arr[k + left] = resArr[k];
        return arr;
    }

    // ! =============== Gen. Print number of SubSequence Whose Sum equal
    // ================
    public static int countSubSequencesSumToK(int[] nums, int i, int target, int sum) {
        if (i >= nums.length) {
            if (sum == target)
                return 1;
            return 0;
        }
        int left = countSubSequencesSumToK(nums, i + 1, target, sum + nums[i]);
        int right = countSubSequencesSumToK(nums, i + 1, target, sum);
        return left + right;
    }

    // ! =============== Gen. Print AnyOne SubSequence Whose Sum equal to K
    // ================
    // @ This is FUNCTIONAL RECURSION --> everything done by passing the Value to
    // Parent
    // * PARENT <-----data------ CHILD (Last Recursion Call) BOTTOM-UP
    public static boolean printOneSubSequenceSumToK(int[] nums, int i, int target, ArrayList<Integer> res, int sum) {
        if (i >= nums.length) {
            if (sum == target) {
                System.out.println(res);
                return true;
            }
            return false;
        }
        res.add(nums[i]);
        boolean left = printOneSubSequenceSumToK(nums, i + 1, target, res, sum + nums[i]);
        if (left)
            return true;
        res.remove(res.size() - 1);
        boolean right = printOneSubSequenceSumToK(nums, i + 1, target, res, sum);
        if (right)
            return true;
        return false;
    }

    // ! =============== Gen. SubSequence Whose Sum equal to K ================
    // @ This is PARAMETERIZED RECURSION --> everything done by storing State and
    // passing to the CHILD
    // * PARENT -----data------> CHILD (Last Recursion Call) TOP-DOWN
    public static void printSubSequencesSumToK(int[] nums, int i, int target, ArrayList<Integer> res, int sum) {
        if (i >= nums.length) {
            if (sum == target) {
                for (int elem : res)
                    System.out.print(elem + " ");
                System.out.println();
            }
            return;
        }
        res.add(nums[i]);
        printSubSequencesSumToK(nums, i + 1, target, res, sum + nums[i]);
        res.remove(res.size() - 1);
        printSubSequencesSumToK(nums, i + 1, target, res, sum);
    }

    // ! =============== LC1498. Number of Subsequences Satisfy Given Sum Condition
    // ================
    public static int numSubseq(int[] nums, int target) {
        // return numSubseqHelperV2(nums, 0, new ArrayList<>(), target, -1,
        // Integer.MAX_VALUE);
        return numSubseqHelperV1(nums, target, 0, new ArrayList<>());
    }

    // @ TC --> O(2^n) --> We are not using any Extra Loop inside
    // @ SC --> O(2^N) --> recursion Stack Space only we are using
    public static int numSubseqHelperV2(int[] nums, int i, ArrayList<Integer> seen, int target, int mx, int mi) {
        if (i >= nums.length) {
            if (mx + mi <= target)
                return 1;
            return 0;
        }
        seen.add(nums[i]);
        int left = numSubseqHelperV2(nums, i + 1, seen, target, Math.max(mx, nums[i]), Math.min(mi, nums[i]));
        seen.remove(seen.size() - 1);
        int right = numSubseqHelperV2(nums, i + 1, seen, target, mx, mi);
        return left + right;
    }

    // @ TC --> O(2^n) * O(N) --> because in every recursion call we are running a
    // Loop
    // @ SC --> O(2^N) --> recursion Stack Space only we are using
    public static int numSubseqHelperV1(int[] nums, int target, int i, ArrayList<Integer> seen) {
        if (i >= nums.length) {
            int mx = -1;
            int mi = Integer.MAX_VALUE;
            for (int val : seen) {
                mx = Math.max(mx, val);
                mi = Math.min(mi, val);
            }
            if (mx + mi <= target)
                return 1;
            return 0;
        }
        seen.add(nums[i]);
        int leftCount = numSubseqHelperV1(nums, target, i + 1, seen);
        seen.remove(seen.size() - 1);
        int rightCount = numSubseqHelperV1(nums, target, i + 1, seen);
        return leftCount + rightCount;
    }

    // ! =============== LC78. Subsets ================
    public static void printSubSets(int[] arr, int i, ArrayList<Integer> res) {
        if (i >= arr.length) {
            System.out.println(res);
            return;
        }
        res.add(arr[i]);
        printSubSets(arr, i + 1, res);
        res.remove(res.size() - 1);
        printSubSets(arr, i + 1, res);
    }
}
// Target Min -> 3 , Max -> 5 (Quality Problems Only)
// 1. LC78. Subsets ✅
// 2. LC1498. Number of Subsequences Satisfy Given Sum Condition ✅
// 3. Gen. SubSequence Whose Sum equal to K ✅
// 4. Gen. Print number of SubSequence Whose Sum equal to K ✅
// 5. Gen. Print AnyOne SubSequence Whose Sum equal to K ✅
// 6. Merge Sort ✅