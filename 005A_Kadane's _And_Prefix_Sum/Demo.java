
public class Demo {

    public static void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }

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
        // printMatrix(
        //         Oct17.computeBeforeMatrix(

        //                 Oct17.generatePrefixMatrix(
        //                         new int[][] {
        //                                 new int[] { 1, 2, 3 },
        //                                 new int[] { 4, 5, 6 },
        //                                 new int[] { 7, 8, 9 }
        //                         }
        //                 // 
        //                 )));

        // ! ============= Oct 18 Problems =============
        // printMatrix(Oct18.matrixBlockSum(
        //         new int[][] {
        //                 new int[] { 1, 2, 3, 4, 5 },
        //                 new int[] { 2, 1, 2, 1, 2 },
        //                 new int[] { 3, 2, 1, 2, 3 },
        //                 new int[] { 4, 1, 2, 3, 1 },
        //                 new int[] { 5, 2, 3, 1, 2 }
        //         }, 1));

        // System.out.println(Arrays.toString(Oct18.productExceptSelf(new int[] {
        // 2, 3, 4, 5
        // 
        // })));

        System.out.println(Oct18.checkSubarraySum(new int[] {
                // 23, 2, 4, 6, 7
                // 23, 2, 6, 4, 7
                5, 0, 0, 0

        },
                3
        // 6
        // 13
        // 
        ));

    }
}