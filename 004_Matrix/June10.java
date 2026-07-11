
import java.util.ArrayList;
import java.util.List;

public class June10 {
    private static int factorial(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++)
            res *= i;
        return res;
    }

    public static int ncrBrute(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    // ! Optimal Way of Finding NCR
    public static int ncrOptimised(int n, int r) {
        int res = 1;
        for (int i = 0; i < r; i++) {
            res = (res * (n - i)) / (i + 1);
            // res = res * (n - i);
            // res = res / (i + 1);
        }
        return res;
    }

    public static int pascalColValue(int row, int col) {
        return factorial(row) / (factorial(col) * factorial(row - col));
    }

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

    public static void pascalRowOptimised(int n) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0)
                res = (res * (n - i)) / i;
            // res = res / i;
            System.out.println(res);
        }
    }

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
