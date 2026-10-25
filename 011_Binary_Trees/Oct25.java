import java.util.*;

public class Oct25 {

    // ! ============= GFG. Top View of Binary Tree ============
    /*
    @ TC --> O(N) + O(Map)
    @ SC --> O(Map)
    */
    public static ArrayList<Integer> topView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        SortedMap<Integer, int[]> map = new TreeMap<>();
        topViewHelper(root, 0, 0, map);
        for (int i : map.keySet())
            res.add(map.get(i)[1]);
        return res;
    }

    public static void topViewHelper(TreeNode root, int level, int col, SortedMap<Integer, int[]> map) {
        if (root == null)
            return;
        int val = root.val;
        int[] mp = map.getOrDefault(col, new int[] { level, val });
        if (mp[0] > level) {
            mp[0] = level;
            mp[1] = val;
        }
        map.put(col, mp);

        topViewHelper(root.left, level + 1, col - 1, map);
        topViewHelper(root.right, level + 1, col + 1, map);
    }

    // ! ============= LC987. Vertical Order Traversal of a Binary Tree ============
    /*
    @ TC --> O(N) + O(log N) + O(N log N)
    @ SC --> O(N)
    */
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        SortedMap<Integer, SortedMap<Integer, List<Integer>>> map = new TreeMap();
        verticalTraversalHelper(root, 0, 0, map);

        for (int i : map.keySet()) {
            List<Integer> inner = new ArrayList<>();
            SortedMap<Integer, List<Integer>> mp = map.get(i);
            for (int j : mp.keySet()) {
                List<Integer> ls = mp.get(j);
                Collections.sort(ls);
                inner.addAll(ls);
            }
            res.add(inner);
        }
        return res;
    }

    public static void verticalTraversalHelper(TreeNode root, int row, int col,
            SortedMap<Integer, SortedMap<Integer, List<Integer>>> map) {
        if (root == null)
            return;

        SortedMap<Integer, List<Integer>> mp = map.getOrDefault(col, new TreeMap<>());

        List<Integer> ls = mp.getOrDefault(row, new ArrayList<>());

        ls.add(root.val);
        mp.put(row, ls);
        map.put(col, mp);

        verticalTraversalHelper(root.left, row + 1, col - 1, map);
        verticalTraversalHelper(root.right, row + 1, col + 1, map);
    }

    // ! ============= GFG. Tree Boundary Traversal (LC545. Boundary Of Binary Tree) ============
    /*
    @ TC --> O(Left + N + Right)
    @ SC --> O(N)
    ! Took nearly 2 Hrs 
    */
    public static ArrayList<Integer> boundaryTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        res.add(root.val);
        goLeft(root.left, res);
        inOrder(root, res);
        getRight(root.right, res);
        return res;
    }

    public static void goLeft(TreeNode root, ArrayList<Integer> left) {
        if (root == null || (root.left == null && root.right == null))
            return;
        left.add(root.val);
        if (root.left == null)
            goLeft(root.right, left);
        else
            goLeft(root.left, left);
    }

    public static void inOrder(TreeNode root, ArrayList<Integer> leaf) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            leaf.add(root.val);
        inOrder(root.left, leaf);
        inOrder(root.right, leaf);
    }

    public static void getRight(TreeNode root, ArrayList<Integer> right) {
        if (root == null || (root.left == null && root.right == null))
            return;
        if (root.right == null)
            getRight(root.left, right);
        else
            getRight(root.right, right);
        right.add(root.val);
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. GFG. Tree Boundary Traversal ✅
// 2. LC987. Vertical Order Traversal of a Binary Tree ✅
// 3. GFG. Top View of Binary Tree ✅