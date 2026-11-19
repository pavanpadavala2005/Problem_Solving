import java.util.*;

public class Nov19 {
    // ! ============= LC1382. Balance a Binary Search Tree ============
    public void inOrder(TreeNode root, List<Integer> lis) {
        if (root == null)
            return;
        inOrder(root.left, lis);
        lis.add(root.val);
        inOrder(root.right, lis);
    }

    public TreeNode constructBst(List<Integer> lis, int sIdx, int eIdx) {
        if (sIdx > eIdx)
            return null;

        if (sIdx == eIdx)
            return new TreeNode(lis.get(sIdx));

        int mid = sIdx + (eIdx - sIdx) / 2;

        TreeNode root = new TreeNode(lis.get(mid));

        root.left = constructBst(lis, sIdx, mid - 1);
        root.right = constructBst(lis, mid + 1, eIdx);

        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> lis = new ArrayList<>();

        inOrder(root, lis);

        return constructBst(lis, 0, lis.size() - 1);
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC1382. Balance a Binary Search Tree ✅