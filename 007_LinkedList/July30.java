public class July30 {
    // ! ============= REVERSE LL II ============
    public static Node reverseLinkedListIIV2(Node head, int start, int end) {
        if (head == null || head.next == null || start == end)
            return head;
        Node dummy = new Node();
        Node before = dummy;
        for (int i = 1; i < start; i++)
            before = before.next;
        Node curr = before.next;
        Node first = curr;
        Node prev = null;
        for (int j = 0; j < end - start + 1; j++) {
            Node next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        before.next = prev;
        first.next = curr;
        return dummy.next;
    }

    public static Node reverseLinkedListIIV1(Node head, int start, int end) {
        Node temp = head;
        while (temp != null && start > 1) {
            start--;
            temp = temp.next;
        }
        Node temp1 = temp;
        int diff = end - start;
        while (temp1 != null && diff > 1) {
            diff--;
            temp1 = temp1.next;
        }
        Node prev = null;
        Node after = temp;
        while (temp1 != null) {
            after = temp.next;
            temp.next = prev;

            prev = temp;
            temp = after;
            // temp = temp.next;
            temp1 = temp1.next;
        }
        System.out.println(SinglyLinkedListUtils.getList(prev));
        // return head;
        return null;
    }

}