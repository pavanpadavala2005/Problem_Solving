import java.util.Stack;

public class Nov21 {
    // ! ============= LC1019. Next Greater Node In Linked List ============
    public void getNGE(int[] res, int i, ListNode head, Stack<Integer> st) {
        if (head == null)
            return;

        getNGE(res, i + 1, head.next, st);
        while (!st.isEmpty() && st.peek() <= head.val)
            st.pop();

        if (!st.isEmpty())
            res[i] = st.peek();

        st.push(head.val);
    }

    public int[] nextLargerNodes(ListNode head) {
        if (head == null)
            return new int[0];

        if (head.next == null)
            return new int[1];

        ListNode temp = head;
        int n = 0;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        getNGE(res, 0, head, st);
        return res;
    }
}
// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC1019. Next Greater Node In Linked List ✅