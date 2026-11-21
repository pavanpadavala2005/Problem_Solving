
import java.util.LinkedList;
import java.util.Queue;

class SplayNode {
    SplayNode left;
    int val;
    SplayNode right;

    public SplayNode(int val) {
        this.left = null;
        this.val = val;
        this.right = null;
    }
}

public class SplayTree {
    SplayNode root;

    public SplayTree() {
        this.root = null;
    }

    private SplayNode zigRotate(SplayNode node) {
        SplayNode temp = node.left;

        node.left = temp.right;
        temp.right = node;
        return temp;
    }

    private SplayNode zagRotate(SplayNode node) {
        SplayNode temp = node.right;

        node.right = temp.left;
        temp.left = node;
        return temp;
    }

    private SplayNode splay(SplayNode node, int key) {
        if (node == null || node.val == key)
            return node;

        if (key < node.val) {

            if (node.left == null)
                return node;

            if (key < node.left.val) {
                // Zig Rotate (Right Rotate)
                node.left.left = splay(node.left.left, key);
                node = zigRotate(node);
            } else if (key > node.left.val) {
                // Zag Rotate (Left Rotate)
                node.left.right = splay(node.left.right, key);

                if (node.left.right != null)
                    node.left = zagRotate(node.left);
            }

            if (node.left == null)
                return node;
            // Zig (Right Rotate)  -> remaining rotation performed Here
            return zigRotate(node);

        } else {
            if (node.right == null)
                return node;

            if (key > node.right.val) {
                // Zag Rotate ( Left Rotate)
                node.right.right = splay(node.right.right, key);
                node = zagRotate(node);

            } else if (key < node.right.val) {
                // Zig Rotate (Right Rotate)
                node.right.left = splay(node.right.left, key);
                if (node.right.left != null)
                    node.right = zigRotate(node.right);
            }

            if (node.right == null)
                return node;
            else
                // Zag Rotate ( Left Rotate ) -> remaining rotation performed Here
                return zagRotate(node);
        }
    }

    private SplayNode insert(SplayNode node, int key) {

        if (node == null)
            return new SplayNode(key);

        node = splay(node, key);

        if (node.val == key)
            return node;

        SplayNode newNode = new SplayNode(key);

        if (key < node.val) {
            newNode.left = node.left;
            newNode.right = node;
            node.left = null;
        } else {
            newNode.right = node.right;
            newNode.left = node;
            node.right = null;
        }
        return newNode;
    }

    public void insert(int val) {
        this.root = insert(this.root, val);
    }

    public boolean search(int target) {
        if (this.root == null)
            return false;
        SplayNode node = splay(this.root, target);
        return node.val == target;
    }

    public void delete(int key) {

        if (root == null) {
            return;
        }

        root = splay(root, key);

        if (root.val != key) {
            return;
        }

        if (root.left == null) {
            root = root.right;
        }

        else {

            SplayNode rightSubtree = root.right;

            root = splay(root.left, key);

            root.right = rightSubtree;
        }
    }

    public void inOrder() {
        inOrder(this.root);
    }

    private void inOrder(SplayNode node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    public void levelOrder() {
        if (this.root == null)
            return;
        Queue<SplayNode> q = new LinkedList<>();
        q.offer(this.root);
        while (!q.isEmpty()) {
            SplayNode node = q.poll();
            System.out.println(node.val);
            if (node.left != null)
                q.offer(node.left);
            if (node.right != null)
                q.offer(node.right);
        }
    }

}
