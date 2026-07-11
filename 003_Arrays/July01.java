
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class July01 {
    public static List<Integer> majorityElementIIBrute(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (res.isEmpty() || res.get(res.size() - 1) != nums[i]) {
                int ctr = 0;
                for (int j = 0; j < n; j++)
                    if (nums[j] == nums[i])
                        ctr++;
                if (ctr > n / 3)
                    res.add(nums[i]);
            }
        }
        return res;
    }

    // ! Take a HashMap and keep a counter and when ever the counter exceeded the
    // n/3 just add it to the Result
    public static List<Integer> majorityElementIIBetter(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            if (freq.get(nums[i]) > n / 3 && !res.contains(nums[i]))
                res.add(nums[i]);
        }
        return res;
    }

    public static List<Integer> majorityElementIIOptimal(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        int ctr1 = 0;
        int elem1 = Integer.MIN_VALUE;
        int ctr2 = 0;
        int elem2 = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (ctr1 == 0 && elem2 != nums[i]) {
                elem1 = nums[i];
                ctr1 = 1;
            } else if (ctr2 == 0 && elem1 != nums[i]) {
                elem2 = nums[i];
                ctr2 = 1;
            } else if (elem1 == nums[i]) {
                ctr1++;
            } else if (elem2 == nums[i]) {
                ctr2++;
            } else {
                ctr1--;
                ctr2--;
            }
        }
        ctr1 = 0;
        ctr2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == elem1)
                ctr1++;
            if (nums[i] == elem2)
                ctr2++;
        }
        if (ctr1 > n / 3)
            res.add(elem1);
        if (ctr2 > n / 3)
            res.add(elem2);
        return res;
    }

    public static int missingNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++)
            res ^= i;
        return res;
    }

    public static int misingNumberBrute(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int diff = 0;
        for (int i = 1; i <= nums.length; i++) {
            diff += i;
        }
        return diff - sum;
    }

    public static int misingNumberBetter(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res += i;
            res -= nums[i];
        }
        return res;
    }

    public static int missingNumberOptimal(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            System.out.println(i + "-->" + nums[i - 1]);
            res ^= i;
            res ^= nums[i - 1];
        }
        return res;
    }

    public static int findDuplicate_mark(int[] nums) {
        int len = nums.length;
        for (int num : nums) {
            int idx = Math.abs(num);
            System.out.println("Idx" + idx);
            if (nums[idx] < 0) {
                return idx;
            }
            nums[idx] = -nums[idx];
        }
        return len;
    }
}