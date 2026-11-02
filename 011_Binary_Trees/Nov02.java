
import java.util.HashMap;

public class Nov02 {
    // TODO:
    // ! ============= LC889. Construct Binary Tree from Preorder and Postorder Traversal ============
    // TODO:

    public static TreeNode constructFromPrePost(int[] preOrder, int[] postOrder) {
        int n = preOrder.length;
        int m = postOrder.length;
        if (n <= 0 || m <= 0)
            return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++)
            map.put(postOrder[i], i);
        return construct(preOrder, 0, n - 1, postOrder, 0, m - 1, map);
    }

    public static TreeNode construct(int[] preOrder, int prsIdx, int preIdx, int[] postOrder, int posIdx, int poeIdx,
            HashMap<Integer, Integer> map) {
        if (prsIdx > preIdx)
            return null;
        TreeNode root = new TreeNode(preOrder[prsIdx]);
        if (prsIdx == preIdx)
            return root;
        int leftIdx = -1;
        if (prsIdx + 1 <= preIdx)
            leftIdx = map.get(preOrder[prsIdx + 1]);
        int numElements = leftIdx - posIdx + 1;
        root.left = construct(preOrder, prsIdx + 1, prsIdx + numElements, postOrder, posIdx, leftIdx, map);
        root.right = construct(preOrder, prsIdx + numElements + 1, preIdx, postOrder, leftIdx + 1, poeIdx - 1,
                map);
        return root;
    }

    // ! ============= LC226. Invert Binary Tree ============

}
