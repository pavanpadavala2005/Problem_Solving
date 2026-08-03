
import java.util.ArrayList;
import java.util.List;

public class Aug01 {

    // ! ============== REMOVE DUPLICATES FROM LINKED LIST ==========
    public static Node removeDuplicatesOptimal(Node head) {
        Node temp = head;
        while (temp != null && temp.next != null)
            if (temp.data == temp.next.data)
                temp.next = temp.next.next;
            else
                temp = temp.next;
        return head;
    }

    public static Node removeDuplicatesBrute(Node head) {
        if (head == null || head.next == null)
            return head;
        Node i = head;
        Node j = head;
        while (j != null) {
            if (i.data != j.data) {
                i = i.next;
                i.data = j.data;
            }
            j = j.next;
        }
        i.next = null;
        return head;
    }

    // ! =============== FLATTEN LINKED LIST V2 ======================
    public static NlNode flattenListV2(NlNode head) {
        if (head == null || head.next == null)
            return head;
        NlNode rightPart = flattenList(head.next);
        return mergeListsV2(head, rightPart);
    }

    public static NlNode mergeListsV2(NlNode head1, NlNode head2) {
        NlNode temp = new NlNode(-1);
        NlNode dummy = temp;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                dummy.bottom = head1;
                head1.next = null;
                head1 = head1.bottom;
            } else {
                dummy.bottom = head2;
                head2.next = null;
                head2 = head2.bottom;
            }
            dummy = dummy.bottom;
        }
        if (head1 != null)
            dummy.bottom = head1;
        if (head2 != null)
            dummy.bottom = head2;
        return temp.bottom;
    }

    // ! =============== FLATTEN LINKED LIST ======================
    public static NlNode flattenList(NlNode head) {
        if (head == null || head.next == null)
            return head;
        NlNode mergedHead = flattenList(head.next);
        head.next = null;
        return mergeLists(head, mergedHead);
    }

    public static NlNode mergeLists(NlNode head1, NlNode head2) {
        NlNode temp = new NlNode(-1);
        NlNode dummy = temp;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                dummy.bottom = head1;
                head1 = head1.bottom;
            } else {
                dummy.bottom = head2;
                head2 = head2.bottom;
            }
            dummy = dummy.bottom;
        }
        if (head1 != null)
            dummy.bottom = head1;
        if (head2 != null)
            dummy.bottom = head2;
        return temp.bottom;
    }

    // ! ================= PAIRS WITH GIVEN TARGET =================
    public static ArrayList<ArrayList<Integer>> pairsWithTargetSum(DNode head, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (head == null)
            return res;
        DNode tail = head;
        while (tail.next != null)
            tail = tail.next;
        while (head != tail && head.prev != tail) {
            int sum = head.data + tail.data;
            if (sum > target) {
                tail = tail.prev;
            } else if (sum < target) {
                head = head.next;
            } else {
                res.add(new ArrayList<>(List.of(head.data, tail.data)));
                head = head.next;
                tail = tail.prev;
            }
        }
        return res;
    }
}
