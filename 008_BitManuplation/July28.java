import java.util.*;

public class July28 {
    // !======================= SINGLE NUMBER III ======================
    public static int[] singleNumberIIIOptimal(int[] nums) {
        int temp = 0;
        for (int i : nums)
            temp ^= i;
        // int set = temp & (~(temp - 1));
        int set = (temp & temp - 1) ^ temp;
        int bucket1 = 0, bucket2 = 0;
        for (int num : nums) {
            if ((num & set) != 0)
                bucket1 ^= num;
            else
                bucket2 ^= num;

        }
        return new int[] {
                bucket1,
                bucket2
        };
    }

    public static int[] singleNumberIIIBetter1(int[] nums) {
        int[] res = new int[2];
        int idx = 0;
        int val = 0;
        for (int num : nums)
            val ^= num;
        System.out.println(val);
        int temp1 = val;
        for (int num : nums)
            temp1 ^= num;
        int temp2 = val;
        for (int num : nums)
            temp2 ^= num;
        res[idx++] = temp1;
        res[idx++] = temp2;
        return res;
    }

    public static int[] singleNumberIIIBetter(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int n = nums.length;
        int[] res = new int[2];
        int i = 0;
        int j = 1;
        while (j < n) {
            if ((nums[j - 1] ^ nums[j]) != 0) {
                res[i] = nums[j - 1];
                i++;
                j++;
                continue;
            }
            j += 2;
        }
        if (i <= 1)
            res[i] = nums[n - 1];
        return res;
    }

    public static int[] singleNumberIIIBrute(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums)
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        int[] res = new int[2];
        int i = 0;
        for (int key : freq.keySet())
            if (freq.get(key) == 1) {
                res[i] = key;
                i++;
            }
        return res;
    }

    // !======================= SINGLE NUMBER II =======================
    public static int singleNumberIIOptimal2(int[] nums) {
        int ones = 0;
        int twos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (((ones ^ nums[i]) & ~twos) != 0) {
                ones ^= nums[i];
                twos ^= nums[i];
            } else if (((ones ^ nums[i]) & ~twos) == 0) {
                ones ^= nums[i];
                twos ^= nums[i];
            }
        }
        return ones;
    }

    public static int singleNumberIIOptimal1(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int ctr = 0;
            for (int idx = 0; idx < nums.length; idx++)
                if ((nums[idx] & (1 << i)) != 0)
                    ctr++;
            if ((ctr % 3) != 0)
                res = res | (1 << i);
        }
        return res;
    }

    public static int singleNumberIIBetter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n == 1)
            return nums[0];
        for (int i = 1; i < n; i += 3) {
            if ((nums[i] ^ nums[i - 1]) != 0)
                return nums[i - 1];
        }
        return nums[n - 1];
    }

    public static int singleNumberIIBrute(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i : nums)
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        for (int i : freq.keySet())
            if (freq.get(i) == 1)
                return i;
        return -1;
    }

    // !======================= POWER SET =======================
    public static ArrayList<String> powerSetString(String s) {
        ArrayList<String> res = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < 1 << n; i++) {
            StringBuilder inner = new StringBuilder();
            for (int pos = 0; pos < n; pos++)
                if ((i & (1 << pos)) != 0)
                    inner.append(s.charAt(pos));
            res.add(inner.toString());
        }
        res.sort((i, j) -> Integer.compare(i.length(), j.length()));
        return res;
    }

    public static ArrayList<ArrayList<Integer>> powerSetArray(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < 1 << n; i++) {
            ArrayList<Integer> inner = new ArrayList<>();
            for (int pos = 0; pos < n; pos++)
                if ((i & (1 << pos)) != 0)
                    inner.add(nums[pos]);
            res.add(inner);
        }
        return res;
    }

    public static int findPosition(int n) {

        if ((n > 0) && ((n & (n - 1)) == 0)) {
            int ctr = 1;
            while (n > 0) {
                ctr++;
                n >>= 1;
            }
            return ctr;
        }
        return -1;
    }
}
