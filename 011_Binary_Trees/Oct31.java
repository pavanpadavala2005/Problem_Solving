import java.util.*;

public class Oct31 {

    // ! ============= LC116. Populating Next Right Pointers in Each Node ============
    /*
    @ TC --> O(N)
    @ SC --> O(H)
    */
    public SpecialTreeNode connectOtimal(SpecialTreeNode root) {
        if (root == null)
            return root;
        connectOtimalHelper(root);
        return root;
    }

    public void connectOtimalHelper(SpecialTreeNode node) {
        if (node == null || node.left == null)
            return;
        node.left.next = node.right;
        if (node.next != null)
            node.right.next = node.next.left;
        connectOtimalHelper(node.left);
        connectOtimalHelper(node.right);
    }

    /*
    @ TC --> O(N)
    @ SC --> O(N)
    */
    public static SpecialTreeNode connectBrute(SpecialTreeNode root) {
        if (root == null)
            return root;
        Queue<SpecialTreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();

            SpecialTreeNode nextNode = null;
            for (int i = 0; i < n; i++) {
                SpecialTreeNode node = q.poll();
                node.next = nextNode;
                nextNode = node;

                if (node.right != null)
                    q.offer(node.right);
                if (node.left != null)
                    q.offer(node.left);
            }
        }

        return root;
    }

    // ! ============= LC993. Cousins in Binary Tree ============
    /*
    @ TC --> O(N) 
    @ SC --> O(H) 
    */
    TreeNode xParent = null;
    TreeNode yParent = null;
    int xDepth = -1;
    int yDepth = -1;

    public boolean isCousins(TreeNode root, int x, int y) {
        isCousinsHelper(root, root, 0, x, y);
        return xParent != yParent && xDepth == yDepth;
    }

    public void isCousinsHelper(TreeNode root, TreeNode parent, int depth, int x, int y) {
        if (root == null)
            return;
        if (root.val == x) {
            xDepth = depth;
            xParent = parent;
        }
        if (root.val == y) {
            yDepth = depth;
            yParent = parent;
        }
        isCousinsHelper(root.left, root, depth + 1, x, y);
        isCousinsHelper(root.right, root, depth + 1, x, y);
    }

    // ! ============= LC102. Binary Tree Level Order Traversal ============
    /*
    @ TC --> O(N)
    @ SC --> O(N)
    */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> lis = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                lis.add(node.val);

                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            res.add(lis);
        }
        return res;
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC102. Binary Tree Level Order Traversal ✅
// 2. LC993. Cousins in Binary Tree ✅
// 3. LC116. Populating Next Right Pointers in Each Node ✅
