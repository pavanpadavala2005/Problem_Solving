
// ! =============== GENERAL. Non-Linear Linked List Utilities ================
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class NonLinearLinkedListUtils {
    // @ Time Complexity: O(N^2)
    // @ Space Complexity: O(1)
    public static NlNode getHead(int[] nums) {
        NonLinearLinkedList nll = new NonLinearLinkedList();
        for (int i : nums)
            nll.insertAtTail(i);
        return nll.head;
    }

    // @ Time Complexity: O(P + K)
    // @ Space Complexity: O(1)
    public static void putBottomList(NlNode head, int pos, int[] nums) {
        NlNode temp = head;
        while (temp != null && pos > 1) {
            temp = temp.next;
            pos--;
        }
        if (temp == null)
            return;
        NlNode bottomTemp = temp;
        for (int i = 0; i < nums.length; i++) {
            bottomTemp.bottom = new NlNode(nums[i]);
            bottomTemp = bottomTemp.bottom;
        }
    }

    // @ Time Complexity: O(N + B)
    // @ Space Complexity: O(N + B)
    public static LinkedHashMap<Integer, ArrayList<Integer>> getList(NlNode head) {
        LinkedHashMap<Integer, ArrayList<Integer>> res = new LinkedHashMap<>();
        NlNode temp = head;
        while (temp != null) {
            ArrayList<Integer> elems = new ArrayList<>();
            if (temp.bottom != null) {
                NlNode bottomTemp = temp.bottom;
                while (bottomTemp != null) {
                    elems.add(bottomTemp.data);
                    bottomTemp = bottomTemp.bottom;
                }
            }
            res.put(temp.data, elems);
            temp = temp.next;
        }
        return res;
    }

    // @ Time Complexity: O(B)
    // @ Space Complexity: O(B)
    public static ArrayList<Integer> getChildList(NlNode head) {
        ArrayList<Integer> res = new ArrayList<>();
        NlNode temp = head;
        while (temp != null) {
            res.add(temp.data);
            temp = temp.bottom;
        }
        return res;
    }
}