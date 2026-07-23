
public class Demo {
    public static void main(String[] args) {

        // !============ July 21 Stuff ============
        Node head = LinkedListUtils.getHead(new int[] {
                1, 2, 3, 4, 5, 6
        });
        LinkedListUtils.keepCycle(head, 2);
        Node target = LinkedListUtils.getNode(
                head,
                //
                5
        //
        );

        // ! July 21 Stuff
        // System.out.println(July21.middleOfLinkedListBrute(head).data);
        // System.out.println(July21.getList(head));

        // System.out.println(July21.getList(July21.reverseLinkedListOptimal(head)));
        // System.out.println(July21.getList(July21.reverseLinkedListRec(null, head,
        // head)));

        // ! July 22 Stuff
        // System.out.println(July22.hasCycleBrute(head));
        System.out.println(July22.startingNodeOfCycle(head).data);
    }
}
