public class Example1 {
    public static void leftIncrement(int n) {
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < i + 1; j++) {
        // System.out.print("* ");
        // }
        // System.out.println();
        // }

        // for (int i = 0; i < n; i++) {
        // System.out.println("# ".repeat(i + 1));
        // }

        // for (int i = 1; i <= n; i++) {
        // for (int j = 1; j <= i; j++) {
        // System.out.print("# ");
        // }
        // System.out.println();
        // }

        // for (int i = n; i > 0; i--) {
        // for (int j = n - i + 1; j > 0; j--) {
        // System.out.print(i + " ");
        // }
        // System.out.println();
        // }

        for (int i = n; i > 0; i--) {
            System.out.println((i + " ").repeat(n - i + 1));
        }
    }

    public static void leftDecrement(int n) {
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n - i; j++) {
        // System.out.print("* ");
        // }
        // System.out.println();
        // }

        for (int i = n; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void rightDecrement(int n) {
        // for (int row = 0; row < n; row++) {
        // for (int space = 0; space < row; space++) {
        // System.out.print(" ");
        // }
        // for (int col = 0; col < n - row; col++) {
        // System.out.print("* ");
        // }
        // System.out.println();
        // }
        for (int row = n; row > 0; row--) {
            for (int space = n; space > row; space--)
                System.out.print("  ");
            for (int col = n; col > n - row; col--)
                System.out.print("* ");
            System.out.println();
        }
    }

    public static void rightIncrement(int n) {
        // for (int row = 0; row < n; row++) {
        // for (int space = 0; space < (n - row - 1); space++)
        // System.out.print(" ");
        // for (int col = 0; col < row + 1; col++)
        // System.out.print("* ");
        // System.out.println();
        // }

        for (int i = n; i > 0; i--) {
            for (int j = n; j > n - i + 1; j--)
                System.out.print("  ");
            for (int k = n; k > i - 1; k--)
                System.out.print("* ");
            System.out.println();
        }
    }

    public static void leftSideTriangle(int n) {
        int target = 0;
        for (int row = 0; row < n * 2; row++) {
            target += (row < n ? 1 : -1);
            for (int col = 0; col < target; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // int target = 0;
        // for (int row = 1; row <= (n * 2); row++) {
        // target = (row > n) ? (2 * n) - row : row;
        // for (int col = 1; col <= target; col++) {
        // System.out.print("* ");
        // }
        // System.out.println();
        // }
    }

    public static void rightTriangle(int n) {
        int target = 0;
        int spaces = n;
        for (int row = 0; row < (2 * n); row++) {
            if (row < n) {
                target++;
                spaces--;
            } else {
                target--;
                spaces++;
            }
            for (int space = 0; space < spaces; space++) {
                System.out.print("  ");
            }
            for (int col = 0; col < target; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }

    public static void topTriangle(int n) {
        for (int row = 0; row < n; row++) {
            // System.out.println("Row : " + row + " Columns : " + ((2 * n) - (2 * row) -
            // 1));
            for (int space = 0; space < row; space++) {
                System.out.print("  ");
            }
            for (int col = 0; col < ((2 * n) - (2 * row) - 1); col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void bottomTriangle(int n) {
        for (int row = 0; row < n; row++) {
            for (int space = 0; space < (n - row - 1); space++) {
                System.out.print("  ");
            }
            for (int col = 0; col < (2 * row) + 1; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void diamond3(int n) {
        int target = 0;

        for (int row = 0; row < 2 * n - 1; row++) {

            if (row < n)
                target++;
            else
                target--;

            for (int space = 0; space < n - target; space++) {
                System.out.print("  ");
            }

            for (int col = 0; col < 2 * target - 1; col++) {
                System.out.print("# ");
            }

            System.out.println();
        }
    }

}
