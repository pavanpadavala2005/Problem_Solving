
import java.util.*;

public class Oct22 {
    // ! ============= LC104. Maximum Depth of Binary Tree ============
    /*
    @ TC --> O(N)
    @ SC --> O(1) + O(N)  --> recursive stack Space ( ignorable )
    */
    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static int maxDepthBrute(TreeNode root) {
        if (root == null)
            return 0;
        int depth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            depth++;

            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
        }
        return depth;
    }

    // ! ============= GEN. PreOrder InOrder PostOrder ============

    /*
    @ TC --> 
    @ SC --> 
    */

    public record Pair(TreeNode node, Integer value) {
    }

    public static List<List<Integer>> threeTraversals(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));
        while (!st.isEmpty()) {
            Pair top = st.pop();
            TreeNode node = top.node;
            int value = top.value;

            if (value == 1) {
                preOrder.add(node.val);
                st.push(new Pair(node, value + 1));
                if (node.left != null) {
                    st.push(new Pair(node.left, 1));
                }
            } else if (value == 2) {
                inOrder.add(node.val);
                st.push(new Pair(node, value + 1));
                if (node.right != null) {
                    st.push(new Pair(node.right, 1));
                }
            } else {
                postOrder.add(value);
            }
        }
        return new ArrayList<>(List.of(preOrder, inOrder, postOrder));
    }

    // ! ============= LC144. Binary Tree Preorder Traversal ============
    /*
    @ TC --> O(N) 
    @ SC --> O(N)
    */
    public static List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode curr = st.pop();
            res.add(curr.val);
            if (curr.right != null)
                st.push(curr.right);
            if (curr.left != null)
                st.push(curr.left);
        }
        return res;
    }

    /*
    @ TC --> O(N) --> At most we are visiting Number of Nodes (N)
    @ SC --> O(N)ddd
    */
    public static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrderTraversalHelper(root, res);
        return res;
    }

    public static void preOrderTraversalHelper(TreeNode root, List<Integer> list) {
        list.add(root.val);
        if (root.left != null)
            preOrderTraversalHelper(root.left, list);
        if (root.right != null)
            preOrderTraversalHelper(root.right, list);
    }

    // ! ============= LC94. Binary Tree Inorder Traversal ============
    /*
    @ TC --> O(N)
    @ SC --> O(N)    
    */
    public static List<Integer> inorderTraversalIterativeV2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            TreeNode node = st.pop();
            res.add(node.val);
            curr = node.right;
        }
        return res;
    }

    /*
    @ TC --> O(N)
    @ SC --> O(N)    
    */
    public static List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while (true) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                if (st.isEmpty())
                    break;
                TreeNode node = st.pop();
                res.add(node.val);
                curr = node.right;
            }
        }
        return res;
    }

    /*
    @ TC --> O(N) --> At most we are visiting Number of Nodes (N)
    @ SC --> O(N)ddd
    */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrderTraversalHelper(root, res);
        return res;
    }

    public static void inOrderTraversalHelper(TreeNode root, List<Integer> list) {
        if (root.left != null)
            inOrderTraversalHelper(root.left, list);
        list.add(root.val);
        if (root.right != null)
            inOrderTraversalHelper(root.right, list);
    }

    // ! ============= LC145. Binary Tree Postorder Traversal ============
    /*
    @ TC --> O(N) --> At most we are visiting Number of Nodes (N)
    @ SC --> O(N)ddd
    */
    public static List<Integer> postOrderTraversalIterativeV1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<TreeNode> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        st1.push(root);
        while (!st1.isEmpty()) {
            TreeNode node = st1.pop();
            st2.push(node.val);
            if (node.left != null)
                st1.push(node.left);
            if (node.right != null)
                st1.push(node.right);
        }
        while (!st2.isEmpty())
            res.add(st2.pop());
        return res;
    }

    /*
    @ TC --> O(N) --> At most we are visiting Number of Nodes (N)
    @ SC --> O(N)ddd
    */
    public static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrderTraversalHelper(root, res);
        return res;
    }

    public static void postOrderTraversalHelper(TreeNode root, List<Integer> list) {
        list.add(root.val);
        if (root.left != null)
            postOrderTraversalHelper(root.left, list);
        if (root.right != null)
            postOrderTraversalHelper(root.right, list);
    }

}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC94. Binary Tree Inorder Traversal ✅
// 2. LC144. Binary Tree Preorder Traversal ✅
// 3. LC145. Binary Tree Postorder Traversal ✅
// 4. GEN. PreOrder InOrder PostOrder ✅
// 5. LC104. Maximum Depth of Binary Tree ✅