
import java.util.Arrays;

public class Example1 {
    public static int maxElement(int[] nums) {
        // O(N log N) --> brute force
        // if (nums.length <= 0)
        // return -1;
        // Arrays.sort(nums);
        // return nums[nums.length - 1];

        int maxElem = nums[0];
        for (int i = 1; i < nums.length; i++)
            maxElem = Math.max(nums[i], maxElem);
        // if (nums[i] > maxElem)
        // maxElem = nums[i];

        return maxElem;
    }

    public static int secondLargest(int[] nums) {
        if (nums.length <= 1)
            return -1;
        // ! Brute force O (N log N) + N -- brute force (Sort Array and come from back)
        // Arrays.sort(nums);
        // int second = nums[nums.length - 1];
        // for (int i = nums.length - 2; i >= 0; i--) {
        // if (nums[i] != second) {
        // return nums[i];
        // }
        // }

        // Better O( N + N )
        // int first = nums[0];
        // int n = nums.length;
        // for (int i = 1; i < n; i++)
        // first = Math.max(nums[i], first);
        // int second = -1;
        // for (int i = 0; i < n; i++) {
        // if ((nums[i] > second) && (nums[i] != first))
        // second = nums[i];
        // }

        int first = nums[0];
        int second = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > first) {
                second = first;
                first = nums[i];
            } else if (nums[i] > second && nums[i] != first) {
                second = nums[i];
            }
        }
        return second;
    }

    public static int secondSmallest(int[] nums) {
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < first) {
                second = first;
                first = nums[i];
            } else if (nums[i] < second && nums[i] > first)
                second = nums[i];
        }
        return second;
    }

    public static boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            if (!(nums[i] >= nums[i - 1]))
                return false;
        return true;
    }

    public static int removeDuplicates(int[] nums) {
        // ! Time Complexity
        // ! O(N log N) --> inserting into Set and O(N) for copying to Arr
        // @ Space O(N)
        // LinkedHashSet<Integer> st = new LinkedHashSet<>();
        // for (int num : nums)
        // st.add(num);
        // int size = st.size();
        // for (int i = 0; i < size; i++) {
        // nums[i] = st.removeFirst();
        // }
        // return Arrays.toString(nums);

        int i = 0;
        for (int j = 1; j < nums.length; j++)
            if (nums[i] != nums[j])
                nums[++i] = nums[j];
        return i + 1;
    }

    public static int[] leftRotateOne(int[] nums) {
        int elem = nums[0];
        for (int i = 1; i < nums.length; i++)
            nums[i - 1] = nums[i];
        nums[nums.length - 1] = elem;
        System.out.println(Arrays.toString(nums));
        return nums;
    }

    public static int[] leftRotateK(int[] nums, int k) {
        // ! Brute Force O(N)
        // int n = nums.length;
        // k = k % n;
        // int[] tempArr = new int[k];
        // for (int i = 0; i < k; i++)
        // tempArr[i] = nums[i];

        // for (int i = k; i < n; i++)
        // nums[i - k] = nums[i];
        // int j = 0;
        // for (int i = n - k; i < n; i++) {
        // nums[i] = tempArr[j];
        // j++;
        // }

        // ! Optimal
        // @ Reverse from 0 -> d
        // @ Reverse from d+1 -> n
        // @ Reverse from 0 -> n
        int n = nums.length - 1;
        reverse(nums, 0, k - 1);
        reverse(nums, k, n);
        reverse(nums, 0, n);
        return nums;
    }

    public static int[] rightRotateK(int[] nums, int k) {
        int n = nums.length - 1;
        reverse(nums, 0, n - k);
        reverse(nums, n - k + 1, n);
        reverse(nums, 0, n);
        return nums;
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    private static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++)
            newArr[(i + k) % n] = nums[i];
        nums = newArr;
        System.out.println(Arrays.toString(nums));
    }

    public static int[] moveZeros(int[] nums) {
        int n = nums.length;
        int[] newArr = new int[n];
        int i = 0;
        for (int j = 0; j < n; j++)
            if (nums[j] != 0)
                newArr[i++] = nums[j];
        return newArr;
    }

}
