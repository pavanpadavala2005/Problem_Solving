
public class Demo {
        private static void printMatrix(int[][] matrix) {
                int rows = matrix.length;
                int cols = matrix[0].length;
                for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++)
                                System.out.print(matrix[i][j] + " ");
                        System.out.println();
                }
        }

        public static void main(String[] args) {
                // ! June07 Stuff
                // June07.basicMatrixWithInput(4);

                // June07.printMatrix(
                // new int[][] {
                // new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                // new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                // new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                // new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                // new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                // new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                // new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                // });

                // int[][][] threeDMatrix = new int[][][] {
                // new int[][] {
                // new int[] { 1, 2, 3 },
                // new int[] { 3, 4, 5 },
                // }
                // };

                // System.out.println(Arrays.toString(threeDMatrix[0][0]));

                // June07.threeDMatrixPrint();

                // June07.jaggedArrays();
                // System.out.println(
                // Arrays.toString(June07.sumOfEachRow(
                // new int[][] {
                // new int[] { 1, 2, 3 },
                // new int[] { 4, 5, 6 },
                // new int[] { 7, 8, 9 },
                // })));

                // System.out.println(Arrays.toString(
                // June07.sumOfEachColumn(
                // new int[][] {
                // new int[] { 1, 1, 1, 1, 1 },
                // new int[] { 1, 1, 1, 1, 1 },
                // new int[] { 1, 1, 1, 1, 1 },
                // })));

                // System.out.println(June07.diagonalSum(
                // new int[][] { new int[] { 1, 1, 1 },
                // new int[] { 1, 1, 1 },
                // new int[] { 1, 1, 1 } }));

                // System.out.println(
                // Arrays.deepToString(
                // June07.transposeMatrix(
                // new int[][] {
                // new int[] { 1, 4 },
                // new int[] { 2, 5 },
                // new int[] { 3, 6 }
                // })));

                // System.out.println(Arrays.deepToString(
                // June07.addTwoMatrix(
                // new int[][] {
                // new int[] { 1, 4 },
                // new int[] { 2, 5 },
                // new int[] { 3, 6 }
                // },
                // new int[][] {
                // new int[] { 1, 4 },
                // new int[] { 2, 5 },
                // new int[] { 3, 6 }
                // })));

                // printMatrix(June07.setMatrixZeros(new int[][] {
                // new int[] { 0, 1, 2, 0 },
                // new int[] { 3, 4, 5, 2 },
                // new int[] { 1, 3, 1, 5 }
                // // new int[] { 1, 1, 1 },
                // // new int[] { 1, 0, 1 },
                // // new int[] { 1, 1, 1 }
                // }));

                // printMatrix(June07.rotateMatrix90Degree(
                // new int[][] {
                // new int[] { 1, 2, 3 },
                // new int[] { 4, 5, 6 },
                // new int[] { 7, 8, 9 },
                // }));

                // System.out.println(Integer.MAX_VALUE * 8);

                // June09.spiralMatrix(new int[][] {
                // new int[] { 1, 2, 3 },
                // new int[] { 4, 5, 6 },
                // new int[] { 7, 8, 9 }
                // });
                // June09.spiralMatrix(new int[][] {
                // new int[] { 1, 2, 3, 4, 5, 6 },
                // new int[] { 20, 21, 22, 23, 24, 7 },
                // new int[] { 19, 32, 33, 34, 25, 8 },
                // new int[] { 18, 31, 36, 35, 26, 9 },
                // new int[] { 17, 30, 29, 28, 27, 10 },
                // new int[] { 16, 15, 14, 13, 12, 11 }

                // new int[] { 1, 2, 3, 4 },
                // new int[] { 5, 6, 7, 8 },
                // new int[] { 9, 10, 11, 12 },
                // });

                // System.out.println(June09.pascalValue(5, 3));

                // June09.pascalRow(5);

                // System.out.println(June09.ncr(10, 1));

                // June09.pascalRow(5);
                // System.out.println(June09.ncr(10, 2));
                // June09.pascalRow1(6);
                // June09.pascalTriangle(6)
                //

                //

                // June10 Stuff
                // System.out.println(June10.pascalTriangleCompute(5));
                // System.out.println();
                // System.out.println(June11.subarraySum(new int[] { 1 }, 0));\

                // ! July 13 Stuff
                // System.out.println(July13.firstOccurance(new int[] { 0 }, 1));
                // System.out.println(July13.SearchIn2DMatrixOptimal(
                // new int[][] {
                // new int[] { 1, 2, 3, 4, 5 },
                // new int[] { 6, 7, 8, 9, 10 },
                // new int[] { 11, 12, 13, 14, 15 },
                // }, 90));

                // ! July 14 Stuff

                // System.out.println(July14.countOnes(new int[] { 1, 0 }));

                // System.out.println(Arrays.toString(
                // July14.rowAndMaximumOnes(new int[][] {
                // new int[] { 0, 1 },
                // new int[] { 1, 0 }
                // })));
                // System.out.println(July14.SearchIn2DMatrixIIOptimal(
                // new int[][] {
                // new int[] { 1, 4, 7, 11, 15 },
                // new int[] { 2, 5, 8, 12, 19 },
                // new int[] { 3, 6, 9, 16, 22 },
                // new int[] { 10, 13, 14, 17, 24 },
                // new int[] { 18, 21, 23, 26, 30 },
                // new int[] { 19, 24, 29, 30, 35 },
                // new int[] { 20, 25, 32, 34, 40 },
                // new int[] { 1, 2 },
                // new int[] { 1 },
                // new int[] { 3 },
                // new int[] { 5 },
                // }, 30));

                // System.out.println(
                // July14.getLeft(new int[][] {
                // new int[] { 1, 2, 3, 4 },
                // new int[] { 5, 6, 7, 8 },
                // new int[] { 9, 10, 11, 12 },
                // new int[] { 13, 14, 15, 16 }
                // }, 1, 1));

                // System.out.println(Arrays.toString(
                // July14.findPeakGrid(new int[][] {
                // new int[] { 4, 2, 5, 1, 4, 5 },
                // new int[] { 2, 9, 3, 2, 3, 2 },
                // new int[] { 1, 7, 6, 0, 1, 3 },
                // new int[] { 3, 6, 2, 3, 7, 2 },
                // new int[] { 4, 7, 3, 2, 1, 4 },
                // })));

                // System.out.println(Arrays.toString(
                // July14.MedianOfSortedArraysBrute(
                // new int[] { 1, 2 },
                // new int[] { 3, 4 })));
                // System.out.println(July14.MedianOfSortedArraysOptimal(
                // new int[] { 1, 2 },
                // new int[] { 4, }
                // new int[] { 3, 5, 6, 12, 15 },
                // new int[] { 3, 4, 6, 10, 10, 12 }));

                // System.out.println(Arrays.toString(
                // July15.rowWithMax1s(
                // new int[][] {
                // new int[] { 0, 1, 1, 1 },
                // new int[] { 0, 0, 1, 1 },
                // new int[] { 0, 1, 1, 1 },
                // new int[] { 0, 0, 0, 1 },
                // })));

                // System.out.println(July15.kThElementOfSortedArrays(
                // new int[] {
                // // 2, 3, 6, 7, 9
                // 1, 4, 8, 10, 12
                // },
                // new int[] {
                // 1, 4, 8, 10
                // 5, 7, 11, 15, 17
                // },
                // 6));
                // System.out.println(
                // July15.upperBound(new int[] {
                // 1, 5, 7, 9, 11
                // }, 7));

                System.out.println(July15.medianOfMatrix(
                                new int[][] {
                                                new int[] { 1, 5, 7, 9, 11 },
                                                new int[] { 2, 3, 4, 5, 10 },
                                                new int[] { 9, 10, 12, 14, 16 },
                                }));
        }
}