
class RBNode {
    RBNode parent;
    RBNode left;
    RBNode right;
    int val;
    boolean isRed;

    public RBNode(int val) {
        this.parent = null;
        this.left = null;
        this.right = null;
        this.val = val;
        this.isRed = true;
    }

}

public class RedBlackTree {
    RBNode root;

    public RedBlackTree() {
        this.root = null;
    }

    public void rightRotate(RBNode node) {
        RBNode temp = node.left;
        node.left = temp.right;

        if (temp.right != null)
            temp.right.parent = node;

        temp.parent = node.parent;

        if (node.parent == null)
            // if there is no parent for node
            this.root = temp;

        else if (node.parent.left == node)
            // if node is Left Child
            node.parent.left = temp;
        else
            // if node is Right Child
            node.parent.right = temp;

        temp.right = node;
        node.parent = temp;
    }

    public void leftRotate(RBNode node) {
        RBNode temp = node.right;
        node.right = temp.left;

        if (temp.left != null)
            temp.left.parent = node;

        temp.parent = node.parent;

        if (node.parent == null)
            this.root = temp;
        else if (node.parent.left == node)
            node.parent.left = temp;
        else
            node.parent.right = temp;

        temp.left = node;
        node.parent = temp;
    }

}
