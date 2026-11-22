class TwoThreeNode {
    int key1;
    int key2;

    int keyCount;

    TwoThreeNode[] children;
    TwoThreeNode parent;

    public TwoThreeNode(int key) {
        this.key1 = key;
        this.key2 = 0;

        this.keyCount = 1;

        this.children = new TwoThreeNode[3];
        this.parent = null;
    }

    public boolean isLeaf() {
        return this.children[0] == null &&
                this.children[1] == null &&
                this.children[2] == null;
    }

    public boolean isTwoNode() {
        return this.keyCount == 1;
    }

    public boolean isThreeNode() {
        return this.keyCount == 2;
    }
}

public class TwoThreeTree {

    TwoThreeNode root;

    public TwoThreeTree() {
        this.root = null;
    }

    public void insert(int val) {
        if (this.root == null) {
            this.root = new TwoThreeNode(val);
            return;
        }

    }

    // private TwoThreeNode insert(TwoThreeNode node, int val) {
    //     if (node == null)
    //         return new TwoThreeNode(val);

    // }
}