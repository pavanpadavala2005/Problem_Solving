import java.util.*;

public class Oct30 {

    // TODO:
    // ! ============= GFG. Sum Nodes on Longest Path ============
    public static int sumOfLongRootToLeafPath(TreeNode root) {
        return -1;
    }

    // ! ============= LC437. Path Sum III ============
    /*
    @ TC --> O(N)
    @ SC --> O(H + N)
    */

    int count = 0;

    public int pathSumOptimal(TreeNode root, int targetSum) {
        if (root == null)
            return count;

        HashMap<Long, Integer> map = new HashMap<>();
        map.put((long) 0, 1);
        pathSumHelperOptimal(root, map, targetSum, 0);
        return count;
    }

    public void pathSumHelperOptimal(TreeNode root, HashMap<Long, Integer> map, int target, long sum) {
        if (root == null)
            return;
        sum += root.val;
        long rem = sum - target;

        if (map.containsKey(rem))
            count += map.get(rem);

        map.put(sum, map.getOrDefault(sum, 0) + 1);

        pathSumHelperOptimal(root.left, map, target, sum);
        pathSumHelperOptimal(root.right, map, target, sum);

        map.put(sum, map.get(sum) - 1);
    }

    /*
    @ TC --> O(N^2) --> it was like a nested loop. Here it is Nested Recursion form very node to leaf node every time
    @ SC --> O(H)
    */
    int counter = 0;

    public int pathSumBrute(TreeNode root, int targetSum) {
        if (root == null)
            return counter;
        pathSumHelperBrute(root, targetSum);
        pathSumBrute(root.left, targetSum);
        pathSumBrute(root.right, targetSum);
        return counter;
    }

    public void pathSumHelperBrute(TreeNode root, long target) {
        if (root == null)
            return;
        if (target - root.val == 0)
            counter++;
        pathSumHelperBrute(root.left, target - root.val);
        pathSumHelperBrute(root.right, target - root.val);
    }

    // ! ============= LC113. Path Sum II ============
    /*
    @ TC --> O(N)
    @ SC --> O(H + 2N) --> recursive Stack Space + returning result ( Both Ignorable )
    */
    public List<List<Integer>> pathSumIIOptimal(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        List<Integer> lis = new ArrayList<>();
        pathSumIIHelperOptimal(root, targetSum, lis, res);
        return res;
    }

    public void pathSumIIHelperOptimal(TreeNode root, int target, List<Integer> lis, List<List<Integer>> res) {
        if (root == null)
            return;

        lis.add(root.val);

        if (root.left == null && root.right == null) {
            if (root.val == target)
                res.add(new ArrayList<>(lis));
        } else {
            pathSumIIHelperOptimal(root.left, target - root.val, lis, res);
            pathSumIIHelperOptimal(root.right, target - root.val, lis, res);
        }
        lis.remove(lis.size() - 1);
    }

    public void pathSumIIHelperBetter(TreeNode root, int target, List<Integer> lis, List<List<Integer>> res) {
        if (root == null)
            return;
        lis.add(root.val);
        if (root.left == null && root.right == null) {
            if (target - root.val == 0) {
                res.add(new ArrayList<>(lis));
                lis.remove(lis.size() - 1);
                return;
            }
        }
        pathSumIIHelperBetter(root.left, target - root.val, lis, res);
        pathSumIIHelperBetter(root.right, target - root.val, lis, res);
        lis.remove(lis.size() - 1);
    }

    // ! ============= LC112. Path Sum I ============
    /*
    @ TC --> O(N)
    @ SC --> O(H)
    */
    public static boolean pathSumI(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null)
            return targetSum - root.val == 0;

        boolean left = pathSumI(root.left, targetSum - root.val);
        if (left)
            return true;

        boolean right = pathSumI(root.right, targetSum - root.val);
        if (right)
            return true;
        return false;
    }

    // ! ============= LC572. Subtree of Another Tree ============
    /*
    @ TC --> O(N)
    @ SC --> O(H)
    */
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null)
            return true;

        if (root == null)
            return false;

        if (root.val.equals(subRoot.val))
            if (isSameTree(root, subRoot))
                return true;

        boolean left = isSubtree(root.left, subRoot);
        if (left)
            return true;

        boolean right = isSubtree(root.right, subRoot);
        if (right)
            return right;

        return false;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return p == q;
        return (p.val.equals(q.val)) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // ! ============= LC111. Minimum Depth of Binary Tree ============
    /*
    @ TC --> O(N)
    @ SC --> O(H)
    */
    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int lh = minDepth(root.left);
        int rh = minDepth(root.right);

        if (lh == 0 || rh == 0)
            return lh + rh + 1;

        return 1 + Math.min(lh, rh);
    }

    // ! ============= LC114. Flatten Binary Tree to Linked List ============

    /*
    @ TC --> O(N) ⭐
    @ SC --> O(1)
    */
    public static void flattenUsingMorrisMethod(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode temp = curr.left;
                while (temp.right != null)
                    temp = temp.right;
                temp.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    /*
    @ TC --> O(N)
    @ SC --> O(N)
    */
    public static void flattenUsingStack(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode curr = st.pop();
            if (curr.right != null)
                st.push(curr.right);
            if (curr.left != null)
                st.push(curr.left);
            if (!st.isEmpty())
                curr.right = st.peek();
            curr.left = null;
        }
    }

    /*
    @ TC --> O(N) 
    @ SC --> O(H)
    */
    static TreeNode prev = null;

    public static void flattenUsingRecursion(TreeNode root) {
        if (root == null)
            return;
        flattenUsingRecursion(root.right);
        flattenUsingRecursion(root.left);
        root.left = null;
        root.right = prev;
        prev = root;
    }

    /*
    @ TC --> O(N + N)
    @ SC --> O(N)
    */
    public static void flattenUsingPreOrder(TreeNode root) {
        if (root == null)
            return;
        List<TreeNode> lis = new ArrayList<>();
        flattenUsingPreOrderHelper(root, lis);
        int n = lis.size();
        for (int i = 0; i < n; i++) {
            TreeNode curr = lis.get(i);
            curr.left = null;
            if (i + 1 < n)
                lis.get(i).right = lis.get(i + 1);
            else
                lis.get(i).right = null;
        }
    }

    public static void flattenUsingPreOrderHelper(TreeNode root, List<TreeNode> lis) {
        if (root == null)
            return;
        lis.add(root);
        flattenUsingPreOrderHelper(root.left, lis);
        flattenUsingPreOrderHelper(root.right, lis);
    }

    // ! ============= GFG. Ancestors in Binary Tree ============
    /*
    @ TC --> O(N)
    @ SC --> O(H + H) --> recursive Stack Space + Returning Answer ( Ignorable )
    */
    public ArrayList<Integer> ancestors(TreeNode root, int target) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null || root.val == target)
            return res;
        ancestorsHelper(root, target, res);
        return res;
    }

    public boolean ancestorsHelper(TreeNode root, int target, ArrayList<Integer> res) {
        if (root == null)
            return false;
        if (root.val == target)
            return true;

        boolean left = ancestorsHelper(root.left, target, res);
        if (left) {
            res.add(root.val);
            return true;
        }

        boolean right = ancestorsHelper(root.right, target, res);
        if (right) {
            res.add(root.val);
            return true;
        }
        return false;
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. GFG. Ancestors in Binary Tree ✅
// 2. LC114. Flatten Binary Tree to Linked List ✅
// 3. LC572. Subtree of Another Tree ✅
// 4. LC111. Minimum Depth of Binary Tree ✅
// 5. LC112. Path Sum I ✅
// 6. LC112. Path Sum II ✅
// 7. LC437. Path Sum III ✅