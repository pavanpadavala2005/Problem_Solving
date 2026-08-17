
import java.util.ArrayList;
import java.util.List;

public class June10 {
    private static int factorial(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++)
            res *= i;
        return res;
    }

    // ! =============== General. Calculate nCr ================
    // @ Time Complexity: O(N)
    // @ Space Complexity: O(1)
    public static int ncrBrute(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    // ! Optimal Way of Finding NCR

    // @ Time Complexity: O(R)
    // @ Space Complexity: O(1)
    public static int ncrOptimised(int n, int r) {
        int res = 1;
        for (int i = 0; i < r; i++) {
            res = (res * (n - i)) / (i + 1);
            // res = res * (n - i);
            // res = res / (i + 1);
        }
        return res;
    }

    // @ Time Complexity: O(Row)
    // @ Space Complexity: O(1)
    public static int pascalColValue(int row, int col) {
        return factorial(row) / (factorial(col) * factorial(row - col));
    }

    // ! =============== General. Print a Row of Pascal's Triangle ================
    // @ Time Complexity: O(Row^2)
    // @ Space Complexity: O(1)
    public static void pascalRow(int row) {
        // ! NOrmal Way of Finding Each Row
        // int col;
        // for (int i = 0; i < row + 1; i++) {
        // if (i <= row / 2)
        // col = i;
        // else
        // col = row - i;
        // System.out.println(pascalValue(row, col));
        // }

        // ! Optimized Way
        for (int i = 1; i <= row; i++) {
            System.out.println(ncrOptimised(row - 1, i - 1));
        }
    }

    // @ Time Complexity: O(N)
    // @ Space Complexity: O(1)
    public static void pascalRowOptimised(int n) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0)
                res = (res * (n - i)) / i;
            // res = res / i;
            System.out.println(res);
        }
    }

    // ! =============== LC 118. Pascal's Triangle ================
    // @ Time Complexity: O(N^2)
    // @ Space Complexity: O(1), excluding printed output
    public static void pascalTriangle(int n) {
        // ! normal Way Using NCR
        // for (int row = 0; row < n; row++) {
        // for (int i = 0; i < n - row; i++) {
        // System.out.print(" ");
        // }
        // for (int col = 0; col < row + 1; col++) {
        // System.out.print(ncr(row, col) + " ");
        // }
        // System.out.println();
        // }
        for (int i = 1; i <= n + 1; i++) {
            int res = 1;
            for (int j = 0; j < i; j++) {
                if (j > 0)
                    res = (res * (i - j)) / j;
                System.out.print(res + " ");
            }
            System.out.println();
        }

    }

    // @ Time Complexity: O(N^2)
    // @ Space Complexity: O(N^2)
    public static ArrayList<ArrayList<Integer>> pascalTriangleCompute(int n) {
        ArrayList<ArrayList<Integer>> resArr = new ArrayList<>();
        for (int i = 1; i <= n + 1; i++) {
            int res = 1;
            ArrayList<Integer> inner = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j > 0)
                    res = (res * (i - j)) / j;
                inner.add(res);
            }
            resArr.add(inner);
        }
        return resArr;
    }

    // ! =============== LC 119. Pascal's Triangle II ================
    // @ Time Complexity: O(RowIndex)
    // @ Space Complexity: O(RowIndex)
    public List<Integer> getRow(int rowIndex) {
        List<Integer> resArr = new ArrayList<>();
        int res = 1;
        for (int i = 0; i <= rowIndex; i++) {
            if (i > 0)
                res = (res * (rowIndex - i)) / i;
            resArr.add(res);
        }
        return resArr;
    }

}
