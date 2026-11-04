public class Nov04 {
    // ! ============= LC235. Lowest Common Ancestor of a Binary Search Tree
    // ============
    /*
    @ TC --> O(log N)
    @ SC --> O(H)
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        int xVal = p.val;
        int yVal = q.val;
        int rootVal = root.val;

        if ((xVal < yVal && yVal < rootVal) || (yVal < xVal && xVal < rootVal))
            return lowestCommonAncestor(root.left, p, q);

        else if ((xVal > yVal && yVal > rootVal) || (yVal > xVal && xVal > rootVal))
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }

    // ! ============= LC98. Validate Binary Search Tree ============
    /*
    @ TC --> O(log N)
    @ SC --> O(H)
     */
    public static boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isValidBSTHelper(TreeNode root, int minVal, int maxVal) {
        if (root == null)
            return true;

        boolean left = isValidBSTHelper(root.left, minVal, root.val);
        if (!left)
            return false;

        boolean right = isValidBSTHelper(root.right, root.val, maxVal);

        if (!right)
            return false;

        return minVal < root.val && root.val < maxVal;
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC98. Validate Binary Search Tree ✅
// 2. LC235. Lowest Common Ancestor of a Binary Search Tree ✅