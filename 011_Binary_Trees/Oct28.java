import java.util.*;

public class Oct28 {
    // ! ============= LC105. Construct Binary Tree from Preorder and Inorder Traversal ============
    /*
    @ TC --> O(N)
    @ SC --> O(N)
    */
    public static TreeNode buildTreeNodeExperimental(int[] preorder, int[] inorder) {
        if (preorder.length <= 0 || inorder.length <= 0)
            return null;
        // HashMap<Integer, Integer> map = new HashMap<>();
        int[] map = new int[6001];

        for (int i = 0; i < inorder.length; i++)
            map[inorder[i] + 3000] = i;
        return constructBinaryTreeExperimental(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    public static TreeNode constructBinaryTreeExperimental(int[] preorder, int psIdx, int peIdx, int[] inorder,
            int isIdx,
            int ieIdx, int[] map) {
        if (peIdx < psIdx || ieIdx < isIdx)
            return null;
        TreeNode root = new TreeNode(preorder[psIdx]);

        // int inorderIdx = map.get(preorder[psIdx]);
        int inorderIdx = map[preorder[psIdx] - 3000];
        int numElements = inorderIdx - isIdx;

        root.left = constructBinaryTreeExperimental(preorder, psIdx + 1, psIdx + numElements, inorder, isIdx,
                inorderIdx - 1,
                map);
        root.right = constructBinaryTreeExperimental(preorder, psIdx + numElements + 1, peIdx, inorder, inorderIdx + 1,
                ieIdx,
                map);
        return root;
    }

    /*
    @ TC --> O(N)
    @ SC --> O(N)
    */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length <= 0 || inorder.length <= 0)
            return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < preorder.length; i++)
            map.put(preorder[i], i);
        return constructBinaryTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    public static TreeNode constructBinaryTree(int[] preorder, int psIdx, int peIdx, int[] inorder, int isIdx,
            int ieIdx,
            HashMap<Integer, Integer> map) {
        if (peIdx < psIdx || ieIdx < isIdx)
            return null;
        TreeNode root = new TreeNode(preorder[psIdx]);

        int inorderIdx = map.get(preorder[psIdx]);
        int numElements = inorderIdx - isIdx;

        root.left = constructBinaryTree(preorder, psIdx + 1, psIdx + numElements, inorder, isIdx, inorderIdx - 1, map);
        root.right = constructBinaryTree(preorder, psIdx + numElements + 1, peIdx, inorder, inorderIdx + 1, ieIdx, map);
        return root;
    }

    // ! ============= LC222. Count Complete Tree Nodes ============
    /*
    @ TC --> O(H) --> This is Not equal to N because we are at most going to One side deeper one side we got answer in O(1)
    @ SC --> O(H) --> recursive Stack Space
    */
    public static int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int left = findLeftHeight(root);
        int right = findRightHeight(root);
        if (left == right)
            return (1 << left) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static int findLeftHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.left;
            height++;
        }
        return height;
    }

    public static int findRightHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.right;
            height++;
        }
        return height;
    }

    // ! ============= LC2385. Amount of Time for Binary Tree to Be Infected ============
    /*
    @ TC --> O(N + N)
    @ SC --> O(N + N + N) HashMap + Queue + Visited
    */
    public static TreeNode addParentNodes(TreeNode root, int target, Queue<TreeNode> q,
            HashMap<TreeNode, TreeNode> parents) {
        q.offer(root);
        TreeNode res = new TreeNode(-1);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.val.equals(target))
                res = node;
            if (node.left != null) {
                parents.put(node.left, node);
                q.offer(node.left);
            }
            if (node.right != null) {
                parents.put(node.right, node);
                q.offer(node.right);
            }
        }
        return res;
    }

    public static int amountOfTime(TreeNode root, int start) {

        if (root.left == null && root.right == null)
            return 0;

        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(addParentNodes(root, start, q, parents));
        Set<TreeNode> visited = new HashSet<>();
        int radius = -1;
        while (!q.isEmpty()) {
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
        return radius;
    }

    // ! ============= GFG. Nodes at K Distance from Root ============
    /*
    @ TC --> O(N)
    @ SC --> O(N + H) --> storing result and Stack Space 
    */
    public static ArrayList<Integer> kdistance(TreeNode root, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        kdistanceHelper(root, res, 0, k);
        return res;
    }

    public static void kdistanceHelper(TreeNode root, ArrayList<Integer> res, int level, int k) {
        if (root == null)
            return;

        if (level == k)
            res.add(root.val);

        if (level > k)
            return;
        kdistanceHelper(root.left, res, level + 1, k);
        kdistanceHelper(root.right, res, level + 1, k);
    }
}
// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. GFG. Nodes at K Distance from Root ✅
// 2. LC2385. Amount of Time for Binary Tree to Be Infected ✅
// 3. LC222. Count Complete Tree Nodes ✅
// 4. LC105. Construct Binary Tree from Preorder and Inorder Traversal ✅
