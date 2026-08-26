
public class Aug26 {
    // ! ============ LC392. Is Subsequence ==============
    public static boolean isSubsequenceBrute(String s, String t) {
        if (t == null || t.length() == 0)
            return false;
        if (s == null || s.length() == 0)
            return true;
        int[] arr = new int[26];
        for (int i = 0; i < t.length(); i++)
            arr[t.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++)
            if (arr[s.charAt(i) - 'a'] == 0)
                return false;
        return true;
    }

    // ! ============ LC389. Find the Difference ==============
    public static char findTheDifferenceBest(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length() + 1; i++) {
            if (i < s.length())
                res ^= s.charAt(i);
            res ^= t.charAt(i);
        }
        return (char) res;
    }

    public static char findTheDifferenceBetter(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length() + 1; i++) {
            if (i < s.length())
                res -= s.charAt(i);
            res += t.charAt(i);
        }
        return (char) res;
    }

    public static char findTheDifferenceBrute(String s, String t) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']--;
            arr[t.charAt(i) - 'a']++;
        }
        arr[t.charAt(t.length() - 1) - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0)
                return (char) (i + 'a');
        }
        return ' ';
    }
}
