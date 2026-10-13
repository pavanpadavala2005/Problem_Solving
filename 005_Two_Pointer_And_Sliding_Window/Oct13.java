
public class Oct13 {
    // ! ============= LC1004. Max Consecutive Ones III =============
    /*
    @ TC --> O(N+N)
    @ SC --> O(1)
    */
    public static int longestOnes(int[] nums, int k) {
        int ones = 0;
        int zeros = 0;
        int n = nums.length;
        int j = 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)
                zeros++;
            else
                ones++;
            if (zeros > k) {
                if (nums[j] == 0)
                    zeros--;
                else
                    ones--;
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

    // ! ============= LC3. Longest Substring Without Repeating Characters =============
    /*
    @ TC --> O(N + N) --> inner while loop is Not running for Every i
    @ SC --> O(256) --> we are Hashing so for every problem it was Constant
    */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        boolean[] track = new boolean[256];
        int maxLen = Integer.MIN_VALUE;
        int i = 0;
        for (int j = 0; j < n; j++) {
            char ch = s.charAt(j);
            while (track[ch]) {
                track[s.charAt(i)] = false;
                i++;
            }
            maxLen = Math.max(j - i + 1, maxLen);
            track[ch] = true;
        }
        if (maxLen == Integer.MIN_VALUE)
            maxLen = 0;
        return maxLen;
    }

    // ! ============= LC1423. Maximum Points You Can Obtain from Cards =============
    /*
    @ TC --> O(2 * K)
    @ SC --> O(1)
    */
    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;
        for (int i = n - k; i < n; i++)
            sum += cardPoints[i];
        int ans = sum;
        int j = n - k;
        for (int i = n; i < n + k; i++) {
            sum += (cardPoints[i % n] - cardPoints[j % n]);
            j++;
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC1423. Maximum Points You Can Obtain from Cards ✅
// 2. LC3. Longest Substring Without Repeating Characters ✅
// 3. LC1004. Max Consecutive Ones III ✅