
public class Oct23 {
    // ! ============= LC543. Diameter of Binary Tree ============
    static int maxDiameter = 0;

    public static int diameterOfBinaryTreeOptimal(TreeNode root) {
        // if (root == null)
        //     return 0;
        diameterUtilOptimal(root);
        return maxDiameter;
    }

    public static int diameterUtilOptimal(TreeNode root) {
        if (root == null)
            return 0;
        int lh = diameterUtilOptimal(root.left);
        int rh = diameterUtilOptimal(root.right);
        maxDiameter = Math.max(maxDiameter, lh + rh);
        return Math.max(rh, lh) + 1;
    }

    /*
    @ TC --> O(N * N)
    @ SC --> O(N) --> --> Auxiliary stack Space Ignorable
    */
    static int maxDia = 0;

    public static int diameterOfBinaryTreeBrute(TreeNode root) {
        if (root == null)
            return 0;

        diameterUtilBrute(root);
        return maxDia;
    }

    public static void diameterUtilBrute(TreeNode root) {
        if (root == null)
            return;
        int lh = height(root.left);
        int rh = height(root.right);
        maxDia = Math.max(maxDia, lh + rh);

        diameterUtilBrute(root.left);
        diameterUtilBrute(root.right);
    }

    // ! ============= LC110. Balanced Binary Tree ============
    /*
    @ TC --> O(N)
    @ SC --> O(N) --> Auxiliary stack Space Ignorable 
    */
    public static boolean isBalancedBetter(TreeNode root) {
        return calcHeight(root) != -1;
    }

    public static int calcHeight(TreeNode root) {
        if (root == null)
            return 0;
        int lh = calcHeight(root.left);
        int rh = calcHeight(root.right);
        if (lh == -1 || rh == -1)
            return -1;
        if (Math.abs(lh - rh) > 1)
            return -1;
        return Math.max(lh, rh) + 1;
    }

    /*
    @ TC --> O(N * N)
    @ SC --> O(N) --> Auxiliary stack Space Ignorable
    */
    public boolean isBalancedBrte(TreeNode root) {
        if (root == null)
            return true;
        int left = height(root.left);
        int right = height(root.right);

        if (Math.abs(left - right) > 1)
            return false;

        if (!isBalancedBrte(root.left) || !isBalancedBrte(root.right))
            return false;

        return true;
    }

    public static int height(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC110. Balanced Binary Tree  ✅
// 2. LC543. Diameter of Binary Tree ✅