import java.util.*;

public class Sep01 {
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
        for (int i = 0; i < mat.length; i++)
            if ((mat[row][i] == 'Q') || (mat[i][col] == 'Q'))
                return false;
        int i = row, j = col;
        while (j >= 0 && i < mat.length)
            if (mat[i++][j--] == 'Q')
                return false;
        i = row;
        j = col;
        while (i >= 0 && j >= 0)
            if (mat[i--][j--] == 'Q')
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