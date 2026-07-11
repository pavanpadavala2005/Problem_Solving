import java.util.*;

public class June14 {
    public static List<List<Integer>> threeSumBrute(int[] nums) {
        Set<List<Integer>> unq = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> elems = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(elems);
                        unq.add(elems);
                    }
                }
            }
        }
        return new ArrayList<>(unq);
    }

    public static List<List<Integer>> threeSumBetter(int[] nums) {
        Set<List<Integer>> pairs = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            Set<Integer> prev = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int req = -(nums[i] + nums[j]);
                if (prev.contains(req)) {
                    List<Integer> pair = Arrays.asList(nums[i], nums[j], req);
                    Collections.sort(pair);
                    pairs.add(pair);
                }
                prev.add(nums[j]);
            }
        }
        return new ArrayList<>(pairs);
    }

    public static List<List<Integer>> threeSumOptimal(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0)
                    left++;
                else if (sum > 0)
                    right--;
                else {
                    pairs.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                }
            }
        }
        return pairs;
    }

    public static List<List<Integer>> fourSumBetter(int[] nums, int target) {
        Set<List<Integer>> pairs = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Set<Integer> unq = new HashSet<>();
                for (int k = 0; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int rem = target - sum;
                    if(unq.cotains(rem)){
                        List
                    }
                }
            }
        }
        return new ArrayList<>(pairs);
    }
}
