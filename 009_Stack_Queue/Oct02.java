import java.util.*;

public class Oct02 {
    // ! ============= LC895. Maximum Frequency Stack =============
    public class FreqStack {
        HashMap<Integer, Integer> freq;
        Stack<Integer> st = new Stack<>();
        Stack<Integer> mt = new Stack<>();

        public FreqStack() {
            this.freq = new HashMap<>();
            this.st = new Stack<>();
            this.mt = new Stack<>();
        }

        public void push(int val) {
            this.freq.put(val, this.freq.getOrDefault(val, 0) + 1);
            if (this.st.isEmpty()) {
                this.st.push(val);
                this.mt.push(val);
                return;
            }
            this.st.push(val);
            if (this.freq.get(val) >= this.freq.get(this.mt.peek())) {
                this.mt.push(val);
            } else {
                this.mt.push(this.mt.peek());
            }
        }

        public int pop() {
            if (st.isEmpty())
                return -1;

            int elem = this.mt.pop();
            this.freq.put(elem, this.freq.get(elem) - 1);
            Stack<Integer> temp = new Stack<>();
            while (!st.isEmpty() && st.peek() != elem)

                temp.push(st.pop());
            if (!st.isEmpty())
                st.pop();
            while (!temp.isEmpty())
                st.push(temp.pop());
            return elem;
        }

        public void printStacks() {
            System.out.println("Stack" + this.st);
            System.out.println("Max" + this.mt);
            System.out.println(this.freq);
        }
    }

    // ! ============= LC1047. Remove All Adjacent Duplicates In String =============
    /*
    @ TC --> O(N)
    @ SC --> O(N)
    */
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!st.isEmpty() && ((ch == 'B' && st.peek() == 'A') || (ch == 'D' && st.peek() == 'C')))
                st.pop();
            else
                st.push(ch);
        }
        return st.size();
    }

    // ! ============= LC1047. Remove All Adjacent Duplicates In String =============
    /*
    @ TC --> O(N)
    @ SC --> O(N) --> for returning answer so ignorable 
    */
    public static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ch)
                sb.deleteCharAt(sb.length() - 1);
            else
                sb.append(ch);
        }
        return sb.toString();
    }

    // ! ============= LC844. Backspace String Compare =============
    /*
    @ TC --> O(2N)--> running for string s and t
    @ SC --> O(N)+O(N)
    */
    public static boolean backspaceCompare(String s, String t) {
        return getString(s).equals(getString(t));
    }

    public static String getString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (sb.length() > 0 && ch == '#')
                sb.deleteCharAt(sb.length() - 1);
            if (ch != '#')
                sb.append(ch);
        }
        return sb.toString();
    }

    // ! ============= LC.496. Next Greater Element I =============
    /*
    @ TC --> O(N)
    @ SC --> O(N)
    */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums2[i])
                st.pop();
            if (st.isEmpty())
                freq.put(nums2[i], -1);
            else
                freq.put(nums2[i], st.peek());
            st.push(nums2[i]);
        }
        System.out.println(freq);
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = freq.get(nums1[i]);
        }
        return res;
    }

    // * https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1
    // ! ============= GFG. Next Greater Element =============
    /*
    @ TC --> O(N) --> inner while loop is not running for every i so not that effect on TC
    @ SC --> O(N)+O(N) --> storing in the stack and in worst case may be store all elements
    */
    public static ArrayList<Integer> nextLargerElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <=

                    arr[i])
                st.pop();
            if (!st.isEmpty())
                res.add(0, st.peek());
            else
                res.add(0, -1);
            st.push(arr[i]);
        }
        return res;
    }

    // ! ============= LC394. Decode String =============
    /* 
    @ TC --> O(N) + O(Size(stack)) --> the inner while loop will not contribute to the Tc because it was not running for every I, but considerable 
    @ SC --> O(N)+O(N) --> storing in inner Sb and Stack
    */
    public static String decodeString(String s) {
        Stack<String> st = new Stack<>();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            String ch = s.substring(i, i + 1);
            if (ch.charAt(0) >= 48 && ch.charAt(0) <= 57)
                num = num * 10 + ch.charAt(0) - '0';
            else if (ch.equals("[")) {
                st.push(Integer.toString(num));
                num = 0;
                st.push(ch);
            } else if (ch.equals("]")) {
                StringBuilder sb = new StringBuilder();
                while (!st.isEmpty() && !st.peek().equals("["))
                    sb.insert(0, st.pop());
                st.pop();
                int rep = Integer.parseInt(st.pop());
                st.push(sb.toString().repeat(rep));
            } else
                st.push(ch);
        }
        while (st.size() > 1) {
            String s2 = st.pop();
            String s1 = st.pop();
            st.push(s1 + s2);
        }
        return st.pop();
    }
}
// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC394. Decode String ✅
// 2. GFG. Next Greater Element ✅
// 3. LC496. Next Greater Element ✅
// 4. LC844. Backspace String Compare ✅
// 5. LC1047. Remove All Adjacent Duplicates In String ✅
// 6. LC1047. Remove All Adjacent Duplicates In String ✅