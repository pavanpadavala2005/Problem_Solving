import java.util.*;

public class Sep01 {
    public static List<List<String>> solveNQueensOptimal(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] mat = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                mat[i][j] = '.';
        solveNQueensOptimal(mat,
                0,
                res,
                new boolean[2 * n - 1],
                new boolean[mat.length],
                new boolean[2 * n - 1]);
        return res;
    }

    public static void solveNQueensOptimal(char[][] mat,
            int col,
            List<List<String>> res,
            boolean[] leftTop,
            boolean[] left,
            boolean[] bottomDown)
    //
    {
        if (col >= mat.length) {
            List<String> lis = new ArrayList<>();
            for (char[] ch : mat)
                lis.add(new String(ch));
            res.add(lis);
            return;
        }

        for (int row = 0; row < mat.length; row++) {
            if (!left[row] && !leftTop[mat.length + row - col - 1] && !bottomDown[row + col])
            //
            {
                mat[row][col] = 'Q';
                leftTop[mat.length + row - col - 1] = true;
                left[row] = true;
                bottomDown[row + col] = true;
                solveNQueensOptimal(mat, col + 1, res, leftTop, left, bottomDown);
                mat[row][col] = '.';
                leftTop[mat.length + row - col - 1] = false;
                left[row] = false;
                bottomDown[row + col] = false;
            }
        }
    }

    // ! ============== LC51. N-Queens =============
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] mat = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                mat[i][j] = '.';
        solveNQueens(mat, 0, 0, res, n);
        return res;
    }

    // @ TC --> O(N^N) * O(N * O(3N)) * O(N * N) ==> O(N^N) --> recursion, O(N *
    // O(3N)) --> Inner loop + checking, O(N * N) --> converting char Array to
    // String and adding to Re
    // @ SC --> O(N^2) + O(ANS^2) ==> using a Matrix to find answer
    public static void solveNQueens(char[][] mat, int i, int j, List<List<String>> res, int count) {
        if (j >= mat.length) {
            if (count == 0) {
                List<String> lis = new ArrayList<>();
                for (char[] ch : mat)
                    lis.add(new String(ch));
                res.add(lis);
            }
            return;
        }
        for (int idx = 0; idx < mat.length; idx++) {
            if (canWePlaceQueen(mat, idx, j)) {
                mat[idx][j] = 'Q';
                solveNQueens(mat, idx, j + 1, res, count - 1);
                mat[idx][j] = '.';
            }
        }
    }

    // @ TC --> O(N) + O(N) + O(N) --> using 3 loops but not excatly O(3N) nut near
    // to O(3N)
    // @ SC --> O(1) Not using extra space
    public static boolean canWePlaceQueen(char[][] mat, int row, int col) {
        int i = row;
        int j = col;
        // left top
        while (i >= 0 && j >= 0)
            if (mat[i--][j--] == 'Q')
                return false;
        i = row;
        j = col;
        // left row
        while (j >= 0)
            if (mat[i][j--] == 'Q')
                return false;
        i = row;
        j = col;
        // left bottom
        while (j >= 0 && i < mat.length)
            if (mat[i++][j--] == 'Q')
                return false;
        return true;
    }

    public static void printMatrix(char[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }
}

// ! Target Min -> 3 , Max -> 5 (Quality Problems Only)
// 1. LC51. N-Queens ✅ -- took nearly 2 hrs