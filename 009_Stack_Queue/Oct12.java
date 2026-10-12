public class Oct12 {
    // ! ============= LC856. Score of Parentheses =============
    /*
    @ TC --> O(N)
    @ SC --> O(N) --> Using a Stack So in Worst case we may Store all half of the Open Braces 
    */
    public static int scoreOfParentheses(String s) {
        int n = s.length();
        int[] st = new int[n];
        int ptr = -1;
        st[++ptr] = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                st[++ptr] = 0;
            } else {
                int val = st[ptr--];
                int score = Math.max(val * 2, 1);
                int prev = st[ptr--];
                st[++ptr] = score + prev;
            }
        }
        return st[ptr];
    }
    // ! ============= LC921. Minimum Add to Make Parentheses Valid =============

    public static int minAddToMakeValid(String s) {
        /*
        @ TC --> O(N) --> Running only One loop 
        @ SC --> O(N) --> At most we may Store all characters in Stack
        */
        int ans = 0;
        int n = s.length();
        char[] st = new char[n];
        int ptr = -1;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                st[++ptr] = ch;
            else {
                if (ptr < 0)
                    ans++;
                else
                    ptr--;
            }
        }
        return ans + ptr + 1;
    }

    // TODO: PENDING
    // ! ============= LC2281. Sum of Total Strength of Wizards =============
    public static int totalStrength(int[] strength) {
        int n = strength.length;
        long ans = 0;
        long MOD = 10_00_00_0 + 7;
        for (int i = 0; i < n; i++) {
            int mini = strength[i];
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += strength[j];
                mini = Math.min(mini, strength[j]);
                ans += (sum * mini) % MOD;
            }
        }
        return (int) ans;
    }
}
// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC856. Score of Parentheses ✅
// 2. LC921. Minimum Add to Make Parentheses Valid ✅