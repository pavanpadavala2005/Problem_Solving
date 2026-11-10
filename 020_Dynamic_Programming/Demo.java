
public class Demo {
        public static void printMatrix(int[][] mat) {
                for (int i = 0; i < mat.length; i++) {
                        for (int j = 0; j < mat[i].length; j++)
                                System.out.print(mat[i][j] + " ");
                        System.out.println();
                }

        }

        public static void main(String[] args) {
                // ! ============= Nov 07 Problems =============
                // System.out.println(Nov07.fibOptimal(5));

                // System.out.println(Nov07.climbStairsBetterV2(4));

                // System.out.println(Nov07.minCostOptimal(
                // new int[] {
                // 20, 30, 40, 20
                // 20
                // 30, 20, 50, 10, 40
                // }));

                // HashMap<List, Integer> map = new HashMap<>();

                // map.put(new ArrayList<>(List.of(10, 20)), 30);
                // map.put(new ArrayList<>(List.of(10, 20)), 40);
                // map.put(new ArrayList<>(List.of(10, 20)), 50);

                // System.out.println(map);

                // ! ============= Nov 08 Problems =============

                // System.out.println(Nov08.frogJumpOptimal(
                //         new int[] {
                //                 // 10, 5, 20, 0, 15
                //                 10, 30, 40, 50, 20
                //         },
                //         3
                // // 2
                // // 
                // ));

                // System.out.println(Nov08.maximumNonAdjacentSumOptimal(
                //         new int[] {
                // 1, 2, 3, 1, 3, 5, 8, 1, 9
                // 1, 2, 3, 5, 4
                // 2, 1, 4, 9
                // 1, 9, 0, 10, 4, 20
                // 1, 2, 3, 1, 3, 5, 8, 1, 9
                // 
                // }));

                // ! ============= Nov 09 Problems =============
                // System.out.println(
                //         Nov09.coinChangeBetterV2(new int[] {
                //                 // 1, 2, 5
                //                 2
                //         },
                //                 //  11
                //                 3)
                // // 
                // );

                System.out.println(
                                Nov09.maximumPointsBetterV3(new int[][] {
                                                new int[] { 2, 5, 3 },
                                                new int[] { 6, 4, 1 },
                                                new int[] { 3, 7, 2 },
                                                new int[] { 4, 4, 9 }
                                }));
        }
}
