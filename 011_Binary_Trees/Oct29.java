import java.util.*;

public class Oct29 {

    // ! ============= GEN. Morris inOrder Traversal of a Binary Tree ============
    /*
    @ TC --> O(N)
    @ SC --> O(1)
    */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        TreeNode temp = root;
        while (temp != null) {
            if (temp.left == null) {
                res.add(temp.val);
                temp = temp.right;
            } else {
                TreeNode prev = temp.left;
                while (prev.right != null && prev.right != temp)
                    prev = prev.right;
                if (prev.right == null) {
                    prev.right = temp;
                    temp = temp.left;
                } else {
                    prev.right = null;
                    res.add(temp.val);
                    temp = temp.right;
                }
            }
        }
        return res;
    }

    // ! ============= GEN. Morris PostOrder Traversal of a Binary Tree ============
    /*
    @ TC --> O(N)
    @ SC --> O(1)
    */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        TreeNode temp = root;
        while (temp != null) {
            if (temp.right == null) {
                res.add(temp.val);
                temp = temp.left;
            } else {
                TreeNode prev = temp.right;
                while (prev.left != null && prev.left != temp)
                    prev = prev.left;

                if (prev.left == null) {
                    prev.left = temp;
                    res.add(temp.val);
                    temp = temp.right;
                } else {
                    prev.left = null;
                    temp = temp.left;
                }
            }
        }
        Collections.reverse(res);
        return res;
    }

    // ! ============= GEN. Morris PreOrder Traversal of a Binary Tree ============
    /*
    @ TC --> O(N)
    @ SC --> O(1)
    */
    public static List<Integer> morrisPreOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        TreeNode temp = root;
        while (temp != null) {
            if (temp.left == null) {
                res.add(temp.val);
                temp = temp.right;
            } else {
                TreeNode prev = temp.left;
                while (prev.right != null && prev.right != temp)
                    prev = prev.right;
                if (prev.right == null) {
                    prev.right = temp;
                    temp = temp.left;
                } else {
                    prev.right = null;
                    res.add(temp.val);
                    temp = temp.right;
                }
            }
        }
        return res;
    }

    // ! ============= LC297. Serialize and Deserialize Binary Tree ============
    /*
    @ TC --> O(N + N)
    @ SC --> O(N)
    */
    public class CodecV2 {
        public static String serialize(TreeNode root) {
            if (root == null)
                return "";
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        public static void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("N,");
                return;
            }
            sb.append(Integer.toString(root.val) + ",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        public static TreeNode deserialize(String data) {
            if (data == null || data.equals(""))
                return null;
            String[] arr = data.split(",");
            int[] i = new int[] { 0 };
            return deserialize(arr, i);
        }

        public static TreeNode deserialize(String[] arr, int[] i) {
            if (arr[i[0]].equals("N"))
                return null;

            TreeNode root = new TreeNode(Integer.parseInt(arr[i[0]]));
            i[0] += 1;
            root.left = deserialize(arr, i);

            i[0] += 1;
            root.right = deserialize(arr, i);

            return root;
        }
    }

    public class Codec {
        /*
        @ TC -->  O(N)
        @ SC ---> O(N + N) --> Queue + resultString
        */
        public static String serialize(TreeNode root) {
            if (root == null)
                return "";
            Queue<TreeNode> q = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            q.offer(root);
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                if (node == null) {
                    sb.append("N,");
                    continue;
                } else {
                    sb.append(Integer.toString(node.val) + ",");
                }
                q.offer(node.left);
                q.offer(node.right);
            }
            return sb.toString();
        }

        /*
        @ TC --> O(Data)
        @ SC --> O(N)
        */
        public static TreeNode deserializeOptimal(String data) {
            if (data == null || data.equals(""))
                return null;

            String[] elems = data.split(",");
            int n = elems.length;
            int i = 0;
            if (elems[i].equals("N"))
                return null;
            Queue<TreeNode> q = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(elems[i]));
            q.offer(root);

            i++;
            while (!q.isEmpty() && i < n) {
                TreeNode node = q.poll();
                if (i < n && !elems[i].equals("N")) {
                    node.left = new TreeNode(Integer.parseInt(elems[i]));
                    q.offer(node.left);
                }
                i++;
                if (i < n && !elems[i].equals("N")) {
                    node.right = new TreeNode(Integer.parseInt(elems[i]));
                    q.offer(node.right);
                }
                i++;
            }
            return root;
        }

        /*
        @ TC --> O(Data)
        @ SC --> O(1)
        */
        public static TreeNode deserializeBrute(String data) {
            if (data.equals(""))
                return null;

            int n = data.length();
            int j = 0;
            int i = 0;

            while (j < n && data.charAt(j) != ',')
                j++;

            TreeNode root = new TreeNode(Integer.parseInt(data.substring(i, j)));
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            i = j + 1;
            j++;

            while (!q.isEmpty() && i < n) {
                Integer left = null;

                while (j < n && data.charAt(j) != ',')
                    j++;

                if (!data.substring(i, j).equals("N"))
                    left = Integer.parseInt(data.substring(i, j));

                TreeNode node = q.poll();

                if (left != null) {
                    node.left = new TreeNode(left);
                    q.offer(node.left);
                }

                if (j >= n)
                    break;

                i = j + 1;
                j++;

                if (i >= n)
                    break;

                Integer right = null;

                while (j < n && data.charAt(j) != ',')
                    j++;

                if (!data.substring(i, j).equals("N"))
                    right = Integer.parseInt(data.substring(i, j));

                if (right != null) {
                    node.right = new TreeNode(right);
                    q.offer(node.right);
                }

                if (j >= n)
                    break;

                i = j + 1;
                j++;

                if (i >= n)
                    break;
            }

            return root;
        }
    }

    // ! ============= LC106. Construct Binary Tree from Inorder and Postorder Traversal ============
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    public static TreeNode buildTreeHelper(int[] inorder, int insIdx, int ineIdx, int[] postorder, int posIdx,
            int poeIdx,
            HashMap<Integer, Integer> map) {

        if (ineIdx < insIdx || poeIdx < posIdx)
            return null;

        TreeNode root = new TreeNode(postorder[poeIdx]);
        int rootIdx = map.get(postorder[poeIdx]);
        int numElems = ineIdx - rootIdx;

        root.right = buildTreeHelper(inorder, rootIdx + 1, ineIdx, postorder, poeIdx - numElems, poeIdx - 1, map);
        root.left = buildTreeHelper(inorder, insIdx, rootIdx - 1, postorder, posIdx, poeIdx - numElems - 1, map);

        return root;
    }

}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC106. Construct Binary Tree from Inorder and Postorder Traversal ✅
// 2. LC297. Serialize and Deserialize Binary Tree ✅
// 3. GEN. Morris InOrder Traversal of a Binary Tree ⭐ ✅
// 4. GEN. Morris PreOrder Traversal of a Binary Tree ⭐ ✅
// 5. GEN. Morris PostOrder Traversal of a Binary Tree ⭐ ✅