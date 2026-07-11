
public class Example2 {
    public static void hallowSquare(int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (col == 0 || row == 0 || col == n - 1 || row == n - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void hallowLeftIncrement(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || i == n - 1 || i == j)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static void hallowLeftDecrement(int n) {
        for (int i = 0; i < n; i++) {
            for (int space = 0; space < i; space++) {
                System.out.print("  ");
            }
            for (int j = 0; j < n - i - 1; j++) {
                if (j == 0 || i == 0 || j == n - i - 2)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static void invertedPyramid(int n) {
        // for (int row = 0; row < n; row++) {
        // for (int space = 0; space < row; space++) {
        // System.out.print(" ");
        // }
        // for (int col = 0; col < (n - row); col++) {
        // System.out.print("* ");
        // }
        // System.out.println();
        // }

        // Hallow

        for (int row = 0; row < n; row++) {
            for (int space = 0; space < row; space++) {
                System.out.print(" ");
            }
            for (int col = 0; col < (n - row); col++) {
                System.out.print((col == 0 || row == 0 || col == n - row - 1) ? "* " : "  ");
            }
            System.out.println();
        }
    }

    public static void pyramid(int n) {
        for (int row = 0; row < n; row++) {
            for (int space = 0; space < n - row - 1; space++) {
                System.out.print(" ");
            }
            for (int col = 0; col < row + 1; col++) {
                System.out.print(
                        (col == 0 || row == n - 1 || col == row) ? "* " : "  ");
            }
            System.out.println();
        }
    }

    public static void diamond(int n) {
        for (int row = 0; row < n - 1; row++) {
            for (int space = 0; space < n - row - 1; space++) {
                System.out.print(" ");
            }
            for (int col = 0; col < row + 1; col++) {
                System.out.print(
                        (col == 0 || row == n - 1 || col == row) ? "* " : "  ");
            }
            System.out.println();
        }
        for (int row = 0; row < n; row++) {
            for (int space = 0; space < row; space++) {
                System.out.print(" ");
            }
            for (int col = 0; col < (n - row); col++) {
                System.out.print((col == 0 || col == n - row - 1) ? "* " : "  ");
            }
            System.out.println();
        }
    }

    //
    //
    //
    //
    //
    //
    //
    //

    public static void plus(int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (n / 2 == row || n / 2 == col)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static void plusV2(int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int mid = n / 2;
                if (row == mid ||
                        col == mid ||
                        (row + col) / 2 == 0) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void matrix(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(String.format("[%d,%d]", i, j));
            }
        }
        System.out.println();
    }
}
