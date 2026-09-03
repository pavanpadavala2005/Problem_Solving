import java.util.*;

public class Sep03 {
    // ! ============== L1922. Count Good Numbers=============
    public static long calcPower(int a, int b, long MOD) {
        if (b == 0)
            return 1;
        long res = calcPower(a, b / 2, MOD);
        res = (res * res) % MOD;
        if (b % 2 != 0)
            res = (res * a) % MOD;
        return res;
    }

    public static int countGoodNumbers(long n) {
        long MOD = 1_000_000_007L;
        long res1 = calcPower(5, (int) (n - (n / 2)), MOD);
        long res2 = calcPower(4, (int) n / 2, MOD);
        return (int) (res1 * res2);
    }

    // ! ============== L63. Unique Paths II =============
    public static int uniquePathsWithObstaclesBrute(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    if (obstacleGrid[i][j] == 1)
                        dp[i][j] = 0;
                    else
                        dp[i][j] = 1;
                } else {
                    if (obstacleGrid[i][j] == 1)
                        dp[i][j] = 0;
                    else
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return uniquePathsWithObstacles(obstacleGrid, 0, 0);
    }

    public static int uniquePathsWithObstacles(int[][] grid, int row, int col) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            if (grid[row][col] == 0)
                return 1;
            return 0;
        }
        if (grid[row][col] == 1)
            return 0;
        int right = canRobotMove(grid, row, col + 1) && grid[row][col] != 1
                ? uniquePathsWithObstacles(grid, row, col + 1)
                : 0;
        int down = canRobotMove(grid, row + 1, col) && grid[row][col] != 1
                ? uniquePathsWithObstacles(grid, row + 1, col)
                : 0;
        return right + down;
    }

    public static boolean canRobotMove(int[][] grid, int row, int col) {
        if (row > grid.length - 1 || col > grid[0].length - 1 || grid[row][col] == 1)
            return false;
        return true;
    }

    // ! ============== GFG. Rat in a Maze =============
    // *https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
    public static ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> res = new ArrayList<>();
        ratInMaze(maze, 0, 0, new StringBuilder(), res);
        return res;
    }

    public static void ratInMaze(int[][] maze, int row, int col, StringBuilder sb, ArrayList<String> res) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            res.add(sb.toString());
            return;
        }
        // ! Down
        if (canMove(maze, row + 1, col) && maze[row][col] != 0) {
            maze[row][col] = 0;
            sb.append('D');
            ratInMaze(maze, row + 1, col, sb, res);
            sb.deleteCharAt(sb.length() - 1);
            maze[row][col] = 1;
        }
        // ! Left
        if (canMove(maze, row, col - 1) && maze[row][col] != 0) {
            maze[row][col] = 0;
            sb.append('L');
            ratInMaze(maze, row, col - 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
            maze[row][col] = 1;
        }
        // ! Right
        if (canMove(maze, row, col + 1) && maze[row][col] != 0) {
            maze[row][col] = 0;
            sb.append('R');
            ratInMaze(maze, row, col + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
            maze[row][col] = 1;
        }
        // ! Up
        if (canMove(maze, row - 1, col) && maze[row][col] != 0) {
            maze[row][col] = 0;
            sb.append('U');
            ratInMaze(maze, row - 1, col, sb, res);
            sb.deleteCharAt(sb.length() - 1);
            maze[row][col] = 1;
        }
    }

    public static boolean canMove(int[][] maze, int row, int col) {
        if (row < 0 || col < 0 || row > maze.length - 1 || col > maze[0].length - 1)
            return false;
        if (maze[row][col] == 0)
            return false;
        return true;
    }
}
// ! Target Min -> 3 , Max -> 5 (Quality Problems Only)
// 1. GFG. Rat in a Maze ✅
// 2.L63. Unique Paths II ❌ Dp Look in DP series

//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//

class Ignorable {
    // ! ============== L1922. Count Good Numbers=============
    public static int countGoodNumbersOptimal(long n, long MOD) {
        if (n == 0)
            return 1;

        if (n == 1)
            return 5;

        if (n == 2)
            return 20;
        int left = (int) (countGoodNumbersOptimal(n / 2, MOD) % MOD);
        int right = (int) (countGoodNumbersOptimal(n - (n / 2), MOD) % MOD);
        return left * right;
    }

    public static long countGoodNumbersBetter(long n) {
        return ((long) Math.pow(4, n / 2) * (long) Math.pow(5, n - n / 2));
    }

    public static long countGoodNumbersBrute(long n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0)
                res *= 5;
            else
                res *= 4;
            res = res % ((1 << 9) * 1953125 + 7);
        }
        return res;
    }

    public static int countGoodNumbers(long n, int idx) {
        int MOD = 1_000_000_007;
        if (idx == n) {
            return 1;
        }
        int val = 0;
        if (idx % 2 == 0) {
            int count = 0;
            for (char i : new char[] { '0', '2', '4', '6', '8' })
                count += countGoodNumbers(n, idx + 1) % MOD;
            val += count;
        } else {
            int count = 0;
            for (char i : new char[] { '2', '3', '5', '7' })
                count += countGoodNumbers(n, idx + 1) % MOD;
            val += count;
        }
        return val;
    }
}