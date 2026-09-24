
// ! =============== GEN. Non-Linear Linked List Utilities ================
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class NonLinearLinkedListUtils {
    /*
     @ TC --> O(N^2)
     @ SC --> O(1)
    */
    public static NlNode getHead(int[] nums) {
        NonLinearLinkedList nll = new NonLinearLinkedList();
        for (int i : nums)
            nll.insertAtTail(i);
        return nll.head;
    }

    /*
     @ TC --> O(P + K)
     @ SC --> O(1)
    */
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

    /*
     @ TC --> O(N + B)
     @ SC --> O(N + B)
    */
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

    /*
     @ TC --> O(B)
     @ SC --> O(B)
    */
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