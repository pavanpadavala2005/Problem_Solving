
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    TreeNode left;
    int val;
    TreeNode right;

    public TreeNode(int val) {
        this.left = null;
        this.val = val;
        this.right = null;
    }
}

public class Binary_Search_Tree_Utils {

    public TreeNode constructBST(Integer[] nums) {
        TreeNode root = null;
        for (int i : nums)
            root = insert(root, i);
        return root;
    }

    public TreeNode insert(TreeNode root, int data) {
        if (root == null)
            return new TreeNode(data);
        if (data < root.val)
            root.left = insert(root.left, data);
        else if (data > root.val)
            root.right = insert(root.right, data);
        return root;
    }

    public void levelOrder(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.print(node.val + " ");
            if (node.left != null)
                q.offer(node.left);
            if (node.right != null)
                q.offer(node.right);
        }
        System.out.println();
    }
}
