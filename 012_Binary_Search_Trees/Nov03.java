public class Nov03 {

    // ! ============= GFG. Kth Largest in BST ============

    /*
    @ TC --> O(log N)
    @ SC --> O(H)
    */
    static int largerVal = -1;

    public static int kthLargest(TreeNode root, int k) {
        if (root == null)
            return largerVal;

        int[] ctr = new int[] { 0 };

        dfs(root, k, ctr);
        return largerVal;
    }

    public static void dfs(TreeNode root, int k, int[] ctr) {
        if (root == null)
            return;

        dfs(root.right, k, ctr);

        ctr[0] += 1;
        if (ctr[0] == k)
            largerVal = root.val;
        if (largerVal != -1)
            return;

        dfs(root.left, k, ctr);
    }

    // ! ============= LC230. Kth Smallest Element in a BST ============
    /*
    @ TC --> O(N)
    @ SC --> O(H)
     */
    static int smallVal = -1;

    public static int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return smallVal;
        int[] ctr = new int[] { 0 }; // Counter Reference Variable
        kthSmallestHelper(root, k, ctr);
        return smallVal;
    }

    public static void kthSmallestHelper(TreeNode root, int k, int[] ctr) {
        if (root == null || ctr[0] > k)
            return;
        kthSmallestHelper(root.left, k, ctr);
        ctr[0] += 1;
        if (ctr[0] == k)
            smallVal = root.val;

        if (smallVal != -1)
            return; // If we already found Don't Check anything

        kthSmallestHelper(root.right, k, ctr);
    }

    // ! ============= LC450. Delete Node in a BST ============
    /*
    @ TC --> O(Log N + H)
    @ SC --> O(H)
     */
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (key < root.val)
            root.left = deleteNode(root.left, key);
        else if (key > root.val)
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;

            int minVal = findMin(root.right);
            root.val = minVal;
            root.right = deleteNode(root.right, minVal);
        }
        return root;
    }

    public static int findMin(TreeNode root) {
        if (root == null)
            return -1;
        TreeNode curr = root;
        while (curr.left != null)
            curr = curr.left;
        return curr.val;
    }

    // ! ============= GFG. Minimum in BST ============
    /*
    @ TC --> O(log N)
    
    @ SC --> O(1)
     */
    public int minValue(TreeNode root) {
        if (root == null)
            return -1;
        if (root.left == null)
            return root.val;
        return minValue(root.left);
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. GFG. Minimum in BST ✅
// 2. LC450. Delete Node in a BST ✅
// 3. LC230. Kth Smallest Element in a BST ✅
// 4. GFG. Kth Largest in BST ✅