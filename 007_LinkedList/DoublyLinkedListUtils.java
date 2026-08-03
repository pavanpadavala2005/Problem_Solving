import java.util.ArrayList;

public class DoublyLinkedListUtils {
    public static DNode getHead(int[] nums) {
        DoublyLinkedList dll = new DoublyLinkedList();
        for (int i : nums)
            dll.insertAtTail(i);
        return dll.head;
    }

    public static DNode getDNode(DNode head, int target) {
        DNode temp = head;
        while (temp != null) {
            if (temp.data == target)
                break;
            temp = temp.next;
        }
        return temp;
    }

    public static ArrayList getList(DNode head) {
        ArrayList<Integer> res = new ArrayList<>();
        DNode temp = head;
        while (temp != null) {
            res.add(temp.data);
            temp = temp.next;
        }
        return res;
    }
}
