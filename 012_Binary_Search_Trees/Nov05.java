import java.util.*;

public class Nov05 {
    // ! ============= GFG. Construct BST from Inorder ============
    /*
    @ TC --> O(log N)
    @ SC --> O(H)
    */
    public static TreeNode BSTFromInOrder(int[] inorder) {
        if (inorder.length <= 0)
            return null;
        return BSTFromInOrderHelper(inorder, 0, inorder.length - 1);
    }

    public static TreeNode BSTFromInOrderHelper(int[] inorder, int st, int ed) {
        if (st > ed)
            return null;
        int mid = st + (ed - st) / 2;
        TreeNode root = new TreeNode(inorder[mid]);

        root.left = BSTFromInOrderHelper(inorder, st, mid - 1);
        root.right = BSTFromInOrderHelper(inorder, mid + 1, ed);

        return root;
    }

    // ! ============= GFG. Construct BST from Postorder ============
    /*
    @ TC --> O(N log N)
    @ SC --> O(H)
    */
    public TreeNode BSTFromPostOrder(int[] post) {
        if (post.length <= 0)
            return null;
        return BSTFromPostOrderHelper(post, 0, post.length - 1);
    }

    public TreeNode BSTFromPostOrderHelper(int[] post, int st, int ed) {
        if (st > ed)
            return null;

        TreeNode root = new TreeNode(post[ed]);
        int idx = ed - 1;
        while (idx >= st && post[idx] > post[ed])
            idx--;

        root.left = BSTFromPostOrderHelper(post, st, idx);
        root.right = BSTFromPostOrderHelper(post, idx + 1, ed - 1);

        return root;
    }

    // ! ============= LC285. Predecessor and Successor in BST ============
    /*
    @ TC --> O(N)
    @ SC --> O(H)
    */
    static TreeNode pre = null;
    static TreeNode suc = null;

    public static ArrayList<TreeNode> findPreSuc(TreeNode root, int key) {
        if (root == null)
            return new ArrayList<>(List.of(null, null));

        dfs(root, key);

        ArrayList<TreeNode> res = new ArrayList<>();
        res.add(pre);
        res.add(suc);

        return res;
    }

    public static void dfs(TreeNode root, int key) {
        if (root == null)
            return;

        dfs(root.left, key);

        if (root.val < key) {
            if (pre == null || pre.val < root.val)
                pre = root;
        }
        if (root.val > key) {
            if (suc == null || suc.val > root.val)
                suc = root;
        }

        dfs(root.right, key);
    }

    // ! ============= LC1008. Construct Binary Search Tree from Preorder Traversal ============
    /*
    @ TC --> O(N/2 Log N)
    @ SC --> O(H)
    */
    public TreeNode BSTFromPreOrder(int[] preorder) {
        if (preorder.length <= 0)
            return null;
        return BSTFromPreOrderHelper(preorder, 0, preorder.length - 1);
    }

    public TreeNode BSTFromPreOrderHelper(int[] preorder, int st, int ed) {
        if (st > ed)
            return null;

        TreeNode root = new TreeNode(preorder[st]);
        int idx = st + 1;

        while (idx <= ed && preorder[idx] < preorder[st])
            idx++;

        root.left = BSTFromPreOrderHelper(preorder, st + 1, idx - 1);
        root.right = BSTFromPreOrderHelper(preorder, idx, ed);

        return root;
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 2. LC285. Predecessor and Successor in BST ✅
// 1. LC1008. Construct Binary Search Tree from Preorder Traversal ✅
// 3. GFG. Construct BST from Inorder ✅
// 4. GFG. Construct BST from Postorder ✅