import java.util.*;

public class June30 {
    public static List<List<Integer>> threeSumBrute(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == target) {
                        List<Integer> resList = new ArrayList<>(List.of(nums[i], nums[j], nums[k]));
                        Collections.sort(resList);
                        set.add(resList);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static List<List<Integer>> threeSumBetter(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            HashSet<Integer> reqSet = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int req = -(nums[i] + nums[j]);
                if (reqSet.contains(req)) {
                    List<Integer> resList = new ArrayList<>(List.of(nums[i], nums[j], req));
                    Collections.sort(resList);
                    set.add(resList);
                }
                reqSet.add(nums[j]);
            }
        }
        return new ArrayList<>(set);
    }

    public static List<List<Integer>> threeSumOptimal(int[] nums, int target) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < target)
                    j++;
                else if (sum > target)
                    k--;
                else {
                    System.out.println(
                            nums[i] + "-->" + i + "\n" +
                                    nums[j] + "-->" + j + "\n" +
                                    nums[k] + "-->" + k);
                    while (j < k && nums[j] == nums[j + 1])
                        j++;
                    while (j < k && nums[k] == nums[k - 1])
                        k--;
                    j++;
                    k--;
                    System.out.println("----------------------");
                }
            }
        }
        return res;
    }
}