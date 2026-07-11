
import java.util.Arrays;

public class July05 {

    public static void main(String[] args) {
        // int[] nums = new int[] { 4, 6, 2, 5, 7, 9, 1, 3 };
        // quickSort(nums);
        // System.out.println(Arrays.toString(nums));
        // int[] nums = new int[] { 1, 2, 3, 1, 2, 3, 4 };
        // mergeSort(nums);
        // merge(nums);
        int[] nums = new int[] { 3, 1, 2, 4, 1, 5, 2, 6, 4 };
        System.out.println(Arrays.toString(nums));
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeV2(int[] nums, int low, int mid, int high) {
        int n = high - low;
        int[] resArr = new int[n];
        int i = low;
        int j = mid;
        int k = 0;
        while (i < mid && j < high) {
            if (nums[i] <= nums[j])
                resArr[k++] = nums[i++];
            else
                resArr[k++] = nums[j++];
        }
        while (i < mid)
            resArr[k++] = nums[i++];
        while (j < high)
            resArr[k++] = nums[j++];
        for (int idx = 0; idx < n; idx++)
            nums[idx + low] = resArr[idx];
    }

    public static void merge(int[] nums) {
        int low = 0;
        int high = nums.length;
        int mid = low + (high - low) / 2;
        merge(nums, low, mid, high);
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        int n = high - low;
        int[] resArr = new int[n];
        int i = low;
        int j = mid;
        int k = 0;
        while (i < mid && j < high) {
            if (nums[i] <= nums[j]) {
                resArr[k] = nums[i];
                i++;
            } else {
                resArr[k] = nums[j];
                j++;
            }
            k++;
        }
        while (i < mid) {
            resArr[k] = nums[i];
            i++;
            k++;
        }
        while (j < high) {
            resArr[k] = nums[j];
            j++;
            k++;
        }
        for (int idx = 0; idx < n; idx++) {
            nums[idx + low] = resArr[idx];
        }
    }

    public static void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length);
    }

    public static void mergeSort(int[] nums, int low, int high) {
        if (high - low <= 1)
            return;
        int mid = low + (high - low) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);

    }

    public static void printArr(int[] nums, int i, int j) {
        System.out.print("[");
        while (i <= j) {
            System.out.print(nums[i] + ",");
            i++;
        }
        System.out.print("]");
        System.out.println();
    }

    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivot = partition(nums, low, high);
            quickSort(nums, low, pivot - 1);
            quickSort(nums, pivot + 1, high);
        }
    }

    private static int partition(int[] nums) {
        return partition(nums, 0, nums.length - 1);
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (i <= j && nums[i] <= pivot)
                i++;
            while (i <= j && nums[j] > pivot)
                j--;
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, low, j);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void swap(int i, int j) {
        int temp = i;
        i = j;
        j = temp;
    }
}