import java.util.*;

public class Sep02 {
    // ! ============== GFG. Rat in a Maze =============
    // *https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
    public static ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> res = new ArrayList<>();
        ratInMaze(maze, 0, 0, new ArrayList<>(), res);
        return res;
    }

    public static void ratInMaze(int[][] maze, int row, int col, ArrayList<Character> sb, ArrayList<String> res) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(sb);
            return;
        }
        if (isPossible(maze, row, col - 1)) {
            sb.add('L');
            maze[row][col] = 0;
            ratInMaze(maze, row, col - 1, sb, res);
            sb.remove(sb.size() - 1);
            maze[row][col] = 1;
        }
        if (isPossible(maze, row - 1, col)) {
            sb.add('T');
            maze[row][col] = 0;
            ratInMaze(maze, row - 1, col, sb, res);
            sb.remove(sb.size() - 1);
            maze[row][col] = 1;
        }
        if (isPossible(maze, row, col + 1)) {
            sb.add('R');
            maze[row][col] = 0;
            ratInMaze(maze, row, col + 1, sb, res);
            sb.remove(sb.size() - 1);
            maze[row][col] = 1;
        }
        if (isPossible(maze, row + 1, col)) {
            sb.add('D');
            maze[row][col] = 0;
            ratInMaze(maze, row + 1, col, sb, res);
            sb.remove(sb.size() - 1);
            maze[row][col] = 1;
        }
    }

    public static boolean isPossible(int[][] maze, int row, int col) {
        if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length)
            return false;
        if (maze[row][col] == 0)
            return false;
        return true;
    }
    // ! ============== LC37. Sudoku Solver =============
    // @ TC --> O(N*N) + ( O(9^emptySlots) * (O(3*3) + O(N)) ) --> because we are
    // creating a pos Arraylist and calling function

    // @ SC --> O(emptySlots * 2) + O(9^emptySlots) --> ignorable
    // --> we are storing [row,col] in Arraylist
    public static void solveSudoku(char[][] board) {
        int n = board.length;
        ArrayList<int[]> pos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                if (board[i][j] == '.')
                    pos.add(new int[] { i, j });
        }
        solveSudoku(board, pos, 0);
    }

    // @ TC --> O(9^emptySlots) * (O(3*3) + O(N)) --> for an example we have 50
    // empty slots and in every slot we need to check for 1 --> 9 like that for
    // every 50 and every time checking is possible or not --> O(3*3) + O(N) but not
    // always true but in one case it will go to O(9^emptySlots)

    // @ SC --> O(9^emptySlots) --> that is Recursive Stack Space negiligable
    public static boolean solveSudoku(char[][] board, ArrayList<int[]> pos, int idx) {
        if (idx >= pos.size()) {
            return true;
        }
        int row = pos.get(idx)[0];
        int col = pos.get(idx)[1];
        for (int i = '1'; i <= '9'; i++) {
            if (canWePlaceNumberBrute(board, row, col, (char) i)) {
                board[row][col] = (char) i;
                boolean isSolved = solveSudoku(board, pos, idx + 1);
                if (isSolved)
                    return true;
                board[row][col] = '.';
            }
        }
        return false;
    }

    // @ TC --> O(3*3) + O(N)
    // @ SC --> O(1)
    public static boolean canWePlaceNumberBetter(char[][] board, int row, int col, char val) {
        int x = row / 3;
        int y = col / 3;
        // ! Checking that BOX
        for (int i = 3 * x; i < 3 * (x + 1); i++)
            for (int j = 3 * y; j < 3 * (y + 1); j++)
                if (board[i][j] == val)
                    return false;
        for (int i = 0; i < board.length; i++) {

            // ! Check Row
            if (board[row][i] == val)
                return false;
            // ! Check Column
            if (board[i][col] == val)
                return false;
        }
        return true;
    }

    public static boolean canWePlaceNumberBrute(char[][] board, int row, int col, char val) {
        int x = row / 3;
        int y = col / 3;
        // ! Checking that box
        for (int i = 3 * x; i < 3 * (x + 1); i++)
            for (int j = 3 * y; j < 3 * (y + 1); j++)
                if (board[i][j] == val)
                    return false;
        // ! Check Left
        x = row;
        y = col;
        while (y >= 0)
            if (board[x][y--] == val)
                return false;
        // ! Check right
        x = row;
        y = col;
        while (y < board.length)
            if (board[x][y++] == val)
                return false;
        // ! Check top
        x = row;
        y = col;
        while (x >= 0)
            if (board[x--][y] == val)
                return false;
        // ! Check Bottom
        x = row;
        y = col;
        while (x < board.length)
            if (board[x++][y] == val)
                return false;
        return true;
    }
}

// ! Target Min -> 3 , Max -> 5 (Quality Problems Only)
// 1. LC37. Sudoku Solver ✅
// 2. GFG. Rat in a Maze