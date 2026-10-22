public class Demo {
    public static void main(String[] args) {
        // ! ============= Oct 21  Problems =============
        // Binary_Tree bt = new Binary_Tree();
        // bt.insert(1);
        // bt.insert(2);
        // bt.insert(3);
        // bt.insert(4);
        // bt.insert(5);
        // bt.insert(6);
        // bt.insert(7);
        // bt.insert(8);
        // bt.insert(9);
        // bt.levelOrder();
        // bt.preOrder();
        // bt.inOrder();
        // bt.postOrder();

        // ! ============= Oct 22  Problems =============

        // * Implementing Tree Structure and getting Node
        Binary_Tree_Utils bt = new Binary_Tree_Utils();

        // System.out.println(Oct22.inorderTraversal(bt.constructBinaryTree(
        //         new Integer[] {
        // 1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9
        // }
        // 
        // )));

        // System.out.println(Oct22.inorderTraversalIterative(bt.constructBinaryTree(
        //         new Integer[] {
        //                  1, null, 2, 3
        //                 1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9
        //         }
        // 
        // )));

        // System.out.println(Oct22.threeTraversals(bt.constructBinaryTree(
        //         new Integer[] {
        //                 1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9
        //         })));

        System.out.println(Oct22.maxDepth(bt.constructBinaryTree(
                new Integer[] {
                        //  3, 9, 20, null, null, 15, 7
                        1, null, 2
                })));
    }
}
