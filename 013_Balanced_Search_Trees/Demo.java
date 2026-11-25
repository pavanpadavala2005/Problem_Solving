public class Demo {
    public static void main(String[] args) {

        //     AVLTreeV2 at = new AVLTreeV2();

        //     at.insert(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 });

        //     at.levelOrder();
        //     System.out.println("-----");
        //     at.deleteNode(4);
        //     at.levelOrder();

        // ! ============= Nov 19 Problems =============
        // 
        // Binary_Search_Tree_Utils bt = new Binary_Tree_Utils();

        // SplayTree st = new SplayTree();

        // st.insert(10);
        // st.insert(20);
        // st.insert(30);

        // st.levelOrder();

        // ! ============= Nov 24 Problems =============

        // SegmentTreeV3 st = new SegmentTreeV3();
        // st.insert(new int[] { 42, 87, -15, 0, 63, -94, 21, -7, 55, -68 });

        // st.levelOrder();
        // st.updateElement(0, 10);
        // st.levelOrder();

        // System.out.println(st.getRangeMax(0, 4));

        // ! ============= Nov 25 Problems =============
        // int i = 8;
        // System.out.println(i + (i & -i));
        BinaryHeap.MaxHeap mxHeap = new BinaryHeap().new MaxHeap(new int[] { 1, 3, 4, 5, 10, 28, 18, 2, 9, 6, 7 });

        // mxHeap.heapSort();
        mxHeap.printHeap();
    }
}
