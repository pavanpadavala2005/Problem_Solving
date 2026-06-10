import java.util.*;

public class June07 {

    public static void basicMatrixWithInput(int n) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print("Input for " + "[" + row + col + "] : ");
                matrix[row][col] = sc.nextInt();
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void printMatrix(int[][] matrix) {
        // int rows = matrix.length;
        // int cols = matrix[0].length;
        // for (int i = 0; i < rows; i++) {
        // for (int j = 0; j < cols; j++)
        // System.out.print(matrix[i][j] + " ");
        // System.out.println();
        // }

        for (int[] row : matrix) {
            for (int col : row)
                System.out.print(col + " ");
            System.out.println();
        }
    }

    public static void threeDMatrixPrint() {
        int[][][] matrix = new int[][][] {
                new int[][] {
                        new int[] { 1, 2, 3 },
                        new int[] { 4, 5, 6 },
                        new int[] { 7, 8, 9 },
                },
                new int[][] {
                        new int[] { 10, 11, 12 },
                        new int[] { 13, 14, 15 },
                        new int[] { 16, 17, 18 },
                },
                new int[][] {
                        new int[] { 19, 20, 21 },
                        new int[] { 22, 23, 24 },
                        new int[] { 25, 26, 27 },
                }
        };

        int row = matrix.length;
        int col = matrix[0].length;
        int elems = matrix[0][0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < elems; k++) {
                    System.out.print(matrix[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void jaggedArrays() {
        int[][] matrix = new int[][] {
                new int[] { 1, 2, 3 },
                new int[] { 1 },
                new int[] { 1, 2, 3, 4, 5, 6 },
                new int[] { 0, 1, 2, 3, 4 },
        };
        int rows = matrix.length;
        for (int i = 0; i < rows; i++) {
            int cols = matrix[i].length;
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // ! Matrix Problems --> Very Basic Problems

    public static int[] sumOfEachRow(int[][] matrix) {
        int[] resArr = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
            }
            resArr[i] = sum;
        }
        return resArr;
    }

    public static int[] sumOfEachColumn(int[][] matrix) {
        int[] resArr = new int[matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix.length; j++) {
                sum += matrix[j][i];
            }
            resArr[i] = sum;
        }
        return resArr;
    }

    public static int diagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++)
            sum += matrix[i][i];
        return sum;
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] resMatrix = new int[cols][rows];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                resMatrix[j][i] = matrix[i][j];
        return resMatrix;
    }

    public static int[][] addTwoMatrix(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] resMatrix = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                resMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
        return resMatrix;
    }

    // ! Leet code problems Start Here

    // ! Leetcode - 73. Set Matrix Zeroes
    private static void setRows(int[][] matrix, int i) {
        for (int j = 0; j < matrix[0].length; j++)
            matrix[i][j] = -1;
    }

    private static void setCol(int[][] matrix, int j) {
        for (int i = 0; i < matrix.length; i++)
            matrix[i][j] = -1;
    }

    public static int[][] setMatrixZeros(int[][] matrix) {
        // ! Time Complexity is Somewhere around O(N3)
        // int rows = matrix.length;
        // int cols = matrix[0].length;
        // for (int i = 0; i < rows; i++) {
        // for (int j = 0; j < cols; j++) {
        // if (matrix[i][j] == 0) {
        // setRows(matrix, i);
        // setCol(matrix, j);
        // }
        // }
        // }
        // return matrix;

        // !Better Solution
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] colArr = new int[cols];
        int[] rowArr = new int[rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    colArr[j] = 1;
                    rowArr[i] = 1;
                }
            }
        }
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (rowArr[i] == 1 || colArr[j] == 1)
                    matrix[i][j] = 0;
        return matrix;
    }

    public static int[][] rotateMatrix90Degree(int[][] matrix) {
        // int n = matrix.length;
        // int[][] resMatrix = new int[n][n];
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // // resMatrix[j][n - i - 1] = matrix[i][j];
        // System.out.print(matrix[j][i]);
        // }
        // System.out.println();
        // }
        // return resMatrix;

        // ! We Can do Transpose of Matrix and Reverse Each Row
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        return matrix;
    }

}
