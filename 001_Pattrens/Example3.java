package Numbers;

public class Example1 {
    public static void pyramid(int n) {
        for (int row = 0; row <= n; row++) {
            int ctr = row + 1;
            for (int space = 0; space < n - row; space++) {
                System.out.print("  ");
            }
            for (int col = 0; col < (row * 2) + 1; col++) {
                System.out.print(ctr + " ");
                if (col < (row * 2)) {
                    ctr--;
                } else {
                    ctr++;
                }
            }
            System.out.println();
        }
    }

    public static void pascal(int n) {
        for (int row = 0; row < n; row++) {
            int curr = 1;
            for (int space = 0; space < n - row - 1; space++) {
                System.out.print(" ");
            }
            for (int col = 0; col < row + 1; col++) {
                System.out.print(curr + " ");
                curr = curr * (row - col) / (col + 1);
            }
            System.out.println();
        }
    }

    public static void square(int n) {
        int orgN = n;
        n = n * 2;
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= n; col++) {
                int num = orgN - Math.min(Math.min(row, col), Math.min(n - col, n - row));
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}
