import java.util.*;

class Node {
    Node left;
    int data;
    Node right;

    public Node(int data) {
        this.left = null;
        this.data = data;
        this.right = null;
    }
}

public class Binary_Search_Tree {
    Node root;

    public Binary_Search_Tree() {
        this.root = null;
    }

    // ! ============= GEN. Insert Element ============
    public void insert(int data) {
        if (root == null) {
            this.root = new Node(data);
            return;
        }
        this.root = insert(root, data);
    }

    public Node insert(Node root, int data) {
        if (root == null)
            return new Node(data);
        if (root.data > data)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);
        return root;
    }

    // ! ============= GEN. Delete Element ============
    public void deleteElement(int data) {
        if (this.root == null)
            return;
        this.root = deleteElement(this.root, data);
    }

    public Node deleteElement(Node root, int data) {
        if (root == null)
            return null;
        if (data < root.data)
            root.left = deleteElement(root.left, data);
        else if (data > root.data)
            root.right = deleteElement(root.right, data);
        else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            int maxdata = getMax(root.left);
            root.data = maxdata;
            deleteElement(maxdata);
        }
        return root;
    }

    // ! ============= GEN. Search Element ============
    public boolean search(int data) {
        if (this.root == null)
            return false;
        return search(this.root, data);
    }

    public boolean search(Node root, int data) {
        if (root == null)
            return false;
        if (data < root.data)
            return search(root.left, data);
        else if (data > root.data)
            return search(root.right, data);
        else
            return true;
    }

    // ! ============= GEN. Get Max ============
    public int getMax() {
        if (root == null)
            return -1;
        if (root.left == null && root.right == null)
            return this.root.data;
        return getMax(this.root.right);
    }

    public int getMax(Node root) {
        if (root.right == null)
            return this.root.data;
        return getMax(root.right);
    }

    // ! ============= GEN. Get Min ============
    public int getMin() {
        if (root == null)
            return -1;
        if (root.left == null && root.right == null)
            return this.root.data;
        return getMin(this.root.left);
    }

    public int getMin(Node root) {
        if (root.left == null)
            return this.root.data;
        return getMin(root.left);
    }

    // ! ============= GEN. preOrder of BST ============
    public void preOrder() {
        if (this.root == null)
            return;
        preOrder(root);
    }

    public void preOrder(Node root) {
        if (root == null) {
            // System.out.print(null + " ");
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    // ! ============= GEN. inOrder of BST ============

    public void inOrder() {
        if (this.root == null)
            return;
        inOrder(root);
    }

    public void inOrder(Node root) {
        if (root == null) {
            // System.out.print(null + " ");
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // ! ============= GEN. postOrder of BST ============

    public void postOrder() {
        if (this.root == null)
            return;
        postOrder(root);
    }

    public void postOrder(Node root) {
        if (root == null) {
            // System.out.print(null + " ");
            return;
        }
        postOrder(root.left);
        System.out.print(root.data + " ");
        postOrder(root.right);
    }

    // ! ============= GEN. postOrder of BST ============
    public void levelOrder() {
        if (this.root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.offer(this.root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node == null) {
                System.out.print(null + " ");
                continue;
            }
            System.out.print(node.data + " ");
            q.offer(node.left);
            q.offer(node.right);
        }
    }
}
