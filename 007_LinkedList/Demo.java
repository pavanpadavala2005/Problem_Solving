
public class Demo {
        public static void main(String[] args) {

                // * ========= UTILITIES STUFF =========
                // Node head = SinglyLinkedListUtils.getHead(new int[] { 1, 2, 3, 4, 5, 6 });
                // SinglyLinkedListUtils.keepCycle(head, 2);
                // Node target = SinglyLinkedListUtils.getNode(
                // head,
                //
                // 5
                //
                // );

                // * ============================================
                // ! July 21 Stuff
                // System.out.println(July21.middleOfLinkedListBrute(head).data);
                // System.out.println(July21.getList(head));

                // System.out.println(July21.getList(July21.reverseLinkedListOptimal(head)));
                // System.out.println(July21.getList(July21.reverseLinkedListRec(null, head,
                // head)));

                // ! July 22 Stuff
                // System.out.println(July22.hasCycleBrute(head));
                // System.out.println(July22.startingNodeOfCycle(head).data);

                // ! July 24 Stuff
                // Node head = SinglyLinkedListUtils.getHead(new int[] { 1, 2, 3, 2, 1 });
                // SinglyLinkedListUtils.keepCycle(head, 4);

                // System.out.println(July24.lengthOfCycle(head));
                // System.out.println(July24.isPalindrome(head));

                // System.out.println(Arrays.toString(arr));
                // July24.oddEvenListBrute(arr);
                // System.out.println(Arrays.toString(arr));
                // int[] arr = new int[] {
                // // 1, 2, 3, 4, 5
                // 2, 1, 3, 5, 6, 4, 7
                // };
                // Node head = SinglyLinkedListUtils.getHead(arr);
                // System.out.println(SinglyLinkedListUtils.getList(
                // July24.oddEvenListOptimalV2(head)));

                // ! July 25 Stuff
                // Node head = SinglyLinkedListUtils.getHead(new int[] {
                // 1, 2, 3, 4, 5, 6
                // 1, 2
                // 1
                // });

                // System.out.println(SinglyLinkedListUtils.getList(July25.removeNthFromEndOptimal(head,
                // 1)));
                // System.out.println(SinglyLinkedListUtils.getList(July25.deleteMiddleNodeOptimal(head)));
                // System.out.println(SinglyLinkedListUtils.getList(July25.deleteMiddleNodeOptimal(head)));
                // ! Intersection Point Linked List
                // Node headA = SinglyLinkedListUtils.getHead(new int[] { 4, 1, 8, 4, 5 });
                // Node headB = SinglyLinkedListUtils.getHead(new int[] { 5, 6, 1 });
                // SinglyLinkedListUtils.createIntersection(headA, headB, 2, 3, false);
                // System.out.println(SinglyLinkedListUtils.getList(
                // July25.intersectionPointOptimal(headA, headB)));

                // Node head = SinglyLinkedListUtils.getHead(new int[] {
                // // 9, 9, 9
                // // 1, 0, 0, 0
                // 4, 2, 1, 3
                // });
                // System.out.println(SinglyLinkedListUtils.getList(July25.addOneToLLOptimal(head)));
                // int val = July25.addOneToLLHelper(head);
                // System.out.println(val);
                // System.out.println(SinglyLinkedListUtils.getList(July25.sortList(head)));

                // Node head1 = SinglyLinkedListUtils.getHead(new int[] { 1, 2, 4 });
                // Node head2 = SinglyLinkedListUtils.getHead(new int[] { 1, 3, 4 });

                // System.out.println(SinglyLinkedListUtils.getList(July25.mergeSortedLists(head1,
                // head2)));

                // Node head = SinglyLinkedListUtils.getHead(new int[] { 9, 4, 6, 2, 1, 3, 5, 7,
                // 8 });

                // System.out.println(SinglyLinkedListUtils.getList(
                // July25.mergeSort(head)));

                // ! July 29 Stuff

                // Node head = DoublyLinkedListUtils.getHead(new int[] {
                // 4, 3, 2, 1
                // 4, 2
                //
                // });

                // System.out.println(DoublyLinkedListUtils.getList(
                // July29.reverseDoublyLinkedListOptimal(head)
                //
                // ));
                // Node head = SinglyLinkedListUtils.getHead(new int[] { 1, 2, 3, 4, 5, 6, 7, 8
                // });
                // System.out.println(SinglyLinkedListUtils.getList(
                // July29.reverseLinkedListIIV2(head, 2, 4)
                //
                // ));

                // ! July 3, Stuff

                // Node head = SinglyLinkedListUtils.getHead(new int[] {
                // //
                // 1, 2, 3, 4, 5
                // //
                // });

                // System.out.println(SinglyLinkedListUtils.getList(
                // //
                // July30.reverseLinkedListIIV2(head, 2, 4)
                //
                // ));

                // ! Aug 1 Stuff

                // DoublyLinkedList dll = new DoublyLinkedList();
                // dll.insertAtHead(100);
                // dll.insertAtHead(200);
                // dll.insertAtHead(300);
                // dll.insertAtPos(3, 400);
                // dll.deletePos(2);
                // dll.printForward();

                // NonLinearLinkedList nll = new NonLinearLinkedList();
                // nll.insertAtTail(100);
                // nll.insertAtTail(200);
                // nll.insertAtTail(300);
                // nll.printLL();

                // System.out.println(
                // NonLinearLinkedListUtils.getList(
                // head));

                // DNode dhead = DoublyLinkedListUtils.getHead(new int[] {
                // 1, 2, 3, 4, 5, 6, 7, 8, 9
                // 1, 5, 6,
                // 0, 2, 3, 4, 5, 6, 7, 8, 9, 10

                // });

                // System.out.println(
                // Aug01.pairsWithTargetSum(dhead, 8)
                //
                // );

                // ! FLatten Linked list problem
                // NlNode head = NonLinearLinkedListUtils.getHead(new int[] { 5, 10, 19, 28 });
                // NonLinearLinkedListUtils.putBottomList(head, 1, new int[] { 7, 8 });
                // NonLinearLinkedListUtils.putBottomList(head, 2, new int[] { 20 });
                // NonLinearLinkedListUtils.putBottomList(head, 3, new int[] { 22 });
                // NonLinearLinkedListUtils.putBottomList(head, 4, new int[] { 40, 45 });
                // System.out.println(NonLinearLinkedListUtils.getList(head));

                // NlNode head1 = NonLinearLinkedListUtils.getHead(new int[] { 4 });
                // NonLinearLinkedListUtils.putBottomList(head1, 1, new int[] { 9 });
                // NlNode head2 = NonLinearLinkedListUtils.getHead(new int[] { 5 });
                // NonLinearLinkedListUtils.putBottomList(head2, 1, new int[] { 6, 8 });

                // System.out.println(NonLinearLinkedListUtils.getChildList(
                // // Aug01.mergeLists(head1, head2)
                // Aug01.flattenListV2(head)
                // //
                // ));

                // ! REMOVE DUPLICATES FROM LINKED LIST

                // Node head = SinglyLinkedListUtils.getHead(new int[] {
                // 1, 1, 2, 2, 3, 3, 4, 5
                // 1, 1, 2, 3, 3
                // });
                // System.out.println(SinglyLinkedListUtils.getList(
                // Aug01.removeDuplicates(head)
                //
                // ));

                // Node head1 = SinglyLinkedListUtils.getHead(new int[] {
                // // 7, 2, 4, 3
                // // 0
                // 2, 4, 3
                // });
                // Node head2 = SinglyLinkedListUtils.getHead(new int[] {
                // // 5, 6, 4
                // // 0
                // 5, 6, 4
                // });

                // System.out.println(SinglyLinkedListUtils.getList(
                // Aug03.addTwoNumbersBrute(head1, head2)
                // //
                // ));

                // Node head = SinglyLinkedListUtils.getHead(new int[] { 1, 2, 6, 3, 4, 5, 6 });
                // System.out.println(SinglyLinkedListUtils.getList(
                // Aug05.removeElementsOptimal(head, 6))
                // //
                // );

                Node head = SinglyLinkedListUtils.getHead(
                                new int[] {
                                                1, 0, 1
                                });
                System.out.println(Aug05.getDecimalValue(head));
        }

}
