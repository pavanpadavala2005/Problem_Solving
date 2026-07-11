
import java.util.HashMap;

public class June12 {
    public static int numberOfSubArrays(int[] nums, int k) {
        // int count = 0;
        // for (int i = 0; i < nums.length; i++) {
        // int sum = 0;
        // for (int j = i; j < nums.length; j++) {
        // sum += nums[j];
        // if (sum == k) {
        // for (int x = i; x <= j; x++) {
        // System.out.print(nums[x] + " ");
        // }
        // count++;
        // break;
        // }
        // }
        // System.out.println();
        // }
        // return count;

        HashMap<Integer, Integer> prev = new HashMap<>();
        prev.put(0, 1);
        int prefix = 0;
        int ctr = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int rem = prefix - k;
            if (prev.containsKey(rem)) {
                ctr += prev.get(rem);
            }
            prev.put(prefix, prev.getOrDefault(prefix, 0) + 1);
        }
        return ctr;
    }

    public static int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int ctr = 0;
        for (int i : hours)
            if (i >= target)
                ctr++;
        return ctr;
    }

    public static int[] transformArray(int[] nums) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] % 2 == 0) {
                nums[right] = 0;
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            } else {
                nums[right] = 1;
            }

        }
        return nums;
    }

    public static int[] getSneakyNumbers(int[] nums) {
        int[] freqArr = new int[101];
        for (int i = 0; i < nums.length; i++)
            freqArr[nums[i]]++;
        int[] resArr = new int[2];
        int idx = 0;
        for (int i = 0; i < freqArr.length; i++) {
            if (freqArr[i] == 2) {
                resArr[idx] = i;
                idx++;
            }
        }
        return resArr;
    }

    public static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - k);
        reverse(nums, 0, n - 1);
    }

}
