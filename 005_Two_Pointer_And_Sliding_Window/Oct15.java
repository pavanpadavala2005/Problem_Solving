public class Oct15 {

    // ! ============= LC992. Subarrays with K Different Integers ============
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithKDistinctHelper(nums, k) - subarraysWithKDistinctHelper(nums, k - 1);
    }

    public static int subarraysWithKDistinctHelper(int[] nums, int k) {
        if (k < 0)
            return 0;
        int ans = 0;
        int n = nums.length;
        int[] track = new int[n + 1];
        int count = 0;
        int i = 0;
        for (int j = 0; j < n; j++) {
            int right = nums[j];
            track[right]++;
            if (track[right] == 1)
                count++;
            while (count > k) {
                int left = nums[i];
                track[left]--;
                if (track[left] == 0)
                    count--;
                i++;
            }
            ans += j - i + 1;
        }
        return ans;
    }

    // ! ============= LC1248. Count Number of Nice Subarrays =============
    /* 
    @ TC --> O(2N + 2N)
    @ SC --> O(2N)
    */
    public int numberOfSubarrays(int[] nums, int k) {
        return numberOfSubarraysHelper(nums, k) - numberOfSubarraysHelper(nums, k - 1);
    }

    /*
    @ TC --> O(N+N)
    @ SC --> O(N)
    */
    public int numberOfSubarraysHelper(int[] nums, int k) {
        if (k < 0)
            return 0;
        int ans = 0;
        int count = 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            count += nums[j] % 2;
            while (count > k)
                count -= nums[i++] % 2;
            ans += j - i + 1;
        }
        return ans;
    }

    // ! ============= LC930. Binary Subarrays With Sum =============
    /* 
    @ TC --> O(2N + 2N)
    @ SC --> O(2N)
    */
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarraysWithSumHelper(nums, goal) - numSubarraysWithSumHelper(nums, goal - 1);
    }

    /*
    @ TC --> O(N+N)
    @ SC --> O(N)
    */
    public static int numSubarraysWithSumHelper(int[] nums, int goal) {
        if (goal < 0)
            return 0;
        int n = nums.length;
        int count = 0;
        int sum = 0;
        int i = 0;
        for (int j = 0; j < n; j++) {
            sum += nums[j];
            while (i < n && sum > goal) {
                sum -= nums[i];
                i++;
            }
            count += (j - i + 1);
        }
        return count;
    }

    // ! ============= LC424. Longest Repeating Character Replacement =============
    /*
    @ TC --> O(N + N)
    @ SC --> O(26) --> can be ignorable
    */
    public static int characterReplacementBetter(String s, int k) {
        int maxLen = 0;
        int[] map = new int[26];
        int max = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            int left = s.charAt(j) - 65;
            map[left]++;
            max = Math.max(max, map[left]);
            while ((j - i + 1) - max > k) {
                int right = s.charAt(i) - 65;
                map[right]--;
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }

    /*
    @ TC --> O((N+N) * 26)
    @ SC --> O(26)
    */
    public static int characterReplacementBrute(String s, int k) {
        int maxLen = 0;
        int[] map = new int[26];
        int max = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            int left = s.charAt(j) - 65;
            map[left]++;
            max = Math.max(max, map[left]);
            while ((j - i + 1) - max > k) {
                int right = s.charAt(i) - 65;
                map[right]--;
                for (int ptr = 0; ptr < 26; ptr++)
                    max = Math.max(map[ptr], max);
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }

    // ! ============= LC1358. Number of Substrings Containing All Three Characters =============
    /*
    @ TC --> O(N) 
    @ SC --> O(1)
    */
    public static int numberOfSubstrings(String s) {
        int ans = 0;
        int a = -1;
        int b = -1;
        int c = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a')
                a = i;
            else if (ch == 'b')
                b = i;
            else
                c = i;
            if (a >= 0 && b >= 0 && c >= 0)
                ans += 1 + Math.min(a, Math.min(b, c));
        }
        return ans;
    }
}
// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC1358. Number of Substrings Containing All Three Characters ✅
// 2. LC424. Longest Repeating Character Replacement ✅
// 3. LC930. Binary Subarrays With Sum ✅
// 4. LC1248. Count Number of Nice Subarrays ✅
// 5. LC992. Subarrays with K Different Integers ✅
