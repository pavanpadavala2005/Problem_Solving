import java.util.*;

public class Oct24 {

    // ! ============= LC103. Binary Tree Zigzag Level Order Traversal ============
    /*
      @ TC --> O(N + N/2) --> extra N/2 Occur because of every alternate level we are adding front of List that cost O(Level) That eventually increasing by 2^N
      @ SC --> O(N) --> for returning answer so ignorable
      
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        boolean flag = true;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> lis = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode node = q.removeFirst();
                if (flag)
                    lis.add(node.val);
                else
                    lis.addFirst(node.val);

                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            res.add(lis);
            flag = !flag;
        }
        return res;
    }

    // ! ============= LC100. Same Tree ============
    /*
     @ TC --> O(N)
     @ SC --> O(N) --> Auxiliary Stack Space (Ignorable)
     */
    public static boolean isSameTreeOptimal(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            if (p == q)
                return true;
            return false;
        }
        boolean left = isSameTreeOptimal(p.left, q.left);
        boolean right = isSameTreeOptimal(p.right, q.right);
        return p.val == q.val && left && right;
    }

    /*
    @ TC --> O(N + N + N)
    @ SC --> O(N + N)
     */

    public static boolean isSameTreeBrute(TreeNode p, TreeNode q) {
        List<Integer> lis1 = preOrder(p);
        List<Integer> lis2 = preOrder(q);
        int n = lis1.size();
        int m = lis2.size();
        if (m != n)
            return false;
        for (int i = 0; i < n; i++)
            if (lis1.get(i) != lis2.get(i))
                return false;
        return true;
    }

    public static List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    public static void preOrder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

    // ! ============= LC124. Binary Tree Maximum Path Sum ============
    /*
    @ TC --> O(N)
    
    @ SC --> O(N)
     */
    static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        maxPathSumUtil(root);
        return maxSum;
    }

    public static int maxPathSumUtil(TreeNode root) {
        if (root == null)
            return 0;

        int ls = Math.max(0, maxPathSumUtil(root.left));
        int rs = Math.max(0, maxPathSumUtil(root.right));

        int val = root.val;
        maxSum = Math.max(maxSum, Math.max(ls + rs + root.val, root.val));

        return val + Math.max(ls, rs);
    }

    // ! ============= LC662. Maximum Width of Binary Tree ============

    /*
    @ TC --> O(N)
    
    @ SC --> O(N)
     */
    public static record Pair(TreeNode node, int val) {
    }

    public static int widthOfBinaryTree(TreeNode root) {
        int maxi = 0;
        if (root == null)
            return maxi;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 1));
        while (!q.isEmpty()) {
            int minIdx = Integer.MAX_VALUE;
            int maxIdx = Integer.MIN_VALUE;
            int n = q.size();

            for (int i = 0; i < n; i++) {
                Pair p = q.poll();
                TreeNode node = p.node;
                int val = p.val;
                minIdx = Math.min(minIdx, val);
                maxIdx = Math.max(maxIdx, val);
                maxi = Math.max(maxi, maxIdx - minIdx + 1);

                if (node.left != null) {
                    q.offer(new Pair(node.left, (val - minIdx) * 2 + 1));
                }
                if (node.right != null) {
                    q.offer(new Pair(node.right, (val - minIdx) * 2 + 2));
                }
            }
        }
        return maxi;
    }
}
// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC662. Maximum Width of Binary Tree ✅
// 2. LC124. Binary Tree Maximum Path Sum ✅
// 3. LC100. Same Tree ✅
// 4. LC103. Binary Tree Zigzag Level Order Traversal ✅
