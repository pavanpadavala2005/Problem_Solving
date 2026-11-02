public class Nov02 {
    // ! ============= LC701. Insert into a Binary Search Tree ============
    /*
    @ TC --> O(log N)
    @ SC --> O(1)
    */
    public static TreeNode insertIntoBSTOptimal(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        TreeNode curr = root;
        TreeNode prev = root;
        while (curr != null) {
            prev = curr;
            if (val < curr.val)
                curr = curr.left;
            else
                curr = curr.right;
        }
        if (val < prev.val)
            prev.left = new TreeNode(val);
        else
            prev.right = new TreeNode(val);
        return root;
    }

    /*
    @ TC --> O(log N)
    @ SC --> O(H)
    */
    public static TreeNode insertIntoBSTBrute(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (val < root.val)
            root.left = insertIntoBSTBrute(root.left, val);
        else if (val > root.val)
            root.right = insertIntoBSTBrute(root.right, val);
        return root;
    }

    // ! ============= GFG. Ceiil in BST ============
    /*
    @ TC -- O(log N) 
    @ SC --> O(1)
    */
    public static int findCeilOptimal(TreeNode root, int k) {
        int res = -1;
        if (root == null)
            return res;
        while (root != null) {
            if (root.val >= k) {
                res = root.val;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }

    /*
    @ TC -- O(log N)
    @ SC --> O(H)
    */
    static int ceilRes = -1;

    public static int findCeilBrute(TreeNode root, int k) {
        if (root == null)
            return ceilRes;
        findCeilBruteHelper(root, k);
        return ceilRes;
    }

    public static void findCeilBruteHelper(TreeNode root, int k) {
        if (root == null)
            return;
        if (root.val >= k) {
            ceilRes = root.val;
            findCeilBruteHelper(root.left, k);
        } else {
            findCeilBruteHelper(root.right, k);
        }
    }

    // ! ============= GFG. Floor in BST ============
    /*
    @ TC --> O(log N) 
    @ SC --> O(1)
    */
    public static int findFloorOptimal(TreeNode root, int k) {
        int res = -1;
        if (root == null)
            return res;
        while (root != null) {
            if (root.val <= k) {
                res = root.val;
                root = root.right;
            } else
                root = root.left;
        }
        return res;
    }

    static int floorRes = -1;

    /*
    @ TC --> O(log N)
    @ SC --> O(H)
    */
    public static int findFloorBrute(TreeNode root, int k) {
        if (root == null)
            return floorRes;
        findFloorBruteHelper(root, k);
        return floorRes;
    }

    public static void findFloorBruteHelper(TreeNode root, int k) {
        if (root == null)
            return;
        if (root.val <= k) {
            floorRes = root.val;
            findFloorBruteHelper(root.right, k);
        } else {
            findFloorBruteHelper(root.left, k);
        }
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. GFG. Floor in BST ✅
// 2. GFG. Ceiil in BST ✅
// 3. LC701. Insert into a Binary Search Tree ✅