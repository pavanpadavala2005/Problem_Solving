
public class June09 {
    // ! =============== LC54. Spiral Matrix ================
    // @ TC --> O(R * C)
    // @ SC --> O(1)
    public static void spiralMatrix(int[][] matrix) {
        int top = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                System.out.println(matrix[top][i]);
            }
            top++;
            for (int j = top; j <= bottom; j++) {
                System.out.println(matrix[j][right]);
            }
            right--;
            for (int k = right; k >= left; k--) {
                System.out.println(matrix[bottom][k]);
            }
            bottom--;
            for (int l = bottom; l >= top; l--) {
                System.out.println(matrix[l][left]);
            }
            left++;
        }
    }
}