public class Demo {
    // ! ============= Oct 21  Problems =============

    public static void main(String[] args) {
        Binary_Tree bt = new Binary_Tree();
        bt.insert(1);
        bt.insert(2);
        bt.insert(3);
        bt.insert(4);
        bt.insert(5);
        bt.insert(6);
        bt.insert(7);
        bt.insert(8);
        bt.insert(9);
        bt.levelOrder();
        bt.preOrder();
        bt.inOrder();
        bt.postOrder();
    }
}
