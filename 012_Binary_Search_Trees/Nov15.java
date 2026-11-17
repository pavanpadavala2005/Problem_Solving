public class Nov15 {
    // ! ============= GFG. Largest BST Subtree ============
    // TODO: ON Hold
    public static int largestBst(TreeNode root) {
        if (root == null)
            return 0;
        int[] maxVal = new int[] { 0 };
        dfs(root, maxVal);
        return maxVal[0];
    }

    public static int dfs(TreeNode root, int[] maxVal) {
        if (root == null)
            return 0;

        int leftAns = dfs(root.left, maxVal);
        int rightAns = dfs(root.right, maxVal);

        if (rightAns == -1 || rightAns == -1)
            return -1;

        if (root.left != null && root.left.val >= root.val)
            return -1;
        if (root.right != null && root.right.val <= root.val)
            return -1;

        int sum = leftAns + rightAns + 1;

        maxVal[0] = Math.max(maxVal[0], sum);

        return sum;
    }
}
// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
