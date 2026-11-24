
import java.util.*;

// ! Max in a Range Segment Tree

public class SegmentTreeV3 {
    SegmentNode root;

    public SegmentTreeV3() {
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

        SegmentNode newNode = new SegmentNode(Math.max(left.val, right.val), start, end);

        newNode.left = left;
        newNode.right = right;
        return newNode;
    }

    public int getRangeMax(int start, int end) {
        return getRangeMax(this.root, start, end);
    }

    private int getRangeMax(SegmentNode node, int targetStart, int targetEnd) {
        if (node == null)
            return 0;

        int nodeStart = node.start;
        int nodeEnd = node.end;

        if (targetEnd < nodeStart || targetStart > nodeEnd)
            return 0;

        if (nodeStart <= targetStart && nodeEnd <= targetEnd)
            return node.val;

        return Math.max(getRangeMax(node.left, targetStart, targetEnd),
                getRangeMax(node.right, targetStart, targetEnd));
    }

    public void updateElement(int index, int newValue) {
        this.root = updateElement(this.root, index, newValue);
    }

    public SegmentNode updateElement(SegmentNode node, int index, int newValue) {

        if (node == null)
            return null;

        int nodeStart = node.start;
        int nodeEnd = node.end;

        if (index < nodeStart || index > nodeEnd)
            return node;

        if (nodeStart == nodeEnd) {
            node.val = newValue;
            return node;
        }

        if (index <= nodeStart)
            updateElement(node.left, index, newValue);
        else
            updateElement(node.right, index, newValue);

        node.val = Math.max(node.left.val, node.right.val);
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

    public void levelOrder() {
        if (this.root == null)
            return;
        Queue<SegmentNode> q = new LinkedList<>();
        q.offer(this.root);
        while (!q.isEmpty()) {
            SegmentNode node = q.poll();
            System.out.println(node.val + " [ " + node.start + " , " + node.end + " ]");
            if (node.left != null)
                q.offer(node.left);
            if (node.right != null)
                q.offer(node.right);
        }
    }
}