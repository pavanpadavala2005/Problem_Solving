import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    TreeNode left;
    int val;
    TreeNode right;

    public TreeNode(int val) {
        this.left = null;
        this.val = val;
        this.right = null;
    }
}

public class AVLTreeV1 {
    TreeNode root;

    public AVLTreeV1() {
        this.root = null;
    }

    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return 1 + Math.max(left, right);
    }

    // ! ============ Right Rotate ============
    public TreeNode rightRotate(TreeNode root) {
        TreeNode temp = root.right;
        root.right = temp.left;
        temp.left = root;
        return temp;
    }

    // ! ============ Left Rotate ============
    public TreeNode leftRotate(TreeNode root) {
        TreeNode temp = root.left;
        root.left = temp.right;
        temp.right = root;
        return temp;
    }

    // ! ============ AVL Rotations ============
    public TreeNode rotate(TreeNode root) {
        int balanceFactor = getHeight(root.left) - getHeight(root.right);

        if (balanceFactor > 1) {
            if (getHeight(root.left.left) >= getHeight(root.left.right)) {
                // LL Rotate   <-- Direction
                return leftRotate(root);
            } else {
                // LR Rotate  <-- Direction
                root.left = rightRotate(root.left);
                return leftRotate(root);
            }
        } else if (balanceFactor < -1) {
            if (getHeight(root.right.right) >= getHeight(root.right.left)) {
                // RR Rotate <-- Direction
                return rightRotate(root);
            } else {
                // RL Rotate <-- Direction
                root.right = leftRotate(root.right);
                return leftRotate(root);
            }
        }
        return root;
    }

    // ! ============ Delete Node ============
    public int getMin(TreeNode root) {
        TreeNode temp = root;
        while (temp.left != null)
            temp = temp.left;
        return temp.val;
    }

    public void deleteNode(int target) {
        this.root = deleteNode(this.root, target);
    }

    private TreeNode deleteNode(TreeNode root, int target) {
        if (root == null)
            return null;
        if (target < root.val)
            root.left = deleteNode(root.left, target);
        else if (target > root.val)
            root.right = deleteNode(root.right, target);
        else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;

            int minVal = getMin(root.right);
            root.val = minVal;
            root.right = deleteNode(root.right, minVal);
            return root;
        }
        return rotate(root);
    }

    // ! ============ Insert Node ============
    public void insert(int[] values) {
        for (int i : values)
            this.root = insertHelper(this.root, i);
    }

    public void insert(int val) {
        this.root = insertHelper(this.root, val);
    }

    public TreeNode insertHelper(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (val < root.val)
            root.left = insertHelper(root.left, val);
        else if (val > root.val)
            root.right = insertHelper(root.right, val);
        return rotate(root);
    }

    // ! ============ inorder ============

    public void inorder() {
        inorderHelper(this.root);
    }

    public void inorderHelper(TreeNode root) {
        if (root == null)
            return;
        inorderHelper(root.left);
        System.out.println(root.val);
        inorderHelper(root.right);
    }

    public void levelOrder() {
        levelOrderHelper(this.root);
    }

    public void levelOrderHelper(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.println(node.val);
            if (node.left != null)
                q.offer(node.left);
            if (node.right != null)
                q.offer(node.right);
        }
    }
}
