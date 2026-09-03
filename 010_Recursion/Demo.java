
public class Demo {
    public static void printMatrix(char[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // ! ============= Aug 23 Problems ============

        // System.out.println(Aug23.fib(10));

        // Aug23.printTo1(10);

        // String s = "abcdcba";
        // System.out.println(Aug23.isPalindrome(s, 0, s.length() - 1));

        // ! ============= Aug 24 Problems ============
        // Aug24.printName(5, "Pavan");
        // System.out.println(Aug24.sumOfNumber(5));

        // int[] arr = new int[] { 1, 2, 3, 4, 4, 5, 6, 7, 8 };
        // System.out.println(Arrays.toString(arr));
        // Aug24.reverseArray(arr, 0, arr.length - 1);
        // System.out.println(Arrays.toString(arr));

        // System.out.println(Arrays.toString(Aug24.reverseArrayFunctional(
        // new int[] { 1, 2, 3, 4 },
        // 0
        // //
        // )));

        // System.out.println(Aug24.isPalindromeBetter(
        // "AmmA",
        // 0
        // //
        // ));

        // System.out.println(Aug24.reverseNumberMethod3(10));

        // System.out.println(Aug24.nthFibonacci(5));

        // int[] arr = new int[] { 3, 1, 2 };
        // ArrayList<Integer> res = Aug24.printSubSets(arr, 0, new ArrayList<>());
        // System.out.println("Res -->" + res);
        // System.out.println(Aug24.printSubSets Functional(arr, 0, new ArrayList<>()));

        // ! ============= Aug 25 Problems ============
        // Aug24.printSubSets(
        // new int[] { 3, 1, 2 },
        // 0,
        // new ArrayList<>()
        // //
        // );

        // System.out.println(Aug25.numSubseqHelper(
        // new int[] { 14, 4, 6, 6, 20, 8, 5, 6, 8, 12, 6, 10, 14, 9, 17, 16, 9, 7, 14,
        // 11, 14, 15, 13, 11, 10, 18,
        // 13, 17, 17, 14, 17, 7, 9, 5, 10, 13, 8, 5, 18, 20, 7, 5, 5, 15, 19, 14 },
        // 22,
        // 0,
        // new ArrayList<>()
        // //
        // ));

        // Aug25.printSubSequencesK(
        // new int[] { 1, 2, 1 },
        // 0,
        // 2,
        // new ArrayList<>(),
        // 0
        // //
        // );

        // int[] nums = new int[] {
        // // 3, 3, 6, 8
        // 2, 3, 3, 4, 6, 7
        // };
        // int target = 12;
        // System.out.println(
        // Aug25.numSubseqHelperV2(
        // nums,
        // 0,
        // new ArrayList<>(),
        // target,
        // -1,
        // Integer.MAX_VALUE
        // //
        // ));

        // int ans = Aug25.countSubSequencesSumToK(
        // new int[] { 2, 1, 1, 2 },
        // 0,
        // 2,
        // 0
        // //
        // );
        // System.out.println(ans);
        // int[] arr = new int[] { 9, 4, 3, 1, 2 };
        // Aug25.mergeSot(arr, 0, arr.length - 1);

        // int[] arr = new int[] {
        // 9, 4, 3, 1, 2
        // };
        // int[] res = Aug25.merge(
        // arr,
        // 0,
        // arr.length / 2,
        // arr.length - 1
        // //
        // );

        // Aug25.mergeSot(arr, 0, arr.length - 1);
        // System.out.println(Arrays.toString(
        // // res
        // arr
        // //
        // ));

        // ! ============== Aug 27 Problems =============
        // System.out.println(Aug27.recV2(
        // new int[] { 2, 3, 5 },
        // 0,
        // 8,
        // new ArrayList<>()
        // //
        // ));

        // Aug27.printCombo(
        // new int[] { 2, 3, 6 },
        // 0,
        // new ArrayList<>()
        // //
        // );

        // System.out.println(Aug27.combinationSum(
        // new int[] { 2, 3, 6, 7 },
        // 7
        // //
        // ));
        // Aug27.combinationSum2HelperV1(
        // new int[] { 2, 5, 2, 1, 2 },
        // 0,
        // 5,
        // new ArrayList<>(),
        // new ArrayList<>()
        // //
        // );
        // System.out.println(Aug27.combinationSum2(
        // new int[] { 2, 5, 2, 1, 2 },
        // 5
        // //
        // ));

        // System.out.println(Aug27.combinationSum2Better(
        // new int[] {
        // 10, 1, 2, 7, 6, 1, 5
        // 2, 5, 2, 1, 2
        // 1, 1, 1, 2, 2
        // },
        // 8
        // 5
        // 4
        //
        // ));

        // ! ============== Aug 28 Problems =============
        // System.out.println(Aug28.myPowRec(
        // 2.0d,
        // 10
        // 2.0d,
        // -2
        //
        // ));

        // System.out.println(Aug28.climbStairsItr(
        // // 3
        // // 4
        // 6
        // //
        // ));

        // System.out.println(Aug28.rob(new int[] {
        // // 1, 2, 3, 1
        // // 2, 7, 9, 3, 1
        // 2, 7, 9, 3, 1, 8, 4, 6, 5
        // }
        // //
        // ));
        // ! ============== Aug 29 Problems =============
        // System.out.println(Aug29.findMedianSortedArrays(
        // new int[] { 1, 3 },
        // new int[] { 2, 4 }
        // //
        // ));

        // ArrayList<Integer> res = Aug29.returnOneSubSequence(
        // new int[] { 1, 2, 1 },
        // 0,
        // new ArrayList<>(),
        // 2
        // //
        // );
        // System.out.println(res);

        // Aug29.combinationSumII(
        // new int[] {
        // 10, 1, 2, 7, 6, 1, 5
        // },
        // 8
        // //
        // );

        // ! ============== Aug 30 Problems =============

        // System.out.println(Aug30.subsetSums(
        // new int[] { 2, 3 }
        // //
        // ));

        // System.out.println(Aug30.perfectSum(
        // new int[] {
        // 3, 34, 4, 12, 5, 2
        // 1, 2, 3
        // 5, 2, 3, 10, 6, 8
        // 2, 5, 1, 4, 3
        // },
        // // 6
        // // 9
        // 10
        // //
        // ));

        // System.out.println(Aug30.perfectSum(
        // new int[] { 0, 10, 0 },
        // 0
        // //
        // ));
        // List<List<Integer>> res = Aug30.subsetsWithDup(
        // new int[] {
        // // 1, 2, 2, 3, 3
        // 1, 5, 6
        // });

        // res.sort((a, b) -> Integer.compare(a.size(), b.size()));
        // System.out.println(
        // res
        //
        // );
        // System.out.println(Aug30.permute(
        // new int[] {
        // 1, 2, 3
        // }
        // //
        // ));

        // ! ============== Aug 31 Problems =============

        // System.out.println(Aug31.uniquePerms(
        // new int[] { 1, 3, 3 }
        // //
        // ));

        // System.out.println(Aug31.permutation(
        // new String("ABC")
        // //
        // ));

        // System.out.println(Aug31.findPermutation(new String(
        // "AABC"
        // //
        // )));

        // System.out.println(Aug31.uniquePaths(
        // 3,
        // 7
        // //
        // ));

        // ! ============== Sep 01 Problems =============
        // System.out.println(Sep01.canWePlaceQueen(
        // new char[][] {
        // new char[] { '.', '.', '.', '.' },
        // new char[] { 'Q', '.', '.', '.' },
        // new char[] { '.', '.', '.', '.' },
        // new char[] { '.', '.', '.', '.' }
        // },
        // 1, 3
        // //
        // ));
        //
        // System.out.println(Sep01.solveNQueens(4));
        // int n = 6;
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // System.out.print((n + i - j - 1) + " ");
        // }
        // }
        // System.out.println(Sep01.solveNQueensOptimal(4));
        // ! ============== Sep 02 Problems =============

        // char[][] board = new char[][] {
        // new char[] { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
        // new char[] { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
        // new char[] { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
        // new char[] { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
        // new char[] { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
        // new char[] { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
        // new char[] { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
        // new char[] { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
        // new char[] { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        // };

        // Sep02.solveSudoku(board);

        // System.out.println(Sep02.canWePlaceNumber(
        // board,
        // 2,
        // 5,
        // '2'
        // //
        // ));

        // Sep02.solveSudoku(board);

        // printMatrix(board);

        int[][] maze1 = new int[][] {
                new int[] { 1, 0, 0, 0 },
                new int[] { 1, 1, 0, 1 },
                new int[] { 1, 1, 0, 0 },
                new int[] { 0, 1, 1, 1 } };
        // int row = 2;
        // int col = 0;
        // System.out.println(Sep02.isPossible(maze, row, col + 1));
        // int[][] maze2 = new int[][] {
        // new int[] { 1, 1, 1, 1 },
        // new int[] { 1, 0, 1, 1 },
        // new int[] { 1, 0, 1, 1 },
        // new int[] { 1, 1, 1, 1 },
        // };

        // int[][] maze3 = {
        // new int[] { 0, 1, 1 },
        // new int[] { 1, 1, 1 },
        // new int[] { 1, 1, 1 }
        // };

        // System.out.println(Sep03.ratInMaze(maze1));

        // ! ============== Sep 03 Problems =============
        // System.out.println(Sep03.ratInMaze(maze3));

        // int[][] grid = new int[][] {
        // new int[] { 0, 0, 0 },
        // new int[] { 0, 0, 0 },
        // new int[] { 0, 0, 0 }
        // };
        // int[][] grid = new int[][] {
        // new int[] { 1, 0 }
        // };
        // System.out.println(Sep03.uniquePathsWithObstacles(grid, 0, 0));

        // Sep03.uniquePathsWithObstaclesBrute(
        // new int[][] {
        // new int[] { 1 }
        // }
        // //
        // );
        // System.out.println(Sep03.countGoodNumbers(
        // 2
        //
        // ));

        // System.out.println(1 << 2);

        // System.out.println(Sep03.calcPower(3, 1));

        System.out.println(Sep03.countGoodNumbers(
                3
        //
        ));
    }
}