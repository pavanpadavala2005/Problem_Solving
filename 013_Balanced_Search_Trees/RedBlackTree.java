class RBNode {
    RBNode left;
    RBNode right;
    RBNode parent;
    int val;
    boolean isRed;

    public RBNode(int val) {
        this.left = null;
        this.right = null;
        this.parent = null;
        this.val = val;
        this.isRed = true;
    }

}

public class RedBlackTree {
    RBNode root;

    public RedBlackTree() {
        this.root = null;
    }

}
