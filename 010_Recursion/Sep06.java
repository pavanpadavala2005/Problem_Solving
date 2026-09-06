
public class Sep06 {
    // ! ============== LC416. Partition Equal Subset Sum =============
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums)
            sum += i;
        return canPartitionBrute(nums, 0, sum, new boolean[nums.length]);
    }

    public static boolean canPartitionBrute(int[] nums, int currSum, int target, boolean[] track) {
        if (target == 0)
            return false;
        if (currSum == target)
            return true;
        for (int i = 0; i < nums.length; i++) {
            if (!track[i]) {
                track[i] = true;
                boolean b = canPartitionBrute(nums, currSum + nums[i], target - nums[i], track);
                if (b)
                    return true;
                track[i] = false;

            }
        }
        return false;
    }

    // ! ============== LC79. Word Search =============
    public static boolean exist(char[][] board, String word) {
        boolean[][] path = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (dfs(board, word, path, i, j, 0))
                    return true;
        return false;
    }

    public static boolean dfs(char[][] board, String word, boolean[][] path, int row, int col, int i) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length)
            return false;
        if (path[row][col])
            return false;
        if (i >= word.length())
            return false;
        if (board[row][col] != word.charAt(i))
            return false;
        if (i == word.length() - 1)
            return true;
        path[row][col] = true;
        boolean res = dfs(board, word, path, row, col - 1, i + 1) ||
                dfs(board, word, path, row - 1, col, i + 1) ||
                dfs(board, word, path, row, col + 1, i + 1) ||
                dfs(board, word, path, row + 1, col, i + 1);
        path[row][col] = false;
        return res;
    }
}

// ! Target Min -> 3 , Max -> 5 (Quality Problems Only)
// 1. LC79. Word Search ✅
// 2. LC416. Partition Equal Subset Sum ❌