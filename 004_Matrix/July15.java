public class July15 {
    // ! ==================== FIND ROWS WITH MAX 1's OPTIMAL ====================
    public static int[] rowWithMax1s(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int i = 0;
        int j = n - 1;
        int rowIdx = -1;
        while (i < m && j >= 0) {
            if (mat[i][j] == 1) {
                rowIdx = i;
                j--;
            } else
                i++;
        }
        return new int[] { rowIdx };
    }
}
