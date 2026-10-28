
import java.util.*;

class TreeNode {
    TreeNode left;
    Integer val;
    TreeNode right;

    public TreeNode(Integer val) {
        this.left = null;
        this.val = val;
        this.right = null;
    }
}

public class Binary_Tree_Utils {
    // ! ============= GEN. Utility Method ============

    public TreeNode constructBinaryTree(Integer[] nums) {
        if (nums == null || nums.length <= 0 || nums[0] == null)
            return null;

        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;
        int n = nums.length;

        while (!q.isEmpty() && i < n) {
            TreeNode curr = q.poll();
            if (i < n && nums[i] != null) {
                curr.left = new TreeNode(nums[i]);
                q.offer(curr.left);
            }
            i++;
            if (i < n && nums[i] != null) {
                curr.right = new TreeNode(nums[i]);
                q.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    public void levelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("Binary Tree is Empty Can't Print level Order");
            return;
        }
        System.out.print("levelOrder : ");
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            System.out.print(curr.val + " ");
            if (curr.left != null)
                q.offer(curr.left);
            if (curr.right != null)
                q.offer(curr.right);
        }
        System.out.println(" ");
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is Empty Can't print inroder");
            return;
        }

        System.out.print("preOrder   : ");
        preOrderHelper(root);
        System.out.println();
    }

    private void preOrderHelper(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        preOrderHelper(root.left);
        preOrderHelper(root.right);
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is Empty Can't print inroder");
            return;
        }

        System.out.print("inOrder    : ");
        inOrderHelper(root);
        System.out.println();
    }

    private void inOrderHelper(TreeNode root) {
        if (root == null)
            return;
        inOrderHelper(root.left);
        System.out.print(root.val + " ");
        inOrderHelper(root.right);
    }
}
