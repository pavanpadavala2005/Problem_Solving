
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

    public void rightRotate(RBNode root) {
        RBNode temp = root.left;
        root.left = temp.right;

        if (temp.right != null)
            temp.right.parent = root;

        temp.parent = root.parent;
        if (root.parent == null)
            // if there is no parent for root
            root = temp;
        else if (root.parent.left == root)
            // if Root is Left Child
            root.parent.left = temp;
        else
            // if Root is Right Child
            root.parent.right = temp;

        temp.right = root;
        root.parent = temp;
    }

    public void leftRotate(RBNode root) {
        RBNode temp = root.right;

        root.right = temp.left;

        if (temp.left != null)
            temp.left.parent = root;
        temp.parent = root.parent;

        if (root.parent == null)
            // if root Parent is Null
            root = temp;
        else if (root.parent.right == root)
            // If there in No right for the Root
            root.parent.right = temp;
        else
            // If there in No left for the Root
            root.parent.left = temp;

        temp.left = root;
        root.parent = temp;
    }

    public void insertNode(RBNode newNode) {
        RBNode parent = null;
        RBNode curr = this.root;

        while (curr != null) {
            parent = curr;
            if (newNode.val < curr.val)
                curr = curr.left;
            else if (newNode.val > curr.val)
                curr = curr.right;
            else
                return;
        }

        newNode.parent = parent;

        if (parent == null)
            this.root = newNode;
        else if (newNode.val < parent.val)
            parent.left = newNode;
        else
            parent.right = newNode;
    }

    public void fixInsert(RBNode node) {
        while (node != this.root && node.parent.isRed) {
            RBNode parent = node.parent;
            RBNode grandParent = parent.parent;
            if (parent == grandParent.left) {
                RBNode uncle = grandParent.right;
                if (uncle != null && uncle.isRed) {
                    uncle.isRed = false;
                    parent.isRed = false;
                    grandParent.isRed = true;

                    node = grandParent;
                } else {
                    // if (node = parent.right) {

                    // }
                }
            }
        }
    }

    public RBNode insertNodeRec(RBNode parent, RBNode root, int val) {
        if (root == null) {
            RBNode newNode = new RBNode(val);
            newNode.parent = parent;
            if (parent == null)
                return newNode;
            else if (newNode.val < parent.val)
                parent.left = newNode;
            else
                parent.right = newNode;
            return newNode;
        }

        if (val < root.val)
            root.left = insertNodeRec(root, root.left, val);
        else if (val > root.val)
            root.right = insertNodeRec(root, root.right, val);
        else
            return root;
        return root;
    }

}
