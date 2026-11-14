public class Nov14 {
    // ! ============= LC109. Convert Sorted List to Binary Search Tree ============
    public static TreeNode sortedListToBST(SLLNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return new TreeNode(head.data);

        SLLNode slow = head;
        SLLNode fast = head;
        SLLNode prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        TreeNode rootNode = new TreeNode(slow.data);
        prev.next = null;

        rootNode.left = sortedListToBST(head);
        rootNode.right = sortedListToBST(slow.next);
        return rootNode;
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC109. Convert Sorted List to Binary Search Tree ✅