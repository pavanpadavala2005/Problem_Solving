class SegmentNode {
    SegmentNode left;
    int val;
    SegmentNode right;

    int start;
    int end;

    public SegmentNode(int val, int start, int end) {
        this.val = val;
        this.left = null;
        this.right = null;

        this.start = start;
        this.end = end;
    }
}

public class SegmentTreeV1 {
    SegmentNode root;

    public SegmentTreeV1() {
        this.root = null;
    }

    public void insert(int[] nums) {
        this.root = insert(nums, 0, nums.length - 1);
    }

    public SegmentNode insert(int[] nums, int start, int end) {
        if (start >= end)
            return new SegmentNode(nums[start], start, start);

        int mid = start + (end - start) / 2;

        SegmentNode left = insert(nums, start, mid);
        SegmentNode right = insert(nums, mid + 1, end);

        SegmentNode newNode = new SegmentNode(left.val + right.val, start, end);

        newNode.left = left;
        newNode.right = right;
        return newNode;
    }

    public int getRangeSum(int start, int end) {
        return getRangeSum(this.root, start, end);
    }

    private int getRangeSum(SegmentNode node, int targetStart, int targetEnd) {
        if (node == null)
            return 0;

        int nodeStart = node.start;
        int nodeEnd = node.end;

        if (targetStart < nodeStart || targetEnd > nodeEnd)
            return 0;
        if (nodeStart == targetStart && nodeEnd == targetEnd)
            return node.val;

        int nodeMid = nodeStart + (nodeEnd - nodeStart) / 2;

        if (targetEnd <= nodeMid)
            return getRangeSum(node.left, targetStart, targetEnd);
        if (targetStart > nodeMid)
            return getRangeSum(node.right, targetStart, targetEnd);

        return getRangeSum(node.left, targetStart, nodeMid) + getRangeSum(node.right, nodeMid + 1, targetEnd);
    }

    public void updateElement(int index, int newValue) {
        this.root = updateElement(this.root, index, newValue);
    }

    public SegmentNode updateElement(SegmentNode node, int index, int newValue) {
        if (node == null)
            return null;

        int nodeStart = node.start;
        int nodeEnd = node.end;
        if (index < nodeStart || index > nodeEnd) {
            return node;
        }
        if (nodeStart == index && index == nodeEnd) {
            node.val = newValue;
            return node;
        }

        SegmentNode left = updateElement(node.left, index, newValue);
        SegmentNode right = updateElement(node.right, index, newValue);
        node.val = left.val + right.val;

        return node;
    }

    public void inOrder() {
        inOrder(this.root);
    }

    private static void inOrder(SegmentNode node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.val + " [ " + node.start + " , " + node.end + " ]");
        inOrder(node.right);
    }
}