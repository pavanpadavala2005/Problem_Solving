import java.util.*;

public class June13 {
    public static List<Integer> majorityElementIIBrute(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (res.size() == 0 || res.get(0) != nums[i]) {
                int ctr = 0;
                for (int j = i; j < n; j++)
                    if (nums[i] == nums[j])
                        ctr++;
                if (ctr > n / 3)
                    res.add(nums[i]);
            }
        }
        return res;
    }

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
        int ctr1 = 0;
        int ctr2 = 0;
        int elem1 = -1;
        int elem2 = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (ctr1 == 0 && nums[i] != elem2) {
                ctr1 = 1;
                elem1 = nums[i];
            } else if (ctr2 == 0 && nums[i] != elem1) {
                ctr2 = 1;
                elem2 = nums[i];
            } else if (nums[i] == elem1)
                ctr1++;
            else if (nums[i] == elem2)
                ctr2++;
            else {
                ctr1--;
                ctr2--;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        if (elem1 != -1)
            res.add(elem1);
        if (elem2 != -1)
            res.add(elem2);
        return res;
    }
}