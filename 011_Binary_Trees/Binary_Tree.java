import java.util.*;

public class Binary_Tree {
    private class Node {
        Node left;
        int data;
        Node right;

        public Node(int data) {
            this.left = null;
            this.data = data;
            this.right = null;
        }
    }

    Node root;

    public Binary_Tree() {
        this.root = null;
    }

    // ! ============= GEN. Insert into Binary Tree ============
    public void insert(int data) {
        Node newNode = new Node(data);
        if (this.root == null) {
            this.root = newNode;
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(this.root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.left == null) {
                curr.left = new Node(data);
                return;
            } else {
                q.offer(curr.left);
            }

            if (curr.right == null) {
                curr.right = new Node(data);
                return;
            } else {
                q.offer(curr.right);
            }
        }
    }

    // ! ============= GEN. LevelOrder Traversal ============

    public void levelOrder() {
        if (this.root == null) {
            System.out.println("Binary Tree is Empty Can't Print level Order");
            return;
        }

        System.out.print("levelOrder : ");
        Queue<Node> q = new LinkedList<>();
        q.offer(this.root);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data + " ");
            if (curr.left != null)
                q.offer(curr.left);
            if (curr.right != null)
                q.offer(curr.right);
        }
        System.out.println(" ");
    }

    // ! ============= GEN. PreOrder Traversal ============

    public void preOrder() {
        if (this.root == null) {
            System.out.println("Tree is Empty Can't print inroder");
            return;
        }

        System.out.print("preOrder   : ");
        preOrderHelper(this.root);
        System.out.println();
    }

    private void preOrderHelper(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrderHelper(root.left);
        preOrderHelper(root.right);
    }

    // ! ============= GEN. InOrder Traversal ============

    public void inOrder() {
        if (this.root == null) {
            System.out.println("Tree is Empty Can't print inroder");
            return;
        }

        System.out.print("inOrder    : ");
        inOrderHelper(this.root);
        System.out.println();
    }

    private void inOrderHelper(Node root) {
        if (root == null)
            return;
        inOrderHelper(root.left);
        System.out.print(root.data + " ");
        inOrderHelper(root.right);
    }

    // ! ============= GEN. PostOrder Traversal ============

    public void postOrder() {
        if (this.root == null) {
            System.out.println("Tree is Empty Can't print inroder");
            return;
        }

        System.out.print("postOrder  : ");
        postOrderHelper(this.root);
        System.out.println();
    }

    private void postOrderHelper(Node root) {
        if (root == null)
            return;
        postOrderHelper(root.left);
        postOrderHelper(root.right);
        System.out.print(root.data + " ");
    }
}
