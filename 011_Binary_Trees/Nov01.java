import java.util.*;

public class Nov01 {

    // ! ============= LC1302. Deepest Leaves Sum ============
    /*
    @ TC --> O(N)
    @ SC --> O(H)
    */
    static int maxLevel = -1;
    static int sum = 0;

    public static int deepestLeavesSumOptimal(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    public static void dfs(TreeNode root, int level) {
        if (root == null)
            return;
        if (level > maxLevel) {
            maxLevel = level; // When we get into the Deepest level
            sum = root.val;
        } else if (level >= maxLevel)
            sum += root.val; // in the same other than 1st time we went

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    /*
    @ TC --> O(N * H)
    @ SC --> O(H)
    */
    public static int deepestLeavesSumBetter(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.val;
        int lh = findDepth(root.left);
        int rh = findDepth(root.right);
        if (lh > rh)
            return deepestLeavesSumBetter(root.left);
        else if (rh > lh)
            return deepestLeavesSumBetter(root.right);
        return deepestLeavesSumBetter(root.left) + deepestLeavesSumBetter(root.right);
    }

    // ! ============= LC2641. Cousins in Binary Tree II ============
    public static TreeNode replaceValueInTreeOptimal(TreeNode root) {
        root.val = 0;
        if (root.left == null && root.right == null)
            return root;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelSum = 0;
            int n = q.size();
            while (n-- > 0) {
                TreeNode temp = q.poll();
                if (temp.left != null)
                    levelSum += temp.left.val;
                if (temp.right != null)
                    levelSum += temp.right.val;
                q.offer(temp);
            }

            n = q.size();
            while (n-- > 0) {
                TreeNode node = q.poll();
                int nodeSum = 0;
                if (node.left != null)
                    nodeSum += node.left.val;
                if (node.right != null)
                    nodeSum += node.right.val;

                if (node.left != null) {
                    node.left.val = levelSum - nodeSum;
                    q.offer(node.left);
                }
                if (node.right != null) {
                    node.right.val = levelSum - nodeSum;
                    q.offer(node.right);
                }
            }
        }
        return root;
    }

    /*
    @ TC --> O(N + N)
    @ SC --> O(N + 10^5)
    */
    public static TreeNode replaceValueInTreeBrute(TreeNode root) {
        root.val = 0;
        if (root.left == null && root.right == null)
            return root;
        Queue<TreeNode> q = new LinkedList<>();
        int[] map = new int[100001];

        replaceValueInTreeBruteHelper(root, q, map);
        q.offer(root);
        int level = 0;

        while (!q.isEmpty()) {
            int n = q.size();
            while (n-- > 0) {
                TreeNode node = q.poll();
                int sum = 0;
                if (node.left != null)
                    sum += node.left.val;
                if (node.right != null)
                    sum += node.right.val;

                int nextLevel = map[level + 1];

                if (node.left != null) {
                    node.left.val = nextLevel - sum;
                    q.offer(node.left);
                }

                if (node.right != null) {
                    node.right.val = nextLevel - sum;
                    q.offer(node.right);
                }
            }
            level++;
        }
        return root;
    }

    public static void replaceValueInTreeBruteHelper(TreeNode root, Queue<TreeNode> q, int[] map) {
        if (root == null)
            return;
        q.offer(root);
        int level = 0;
        while (!q.isEmpty()) {
            int sum = 0;
            int n = q.size();
            while (n-- > 0) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            map[level] = sum;
            level++;
        }
    }

    // ! ============= LC1123. Lowest Common Ancestor of Deepest Leaves ============
    /*
    @ TC --> O(H)
    @ SC --> O(H)
    */
    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root.left == null && root.right == null)
            return root;

        int left = findDepth(root.left);
        int right = findDepth(root.right);

        if (left > right)
            return lcaDeepestLeaves(root.left);
        else if (right > left)
            return lcaDeepestLeaves(root.right);

        return root;
    }

    public static int findDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(findDepth(root.left), findDepth(root.right));
    }

    // ! ============= LC117. Populating Next Right Pointers in Each Node II ============
    /*
    @ TC --> O(N)
    @ SC --> O(N)
    */
    public SpecialTreeNode connectBrute(SpecialTreeNode root) {
        if (root == null)
            return null;
        Queue<SpecialTreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            SpecialTreeNode nextNode = null;
            int n = q.size();
            for (int i = 0; i < n; i++) {
                SpecialTreeNode curr = q.poll();
                curr.next = nextNode;
                if (curr.right != null)
                    q.offer(curr.right);
                if (curr.left != null)
                    q.offer(curr.left);
                nextNode = curr;
            }
        }
        return root;
    }

    /*
    @ TC --> O(N)
    @ SC --> O(1)
    */
    public SpecialTreeNode connectBetter(SpecialTreeNode root) {
        if (root == null)
            return null;
        SpecialTreeNode curr = root;
        while (curr != null) {
            SpecialTreeNode dummy = new SpecialTreeNode(0);
            SpecialTreeNode temp = dummy;
            while (curr != null) {
                if (curr.left != null) {
                    temp.next = curr.left;
                    temp = temp.next;
                }
                if (curr.right != null) {
                    temp.next = curr.right;
                    temp = temp.next;
                }
                curr = curr.next;
            }
            curr = dummy.next;
        }
        return root;
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC117. Populating Next Right Pointers in Each Node II ✅
// 2. LC1123. Lowest Common Ancestor of Deepest Leaves ✅
// 3. LC2641. Cousins in Binary Tree II ✅
// 4. LC1302. Deepest Leaves Sum ✅