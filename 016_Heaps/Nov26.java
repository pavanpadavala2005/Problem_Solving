import java.util.*;

public class Nov26 {
    // ! ============= LC347. Top K Frequent Elements ============
    // @ TC --> O(N + E + K)  --> E -> number of Elements in the Map 
    // Worst case O(N + N + K)
    // @ SC --> O(N) Worst Case 
    public static int[] topKFrequentOptimal(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i : nums)
            freq.put(i, freq.getOrDefault(i, 0) + 1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int i : freq.keySet()) {
            pq.offer(new int[] { i, freq.get(i) });
            if (pq.size() > k)
                pq.poll();
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = pq.poll()[0];

        return res;
    }

    public static int[] topKFrequentBetter(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i : nums)
            freq.put(i, freq.getOrDefault(i, 0) + 1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int i : freq.keySet()) {
            pq.offer(new int[] { i, freq.get(i) });
            if (pq.size() > k)
                pq.poll();
        }

        int[] res = new int[k];
        int idx = 0;
        while (!pq.isEmpty())
            res[idx++] = pq.poll()[0];
        return res;
    }

    // ! ============= LC414. Third Maximum Number ============
    public int thirdMax(int[] nums) {
        int n = nums.length;

        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int elem = nums[i];
            if (elem == first || elem == second || elem == third)
                continue;
            if (elem > first) {
                third = second;
                second = first;
                first = elem;
            } else if (elem > second) {
                third = second;
                second = elem;
            } else if (elem > third)
                third = elem;
        }

        if (third == Long.MIN_VALUE)
            return (int) first;
        return (int) third;
    }

    // ! ============= LC215. Kth Largest Element in an Array ============
    //  * Not Working  
    public static int findKthLargestOptimal(int[] nums, int k) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;
        int target = n - k;

        Random rand = new Random();
        while (left <= right) {
            int pivotIdx = left + rand.nextInt(right - left + 1);
            int pivot = partition(nums, left, right, pivotIdx);

            if (target < pivot)
                right = pivot - 1;
            else if (target > pivot)
                left = pivot + 1;
            else
                return nums[pivot];
        }
        return -1;
    }

    public static int partition(int[] nums, int i, int j, int pivotIdx) {
        int pivot = nums[pivotIdx];
        swap(nums, j, pivotIdx);
        int prev = i;
        for (int idx = i; idx < j; idx++) {
            if (nums[idx] <= pivot) {
                swap(nums, idx, prev);
                prev++;
            }
        }
        swap(nums, prev, j);
        return prev;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // @ TC --> O(N log N)
    // @ SC --> O(K)
    public static int findKthLargestBetter(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            pq.offer(nums[i]);
            if (pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC215. Kth Largest Element in an Array ✅
// 2. LC414. Third Maximum Number ✅
// 3. LC347. Top K Frequent Elements ✅