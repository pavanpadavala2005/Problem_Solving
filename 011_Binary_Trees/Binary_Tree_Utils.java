
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

class SpecialTreeNode {
    int val;
    SpecialTreeNode left;
    SpecialTreeNode right;
    SpecialTreeNode next;

    public SpecialTreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.next = null;
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

    public SpecialTreeNode constructSpecialTree(Integer[] nums) {
        if (nums.length == 0)
            return null;
        int i = 0;
        SpecialTreeNode spNode = new SpecialTreeNode(nums[i]);
        i++;
        Queue<SpecialTreeNode> q = new LinkedList<>();
        while (!q.isEmpty() && i < nums.length) {
            SpecialTreeNode node = q.poll();
            if (i < nums.length) {
                node.left = new SpecialTreeNode(nums[i]);
                q.offer(node.left);
            }
            i++;
            if (i < nums.length) {
                node.right = new SpecialTreeNode(nums[i]);
                q.offer(node.right);
            }
            i++;
        }
        return spNode;
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
            if (curr == null) {
                System.out.print("null" + " ");
                continue;
            }
            System.out.print(curr.val + " ");
            q.offer(curr.left);

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
