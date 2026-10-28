import java.util.*;

public class Oct27 {
    // ! ============= LC863. All Nodes Distance K in Binary Tree ============
    /*
    @ TC --> O(N + N)
    @ SC --> O(N + H + N) --> for HashMap + Recursive Stack Space + Visited Set
    */
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        keepParentLinks(root, parents, q);
        q.clear();

        q.offer(findTargetAddress(root, target));
        Set<TreeNode> visited = new HashSet<>();
        int radius = 0;

        while (!q.isEmpty()) {
            if (radius == k)
                break;
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                if (parents.containsKey(node) && !visited.contains(parents.get(node)))
                    q.offer(parents.get(node));
                if (node.left != null && !visited.contains(node.left))
                    q.offer(node.left);
                if (node.right != null && !visited.contains(node.right))
                    q.offer(node.right);
                visited.add(node);
            }
            radius++;
        }
        q.forEach(elem -> System.out.println(elem.val));
        return res;
    }

    public static TreeNode findTargetAddress(TreeNode root, TreeNode target) {
        if (root == null)
            return null;
        if (root.val.equals(target.val))
            return root;
        TreeNode left = findTargetAddress(root.left, target);
        if (left != null)
            return left;
        TreeNode right = findTargetAddress(root.right, target);
        if (right != null)
            return right;

        return root;
    }

    public static void keepParentLinks(TreeNode root, HashMap<TreeNode, TreeNode> parents, Queue<TreeNode> q) {
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null) {
                parents.put(node.left, node);
                q.offer(node.left);
            }
            if (node.right != null) {
                parents.put(node.right, node);
                q.offer(node.right);
            }
        }
    }

    // ! ============= GFG. Sum Tree ============
    /*
    @ TC --> O(N)
    @ SC --> O(H)
    */
    public boolean isSumTree(TreeNode node) {
        return isSumTreeHelper(node) != -1;
    }

    public int isSumTreeHelper(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return root.val;

        int left = isSumTreeHelper(root.left);
        if (left == -1)
            return -1;
        int right = isSumTreeHelper(root.right);
        if (right == -1)
            return -1;

        if (left + right != root.val)
            return -1;
        return left + right + root.val;
    }

    // ! ============= GFG. Transform to Sum Tree ============
    /*
    @ TC --> O(N)
    @ SC --> O(H)
    */
    public static void toSumTree(TreeNode root) {
        toSumTreeHelper(root);
    }

    public static int toSumTreeHelper(TreeNode root) {
        if (root == null)
            return 0;
        int data = root.val;

        int left = toSumTreeHelper(root.left);
        int right = toSumTreeHelper(root.right);

        root.val = left + right;

        return data + left + right;
    }

    // ! ============= GFG. Children Sum in a Binary Tree ============
    /*
    @ TC --> O(N)
    @ SC --> O(H)
    */
    public static boolean isSumProperty(TreeNode root) {
        if (root == null)
            return true;

        boolean left = isSumProperty(root.left);
        boolean right = isSumProperty(root.right);

        if (left == false || right == false)
            return false;

        int sum = 0;
        if (root.left != null)
            sum += root.left.val;
        if (root.right != null)
            sum += root.right.val;

        if (sum != root.val) {
            if (root.left == null && root.right == null)
                return true;
            return false;
        }
        return true;
    }

    // ! ============= LC236. Lowest Common Ancestor of a Binary Tree ============
    /*
    @ TC --> O(N)
    @ SC --> O(H)
    */
    public static TreeNode lcaOptimal(TreeNode root, int n1, int n2) {
        return new TreeNode(findPathOptimal(root, n1, n2));
    }

    public static int findPathOptimal(TreeNode root, int n1, int n2) {
        if (root == null)
            return -1;

        if (root.val == n1 || root.val == n2)
            return root.val;

        int left = findPathOptimal(root.left, n1, n2);
        int right = findPathOptimal(root.right, n1, n2);

        if (left == -1 && right == -1)
            return -1;
        if (left == -1)
            return right;
        if (right == -1)
            return left;

        return root.val;
    }

    /*
    @ TC --> O(N)
    @ SC --> O(N + H) --> storing the values + recursive Stack Space
    */
    public static TreeNode lcaBrute(TreeNode root, int n1, int n2) {
        ArrayList<TreeNode> left = new ArrayList<>();
        ArrayList<TreeNode> right = new ArrayList<>();

        findPathBrute(root, n1, left);
        findPathBrute(root, n2, right);

        TreeNode res = new TreeNode(-1);
        int i = 0;
        int j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).val != right.get(j).val)
                break;
            res = left.get(i);
            i++;
            j++;
        }
        return res;
    }

    public static boolean findPathBrute(TreeNode root, int target, ArrayList<TreeNode> path) {
        if (root == null)
            return false;
        path.add(root);
        if (root.val == target)
            return true;
        boolean left = findPathBrute(root.left, target, path);
        boolean right = findPathBrute(root.right, target, path);
        if (left || right)
            return true;
        path.remove(path.size() - 1);
        return false;
    }
}
// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC236. Lowest Common Ancestor of a Binary Tree ✅
// 2. GFG. Children Sum in a Binary Tree ✅
// 3. GFG. Transform to Sum Tree ✅
// 4. GFG. Sum Tree ✅
// 5. LC863. All Nodes Distance K in Binary Tree ✅
