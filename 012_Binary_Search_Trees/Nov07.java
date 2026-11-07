
public class Nov07 {
    // ! ============= LC109. Convert Sorted List to Binary Search Tree ============

    // TODO: PAUSED TILL 14 November
    // ! ============= GFG. Largest BST Subtree ============
    // TODO: PAUSED TILL 14 November
    static int maxVal = 0;

    public static int largestBst(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        return maxVal;
    }

    public static int dfs(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        int left = dfs(root.left);
        int right = dfs(root.right);

        maxVal = Math.max(1 + left + right, maxVal);

        if (root.left == null) {
            if (root.right.val > root.val)
                return 1 + right;
            return 0;
        }

        if (root.right == null) {
            if (root.left.val < root.val)
                return 1 + left;
            return 0;
        }

        if (root.right.val > root.val &&
                root.left.val < root.val)
            return 1 + left + right;
        return 0;
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
