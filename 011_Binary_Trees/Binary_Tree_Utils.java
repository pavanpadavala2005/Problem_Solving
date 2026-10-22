
import java.util.*;

class TreeNode {
    TreeNode left;
    Integer val;
    TreeNode right;

    public TreeNode(Integer val) {
        this.left = null;
        this.val = val;
        this.right = null;
    }
}

public class Binary_Tree_Utils {
    // ! ============= GEN. Utility Method ============

    public TreeNode constructBinaryTree(Integer[] nums) {
        if (nums == null || nums.length <= 0 || nums[0] == null)
            return null;

        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;
        int n = nums.length;

        while (!q.isEmpty() && i < n) {
            TreeNode curr = q.poll();
            if (i < n && nums[i] != null) {
                curr.left = new TreeNode(nums[i]);
                q.offer(curr.left);
            }
            i++;
            if (i < n && nums[i] != null) {
                curr.right = new TreeNode(nums[i]);
                q.offer(curr.right);
            }
            i++;
        }
        return root;
    }
}
