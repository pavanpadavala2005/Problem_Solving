public class Demo {
    public static void main(String[] args) {
        // ! ============= Oct 17 Problems =============
        // System.out.println(Oct17.subarraySum(new int[] {
        //         1, 1, 1
        // }, 2
        // 
        // ));

        // printMatrix(Oct17.generateSuffixMatrix(
        //         new int[][] {
        //                 new int[] { 1, 2, 3 },
        //                 new int[] { 4, 5, 6 },
        //                 new int[] { 7, 8, 9 }
        //         }
        // // 
        // ));
        printMatrix(
                Oct17.computeBeforeMatrix(

                        Oct17.generatePrefixMatrix(
                                new int[][] {
                                        new int[] { 1, 2, 3 },
                                        new int[] { 4, 5, 6 },
                                        new int[] { 7, 8, 9 }
                                }
                        // 
                        )));

    }

    public static void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }
}