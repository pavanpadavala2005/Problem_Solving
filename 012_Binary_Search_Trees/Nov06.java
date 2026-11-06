import java.util.*;

public class Nov06 {
    // ! ============= LC99. Recover Binary Search Tree ============
    /*
    * Using Morris Method ( Best Approach )
    @ TC --> O(N)
    @ SC --> O(1)
    */

    public static void recoverTreeOptimal(TreeNode root) {
        TreeNode n1 = null;
        TreeNode n2 = null;
        TreeNode prev = null;

        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                if (prev != null && prev.val > curr.val) {
                    if (n1 == null)
                        n1 = prev;
                    n2 = curr;
                }
                prev = curr;
                curr = curr.right;
            } else {
                TreeNode temp = curr.left;
                while (temp.right != null && temp.right != curr)
                    temp = temp.right;
                if (temp.right == null) {
                    temp.right = curr;
                    curr = curr.left;
                } else {
                    temp.right = null;

                    if (prev != null && prev.val > curr.val) {
                        if (n1 == null)
                            n1 = prev;
                        n2 = curr;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        if (n1 != null && n2 != null) {
            int temp = n1.val;
            n1.val = n2.val;
            n2.val = temp;
        }
    }

    /*
    @ TC --> O(N)
    @ SC --> O(H)
    */
    static TreeNode node1 = null;
    static TreeNode node2 = null;
    static TreeNode prev = null;

    public static void recoverTreeBrute(TreeNode root) {
        recoverTreeBruteHelper(root);
        if (node1 != null && node2 != null) {
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }
    }

    public static void recoverTreeBruteHelper(TreeNode root) {
        if (root == null)
            return;
        recoverTreeBruteHelper(root.left);

        if (prev != null && prev.val > root.val) {
            if (node1 == null)
                node1 = prev;
            node2 = root;
        }

        prev = root;
        recoverTreeBruteHelper(root.right);
    }

    // ! ============= GFG. Fixing Two Nodes of BST ============
    /*
    @ TC --> O(N)
    @ SC --> O(H)
    */
    TreeNode n1 = null;
    TreeNode n2 = null;
    TreeNode pre = null;

    public TreeNode correctBST(TreeNode root) {
        correctBSTHelper(root);
        if (n1 != null && n2 != null) {
            int temp = n1.val;
            n1.val = n2.val;
            n2.val = temp;
        }
        return root;
    }

    public void correctBSTHelper(TreeNode root) {
        if (root == null)
            return;

        correctBSTHelper(root.left);

        if (pre != null && pre.val > root.val) {
            if (n1 == null)
                n1 = pre;
            n2 = root;
        }

        pre = root;
        correctBSTHelper(root.right);
    }

    // ! ============= LC108. Convert Sorted Array to Binary Search Tree ============

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length <= 0)
            return null;
        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }

    public static TreeNode sortedArrayToBSTHelper(int[] nums, int st, int ed) {
        if (st > ed)
            return null;

        int mid = st + (ed - st) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedArrayToBSTHelper(nums, st, mid - 1);
        root.right = sortedArrayToBSTHelper(nums, mid + 1, ed);

        return root;
    }

    // ! ============= GFG. Merge Two BSTs ============
    /*
    @ TC --> O( M + N )
    @ SC --> O( M + N )
    */
    public static ArrayList<Integer> mergeOptimal(TreeNode r1, TreeNode r2) {
        ArrayList<Integer> res = new ArrayList<>();
        if (r1 == null || r2 == null)
            return res;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        while (r1 != null || r2 != null || !s1.isEmpty() || !s2.isEmpty()) {
            while (r1 != null) {
                s1.add(r1);
                r1 = r1.left;
            }
            while (r2 != null) {
                s2.add(r2);
                r2 = r2.left;
            }
            if (s2.isEmpty() || (!s1.isEmpty() && s1.peek().val < s2.peek().val)) {
                TreeNode node = s1.pop();
                res.add(node.val);
                r1 = node.right;
            } else {
                TreeNode node = s2.pop();
                res.add(node.val);
                r2 = node.right;
            }
        }
        return res;
    }

    /*
    @ TC --> O((M+N) + (M+N) log (M+N))
    @ SC --> O(M+N)
    */
    public static ArrayList<Integer> mergeBrute(TreeNode r1, TreeNode r2) {
        ArrayList<Integer> res = new ArrayList<>();
        if (r1 == null) {
            mergeBruteHelper(r2, res);
            return res;
        } else if (r2 == null) {
            mergeBruteHelper(r1, res);
            return res;
        }

        mergeBruteHelper(r1, res);
        mergeBruteHelper(r2, res);

        Collections.sort(res);
        return res;
    }

    public static void mergeBruteHelper(TreeNode root, ArrayList<Integer> res) {
        if (root == null)
            return;
        mergeBruteHelper(root.left, res);
        res.add(root.val);
        mergeBruteHelper(root.right, res);
    }

    // ! ============= LC653. Two Sum IV - Input is a BST ============
    /*
    @ TC --> O(N log N)
    @ SC --> O(H)
    */
    public static boolean findTargetOptimal(TreeNode root, int k) {
        if (root == null)
            return false;
        return findTargetOptimalHelper(root, root, k);
    }

    public static boolean findTargetOptimalHelper(TreeNode org, TreeNode root, int k) {
        if (root == null)
            return false;

        int rem = k - root.val;
        if (findNode(org, root, rem))
            return true;

        boolean left = findTargetOptimalHelper(org, root.left, k);
        if (left)
            return true;

        boolean right = findTargetOptimalHelper(org, root.right, k);
        if (right)
            return true;
        return false;
    }

    public static boolean findNode(TreeNode org, TreeNode root, int rem) {
        while (org != null) {
            if (rem < org.val)
                org = org.left;
            else if (rem > org.val)
                org = org.right;
            else {
                if (root != org)
                    return true;
                org = org.left;
            }
        }
        return false;
    }

    /*
    @ TC --> O(N)
    @ SC --> O(H + N)
    */
    public static boolean findTargetBrute(TreeNode root, int k) {
        if (root == null)
            return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        return findTargetBruteHelper(root, k, map);
    }

    public static boolean findTargetBruteHelper(TreeNode root, int k, HashMap<Integer, Integer> map) {
        if (root == null)
            return false;

        boolean left = findTargetBruteHelper(root.left, k, map);
        if (left)
            return true;

        boolean right = findTargetBruteHelper(root.right, k, map);
        if (right)
            return true;

        int rem = k - root.val;
        if (map.containsKey(rem))
            return true;
        map.put(root.val, 1);

        return false;
    }

}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC653. Two Sum IV - Input is a BST ✅
// 2. GFG. Merge Two BSTs ✅
// 3. LC108. Convert Sorted Array to Binary Search Tree ✅
// 4. GFG. Fixing Two Nodes of BST ✅
// 5. LC99. Recover Binary Search Tree ✅