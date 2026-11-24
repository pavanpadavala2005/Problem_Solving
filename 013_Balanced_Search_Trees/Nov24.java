public class Nov24 {
    // ! ============= LC61. Rotate List ============
    public int getLength(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        int n = getLength(head);
        k = k % n;

        ListNode temp = head;
        for (int i = 1; i < n - k; i++)
            temp = temp.next;

        if (temp.next == null)
            return head;

        ListNode temp2 = temp.next;
        ListNode dummy = temp2;
        while (temp2.next != null)
            temp2 = temp2.next;

        temp2.next = head;
        temp.next = null;

        return dummy;
    }

    // ! ============= LC82. Remove Duplicates from Sorted List II ============
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        if (head.next == null)
            return head;

        ListNode main = new ListNode(-1);
        ListNode dummy = main;

        ListNode prev = null;
        ListNode temp = head;

        while (temp != null && temp.next != null) {
            if (temp.val != temp.next.val) {
                if (prev == null || prev.val != temp.val) {
                    dummy.next = temp;
                    dummy = dummy.next;
                }
            }
            prev = temp;
            temp = temp.next;
        }

        if (prev.val != temp.val) {
            dummy.next = temp;
            dummy = dummy.next;
        }

        dummy.next = null;

        return main.next;
    }

    // ! ============= LC86. Partition List ============
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;

        if (head.next == null)
            return head;

        ListNode less = new ListNode(-1);
        ListNode dummy1 = less;

        ListNode great = new ListNode(-1);
        ListNode dummy2 = great;

        ListNode temp = head;
        while (temp != null) {
            if (temp.val < x) {
                dummy1.next = temp;
                dummy1 = dummy1.next;
            } else {
                dummy2.next = temp;
                dummy2 = dummy2.next;
            }
            temp = temp.next;
        }

        dummy2.next = null;

        dummy1.next = great.next;
        return less.next;
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC86. Partition List ✅
// 2. LC82. Remove Duplicates from Sorted List II ✅
// 3. LC61. Rotate List ✅