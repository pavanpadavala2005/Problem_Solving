
import java.util.Stack;

public class Nov13 {

    // ! ============= LC617. Merge Two Binary Trees ============
    /*
    @ TC --> O(N)
    @ SC --> O(H)
    */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;

        if (root1 == null && root2 == null)
            return null;

        TreeNode root = new TreeNode(root1.val + root2.val);

        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);

        return root;
    }

    // ! ============= GFG. Closest in BST ============
    /*
    @ TC -->O(H)
    @ SC -->O(H)
    */
    public static int minDiff(Node root, int k) {
        if (root == null)
            return Integer.MAX_VALUE;

        if (root.data > k)
            return Math.min(Math.abs(root.data - k), minDiff(root.left, k));

        else if (root.data < k)
            return Math.min(Math.abs(root.data - k), minDiff(root.right, k));

        else
            return 0;
    }

    // ! ============= LC173. Binary Search Tree Iterator ============
    /*
    @ TC --> O(log N)
    @ SC --> O(1)
    */
    class BSTIteratorOptimal {
        Stack<TreeNode> st = new Stack<>();

        public BSTIteratorOptimal(TreeNode root) {
            goLeft(root);
        }

        public void goLeft(TreeNode node) {
            TreeNode temp = node;
            while (temp != null) {
                this.st.push(temp);
                temp = temp.left;
            }
        }

        public int next() {
            TreeNode node = this.st.pop();
            if (node.right != null)
                goLeft(node.right);
            return node.val;
        }

        public boolean hasNext() {
            return !st.isEmpty();
        }
    }

    /*
    @ TC --> O(N + 1) for the first time O(N) and every time O(1)
    @ SC --> O(1 + N) --> Using Morris Method so O(1) + O(N) for stack 
    */
    public class BSTIteratorBrute {
        TreeNode root;
        Stack<TreeNode> st;

        public BSTIteratorBrute(TreeNode root) {
            this.root = root;
            this.st = new Stack<>();

            TreeNode temp = root;
            while (temp != null) {
                if (temp.right == null) {
                    this.st.push(temp);
                    temp = temp.left;
                } else {
                    TreeNode curr = temp.right;
                    while (curr.left != null && curr.left != temp)
                        curr = curr.left;
                    if (curr.left == null) {
                        curr.left = temp;
                        temp = temp.right;
                    } else {
                        curr.left = null;
                        this.st.push(temp);
                        temp = temp.left;
                    }
                }
            }
        }

        public int next() {
            if (hasNext())
                return st.pop().val;
            return -1;
        }

        public boolean hasNext() {
            return !st.isEmpty();
        }
    }
}
// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC173. Binary Search Tree Iterator ✅
// 2. GFG. Closest in BST ✅
// 3. LC617. Merge Two Binary Trees ✅