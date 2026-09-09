public class Sep09 {
    // ! ============== LC52. N-Queens II =============
    public static int totalNQueens(int n) {
        if (n <= 1)
            return 1;
        return totalNQueens(n, 0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);
    }

    // @ TC --> O(N!) --> running loop for N times every time and recursive call
    // for every N-1 times in every recursion call

    // @ SC --> O(N)+O(2N)+O(2N) --> Storing State
    public static int totalNQueens(int n, int col, boolean[] left, boolean[] lt, boolean[] lb) {
        if (col > n - 1)
            return 1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] || lt[i + col] || lb[n + i - col - 1])
                continue;
            left[i] = true;
            lt[i + col] = true;
            lb[n + i - col - 1] = true;
            count += totalNQueens(n, col + 1, left, lt, lb);
            left[i] = false;
            lt[i + col] = false;
            lb[n + i - col - 1] = false;
        }
        return count;
    }
    // ! ============== LC3304. Find the K-th Character in String Game I
    // =============

    public static char kthCharacter(int k) {
        return getString(new StringBuilder("a"), 1, 10, k).charAt(k - 1);
    }

    // @ TC --> O(Limit * 2^count) --> 2^count --> compounding
    // @ SC --> O(2^count)
    public static String getString(StringBuilder sb, int count, int limit, int k) {
        if (count == limit)
            return sb.toString();
        int len = sb.length();
        if (len >= k)
            return sb.toString();
        for (int i = 0; i < len; i++) {
            sb.append((char) (sb.charAt(i) + 1));
            if (sb.length() >= k)
                return sb.toString();
        }
        return getString(sb, count + 1, limit, k);
    }
}
// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC3304. Find the K-th Character in String Game I ✅
// 2. LC52. N-Queens II ✅