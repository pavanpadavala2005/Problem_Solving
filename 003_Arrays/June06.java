public class June06 {
    private static int minimumUtil(int num, boolean isleft) {
        int count = 0;
        for (int i = num; isleft ? i > 0 : i < 2 * num + 1; i += (isleft ? -1 : 1)) {
            if (i % 3 == 0)
                return count;
            count++;
        }
        return count;
    }

    // ! Leet 3190
    public static int minimumOperations(int[] nums) {
        int count = 0;
        for (int i : nums)
            count += Math.min(minimumUtil(i, true), minimumUtil(i, false));
        return count;
    }

    // ! Leet 31 Next Permutation

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(int[] arr, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            swap(arr, j, i);
            i++;
            j--;
        }
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        for (int j = n - 1; j >= idx; j--) {
            if (nums[j] > nums[idx]) {
                swap(nums, j, idx);
                break;
            }
        }
        reverse(nums, idx + 1, n - 1);
    }

}