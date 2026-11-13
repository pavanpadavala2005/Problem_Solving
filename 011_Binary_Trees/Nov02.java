import java.util.HashMap;

public class Nov02 {
    // ! ============= LC889. Construct Binary Tree from Preorder and Postorder Traversal ============
    /*
    @ TC --> O(N)
    @ SC --> O(N)
    */
    public static TreeNode constructFromPrePostBetter(int[] preOrder, int[] postOrder) {
        int n = postOrder.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(postOrder[i], i);
        return construct(preOrder, 0, n - 1, postOrder, 0, n - 1, map);
    }

    public static TreeNode construct(int[] preOrder, int preStart, int preEnd, int[] postOrder, int postStart,
            int postEnd, HashMap<Integer, Integer> map) {
        if (preStart > preEnd)
            return null;
        TreeNode root = new TreeNode(preOrder[preStart]);

        if (preStart == preEnd)
            return root;

        int leftRoot = preOrder[preStart + 1];
        int idx = map.get(leftRoot);
        int size = idx - postStart + 1;

        root.left = construct(preOrder, preStart + 1, preStart + size, postOrder, postStart, idx, map);
        root.right = construct(preOrder, preStart + 1 + size, preEnd, postOrder, idx + 1, postEnd - 1, map);

        return root;
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC889. Construct Binary Tree from Preorder and Postorder Traversal ✅