import java.util.*;

public class Oct26 {
    // ! ============= GFG. Paths from Root with Sum ============
    /*
    @ TC --> O(N)
    @ SC --> O(H + N) --> recursive Stack Space (Ignorable) + for Returning answer (Ignorable)
    */
    public static ArrayList<ArrayList<Integer>> printPaths(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> lis = new ArrayList<>();
        printPathsHelper(root, lis, 0, target, res);
        return res;
    }

    public static void printPathsHelper(TreeNode root, ArrayList<Integer> lis, long sum, int target,
            ArrayList<ArrayList<Integer>> res) {
        if (root == null)
            return;

        lis.add(root.val);
        sum += root.val;

        if (sum == target)
            res.add(new ArrayList<>(lis));

        printPathsHelper(root.left, lis, sum, target, res);
        printPathsHelper(root.right, lis, sum, target, res);

        sum -= root.val;
        lis.remove(lis.size() - 1);
    }

    // ! ============= GFG. Root to Leaf Paths ============
    /*
    @ TC --> O(N)
    @ SC --> O(H) --> Auxiliary Stack Space ( Ignorable )
    */
    public static ArrayList<ArrayList<Integer>> paths(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> lis = new ArrayList<>();
        pathsHelperV1(root, res, lis);
        return res;
    }

    /*
    * Reduced the Duplicate Lines
    */
    public static void pathsHelperV2(TreeNode root, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> lis) {
        if (root == null)
            return;
        lis.add(root.val);
        if (root.left == null && root.right == null)
            res.add(new ArrayList<>(lis));
        else {
            pathsHelperV2(root.left, res, lis);
            pathsHelperV2(root.right, res, lis);
        }
        lis.remove(lis.size() - 1);
    }

    public static void pathsHelperV1(TreeNode root, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> lis) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            lis.add(root.val);

            ArrayList<Integer> ls = new ArrayList<>(lis);

            lis.remove(lis.size() - 1);

            res.add(ls);
            return;
        }

        lis.add(root.val);
        pathsHelperV1(root.left, res, lis);
        lis.remove(lis.size() - 1);

        lis.add(root.val);
        pathsHelperV1(root.right, res, lis);
        lis.remove(lis.size() - 1);
    }

    // ! ============= LC101. Symmetric Tree ============
    /*
    @ TC --> O(N)
    @ SC --> O(1)
    */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetricHelper(root.left, root.right);
    }

    public static boolean isSymmetricHelper(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return p == q;
        return p.val == q.val && isSymmetricHelper(p.left, q.right) && isSymmetricHelper(p.right, q.left);
    }

    // ! ============= GFG. Left View of Binary Tree ============
    /*
    @ TC --> o(N)
    @ TC --> o(N)
    */
    public static ArrayList<Integer> leftSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        leftSideViewHelper(root, 0, res);
        return res;
    }

    public static void leftSideViewHelper(TreeNode root, int level, ArrayList<Integer> res) {
        if (root == null)
            return;

        if (level == res.size())
            res.add(root.val);

        leftSideViewHelper(root.left, level + 1, res);
        leftSideViewHelper(root.right, level + 1, res);
    }

    // ! ============= LC199. Binary Tree Right Side View ============
    /*
    * using DFS (Reverse preOrder)
    @ TC --> O(N)
    @ SC --> O(N)
    */
    public static List<Integer> rightSideViewOptimal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        rightSideViewOptimalHelper(root, 0, res);
        return res;
    }

    public static void rightSideViewOptimalHelper(TreeNode root, int level, List<Integer> res) {
        if (root == null)
            return;
        if (level == res.size())
            res.add(root.val);
        rightSideViewOptimalHelper(root.right, level + 1, res);
        rightSideViewOptimalHelper(root.left, level + 1, res);
    }

    /*
    * using DFS + HashMap
    @ TC --> O(N)
    @ SC --> O(N + N)
    */
    public static List<Integer> rightSideViewBrute(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        SortedMap<Integer, Integer> map = new TreeMap();
        rightSideViewBruteHelper(root, 0, 0, map);
        for (int i : map.keySet())
            res.add(map.get(i));
        return res;
    }

    public static void rightSideViewBruteHelper(TreeNode root, int level, int col, SortedMap<Integer, Integer> map) {
        if (root == null)
            return;
        map.putIfAbsent(level, root.val);
        rightSideViewBruteHelper(root.right, level + 1, col + 1, map);
        rightSideViewBruteHelper(root.left, level + 1, col - 1, map);
    }

    // ! ============= GFG. Bottom View of Binary Tree ============
    /*
    * Using BFS ( LEVEL ORDER )
    @ TC --> O(N) + O(Map)
    @ SC --> O(N)
    */
    public static record Pair(TreeNode node, int level, int col) {
    }

    public static ArrayList<Integer> bottomView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        SortedMap<Integer, Integer> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            TreeNode node = p.node;
            int level = p.level;
            int col = p.col;

            map.put(col, node.val);

            if (node.left != null)
                q.offer(new Pair(node.left, level + 1, col - 1));
            if (node.right != null)
                q.offer(new Pair(node.right, level + 1, col + 1));
        }
        for (int i : map.keySet())
            res.add(map.get(i));
        return res;
    }

    /*
    * Using DFS( PRE ORDER )
    @ TC --> O(N)
    @ SC --> O(N)
    */
    public static ArrayList<Integer> bottomViewBrute(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        SortedMap<Integer, int[]> map = new TreeMap<>();
        bottomViewBruteHelper(root, 0, 0, map);
        for (int i : map.keySet())
            res.add(map.get(i)[2]);
        return res;
    }

    public static void bottomViewBruteHelper(TreeNode root, int level, int col, SortedMap<Integer, int[]> map) {
        if (root == null)
            return;

        int val = root.val;
        int[] mp = map.getOrDefault(col, new int[] { level, col, val });
        if (level >= mp[0]) {
            mp[0] = level;
            mp[2] = val;
        }
        map.put(col, mp);
        bottomViewBruteHelper(root.left, level + 1, col - 1, map);
        bottomViewBruteHelper(root.right, level + 1, col + 1, map);
    }

}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. GFG. Bottom View of Binary Tree ✅
// 2. LC199. Binary Tree Right Side View ✅
// 3. GFG. Left View of Binary Tree ✅
// 4. LC101. Symmetric Tree ✅
// 5. GFG. Root to Leaf Paths ✅
// 6. GFG. Paths from Root with Sum ✅
