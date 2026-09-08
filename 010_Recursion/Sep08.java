import java.util.Arrays;
public class Sep08 {
    // ! ============== LC3483. Unique 3-Digit Even Numbers =============
    public static int totalNumbers(int[] digits) {
        Arrays.sort(digits);
        return totalNumbers(digits, 0, new boolean[digits.length]);
    }

    public static int totalNumbers(int[] digits, int base, boolean[] track) {
        if (base >= 100 && base < 1000) {
            if (base % 2 == 0)
                return 1;
            return 0;
        }
        int ctr = 0;
        for (int i = 0; i < digits.length; i++) {
            if (track[i])
                continue;
            if (i > 0 && digits[i] == digits[i - 1] && !track[i - 1])
                continue;
            if (base == 0 && digits[i] == 0)
                continue;
            track[i] = true;
            base = base * 10 + digits[i];
            ctr += totalNumbers(digits, base, track);
            base = base / 10;
            track[i] = false;
        }
        return ctr;
    }

    // ! ============== GFG. Min Steps by Knight =============
    // * https://www.geeksforgeeks.org/problems/steps-by-knight5927/1
    public static int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        int[][] board = new int[n][n];
        return minStepToReachTarget(board, knightPos[0] - 1, knightPos[1] - 1, targetPos, 0);
    }

    public static int minStepToReachTarget(int[][] board, int row, int col, int[] target, int count) {
        if (row < 0 || col < 0 || row > board.length - 1 || col > board.length - 1)
            return Integer.MAX_VALUE;
        if (row == target[0] - 1 && col == target[1] - 1)
            return count;
        if (board[row][col] == 1)
            return Integer.MAX_VALUE;
        board[row][col] = 1;
        int min = Integer.MAX_VALUE;
        min = Math.min(min, minStepToReachTarget(board, row - 2, col - 1, target, count + 1));
        min = Math.min(min, minStepToReachTarget(board, row - 2, col + 1, target, count + 1));
        min = Math.min(min, minStepToReachTarget(board, row - 1, col + 2, target, count + 1));
        min = Math.min(min, minStepToReachTarget(board, row + 1, col + 2, target, count + 1));
        min = Math.min(min, minStepToReachTarget(board, row + 2, col + 1, target, count + 1));
        min = Math.min(min, minStepToReachTarget(board, row + 2, col - 1, target, count + 1));
        min = Math.min(min, minStepToReachTarget(board, row + 1, col - 2, target, count + 1));
        min = Math.min(min, minStepToReachTarget(board, row - 1, col - 2, target, count + 1));
        board[row][col] = 0;
        return min;
    }

    // ! ============== PERSONAL. The Knight's tour Generator =============
    // * PERSONAL
    public static int[][] knightTourGenerator(int n) {
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                board[i][j] = -1;
        }
        knightTourGenerator(board, 0, 0, 0);
        return board;
    }

    public static boolean knightTourGenerator(int[][] board, int row, int col, int count) {
        if (row < 0 || col < 0 || row > board.length - 1 || col > board.length - 1)
            return false;
        if (board[row][col] > 0)
            return false;
        board[row][col] = count;
        if (count == board.length * board.length - 1)
            return true;
        if (knightTourGenerator(board, row - 2, col - 1, count + 1))
            return true; // C1
        if (knightTourGenerator(board, row - 2, col + 1, count + 1))
            return true; // C3
        if (knightTourGenerator(board, row - 1, col + 2, count + 1))
            return true; // C5
        if (knightTourGenerator(board, row + 1, col + 2, count + 1))
            return true; // C7
        if (knightTourGenerator(board, row + 2, col + 1, count + 1))
            return true; // C8
        if (knightTourGenerator(board, row + 2, col - 1, count + 1))
            return true; // C6
        if (knightTourGenerator(board, row + 1, col - 2, count + 1))
            return true; // C4
        if (knightTourGenerator(board, row - 1, col - 2, count + 1))
            return true; // C2
        board[row][col] = 0;
        return false;
    }
}
// ! Target Min -> 3 , Max -> 5 (Quality Problems Only)
// 1. GFG. Min Steps by Knight ✅
// 2. LC3483. Unique 3-Digit Even Numbers ✅

//
//
//
//
// ! KNIGHT MOVEMENTS
// {
// {-2,-1} -> C1,
// {-2,+1} -> C3,
// {-1,+2} -> C5,
// {+1,+2} -> C7,
// {+2,+1} -> C8
// {+2,-1} -> C6,
// {+1,-2} -> C4,
// {-1,-2} -> C2,
// }