public class Demo {
    public static void main(String[] args) {
        July16.printMessage();
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insertAtHead(100);
        sll.insertAtTail(200);
        // sll.insertAtTail(300);
        // sll.insertAtTail(400);
        // sll.insertAtTail(500);
        // sll.insertAtTail(600);

        // sll.deleteAtHead();
        // sll.deleteAtTail();

        sll.printList();
        July16.printMessage();
    }
}