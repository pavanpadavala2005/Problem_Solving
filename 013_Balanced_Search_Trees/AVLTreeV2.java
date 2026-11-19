import java.util.LinkedList;
import java.util.Queue;

class AVLTreeNode {
    AVLTreeNode left;
    int val;
    AVLTreeNode right;
    int height;

    public AVLTreeNode(int val) {
        this.left = null;
        this.right = null;
        this.val = val;
        this.height = 1;
    }
}

public class AVLTreeV2 {
    AVLTreeNode root;

    public AVLTreeV2() {
        this.root = null;
    }

    // ! ============= height Helpers =============
    private int getHeight(AVLTreeNode root) {
        if (root == null)
            return 0;
        return root.height;
    }

    private int updateHeight(AVLTreeNode root) {
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    // ! ============= Right Rotate =============
    public AVLTreeNode rightRotate(AVLTreeNode root) {
        AVLTreeNode temp = root.right;
        root.right = temp.left;
        temp.left = root;

        root.height = updateHeight(root);
        temp.height = updateHeight(temp);

        return temp;
    }

    // ! ============= Left Rotate =============
    public AVLTreeNode leftRotate(AVLTreeNode root) {
        AVLTreeNode temp = root.left;
        root.left = temp.right;
        temp.right = root;

        root.height = updateHeight(root);
        temp.height = updateHeight(temp);

        return temp;
    }

    // ! ============= AVL Rotations =============
    public AVLTreeNode rotate(AVLTreeNode root) {
        int balanceFactor = getHeight(root.left) - getHeight(root.right);
        if (balanceFactor > 1) {
            // Left Heavy
            if (getHeight(root.left.left) >= getHeight(root.left.right))
                return leftRotate(root);
            else {
                root.left = rightRotate(root.left);
                return leftRotate(root);
            }
        } else if (balanceFactor < -1) {
            // Right Heavy
            if (getHeight(root.right.right) >= getHeight(root.right.left))
                return rightRotate(root);
            else {
                root.right = leftRotate(root.right);
                return rightRotate(root);
            }
        }
        return root;
    }

    // ! ============= insert helpers =============
    public void insert(int[] values) {
        for (int i : values)
            this.root = insert(this.root, i);
    }

    public void insert(int val) {
        this.root = insert(this.root, val);
    }

    private AVLTreeNode insert(AVLTreeNode root, int val) {
        if (root == null)
            return new AVLTreeNode(val);

        if (val < root.val)
            root.left = insert(root.left, val);
        else if (val > root.val)
            root.right = insert(root.right, val);

        root.height = updateHeight(root);

        return rotate(root);
    }

    // ! ============= delete helpers =============
    public void deleteNode(int target) {
        this.root = deleteNode(this.root, target);
    }

    public int getMin(AVLTreeNode root) {
        AVLTreeNode temp = root;
        while (temp.left != null)
            temp = temp.left;
        return temp.val;
    }

    public AVLTreeNode deleteNode(AVLTreeNode root, int target) {
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
        }
        root.height = updateHeight(root);
        return rotate(root);
    }

    // ! ============= DFS helpers =============
    public void levelOrder() {
        levelOrderHelper(root);
    }

    private void levelOrderHelper(AVLTreeNode root) {
        if (root == null)
            return;

        Queue<AVLTreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            AVLTreeNode node = q.poll();
            System.out.println(node.val);

            if (node.left != null)
                q.offer(node.left);
            if (node.right != null)
                q.offer(node.right);
        }
    }

    public void inOrder() {
        inOrder(this.root);
    }

    private void inOrder(AVLTreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

}
