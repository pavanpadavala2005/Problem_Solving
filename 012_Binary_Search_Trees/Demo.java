
public class Demo {
        public static void main(String[] args) {

                // ! ============= Nov 02 Problems =============

                // Binary_Search_Tree bst = new Binary_Search_Tree();

                // bst.insert(10);
                // bst.insert(5);
                // bst.insert(4);
                // bst.insert(7);
                // bst.insert(15);
                // bst.insert(20);

                // bst.levelOrder();
                // bst.deleteElement(10);
                // bst.levelOrder();

                Binary_Search_Tree_Utils bst = new Binary_Search_Tree_Utils();
                Binary_Tree_Utils bt = new Binary_Tree_Utils();

                // System.out.println(bst.search(20));

                // System.out.println(Nov02.findCeilBrute(bst.constructBST(
                //         // new Integer[] {
                // 10
                // , 7, 15, 2, 8, 11, 16
                // 5, 2, 12, 1, 3, 9, 21, 19, 25
                // 5, 2, 12, 1, 3, 9, 21, 19, 25
                // }),
                // 14
                // 24   
                // 4
                // ));

                // TreeNode root = bst.constructBST(new Integer[] {
                //         4, 2, 7, 1, 3
                //         40, 20, 60, 10, 30, 50, 70
                // });

                // bst.levelOrder(root);

                // TreeNode node = Nov02.insertIntoBSTOptimal(root, 25);

                // bst.levelOrder(node);

                // ! ============= Nov 05 Problems =============

                // TreeNode root = bst.constructBST(new Integer[] {
                //         // 50, 30, 70, 20, 40, 60, 80
                //         // 8, 1, 9, 4, 10, 3
                //         8, 1, 9, 4, 10, 3,
                // });

                // for (TreeNode i : Nov05.findPreSuc(
                //         root,
                //         // 65
                //         // 8
                //         // 8
                //         9
                // // 
                // ))
                //     System.out.println(i.val);

                // TreeNode root = bst.constructBST(new Integer[] { 0, 5, 10, 15, 20, 25, 30, 35, 40, 45 });

                // bst.levelOrder(root);

                // TreeNode res = Nov05.BSTFromInOrder(new int[] { 0, 5, 10, 15, 20, 25, 30, 35, 40, 45 });

                // bst.levelOrder(res);

                // ! ============= Nov 06 Problems =============

                // System.out.println(Nov06.mergeBrute(
                //                 bst.constructBST(new Integer[] {
                //                                 3, 1, 5
                //                 }),
                //                 bst.constructBST(new Integer[] {
                //                                 4, 2, 6
                //                 })
                // ));

                // System.out.println(Nov06.mergeOptimal(
                //                 bst.constructBST(new Integer[] {
                //                                 3, 1, 5
                //                 }),
                //                 bst.constructBST(new Integer[] {
                //                                 4, 2, 6
                //                 })
                // // 
                // ));

                // Nov06.correctBST(
                //                 bst.constructBST(new Integer[] {
                //                                 10, 5, 8, 2, 20
                //                 }));

                TreeNode root = bt.constructBinaryTree(new Integer[] { 5, 2, 4, 1, 3 });

                System.out.println(Nov07.largestBst(root));

        }
}
