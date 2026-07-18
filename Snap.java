public class Snap {
    public static void main(String[] args) {
        printMatrix(new int[][] {
                new int[] { 1, 2, 3, 4, 5, 6 },
                new int[] { 1, 2, 3, 4, 5, 6 },
                new int[] { 1, 2, 3, 4, 5, 6 },
                new int[] { 1, 2, 3, 4, 5, 6 },
                new int[] { 1, 2, 3, 4, 5, 6 }
        });
    }

    public static void binarySearch() {
        int[] arr = { 1, 2, 2, 2, 3, 4 };
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= 2)
                high = mid - 1;
            else
                low = mid + 1;
            break;
        }
        System.out.println(low);
    }

    public static void printMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        System.out.print("  ");
        for (int k = 0; k < m; k++) {
            System.out.print(k + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < m; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void test() {
        int[][] mat = {
                { 1, 2, 3, 4, 5 },
                { 4, 5, 6, 7, 8 },
                { 7, 8, 9, 7, 8 },
                { 7, 6, 5, 4, 3 },
                { 9, 3, 6, 7, 4 },
        };
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i];
        }
        System.out.println(sum);

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i == j) {
                    System.out.println(mat[i][j]);
                }
            }
        }
    }
}