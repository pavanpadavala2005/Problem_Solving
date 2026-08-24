
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        // ! Aug 23 Problems
        // System.out.println(Aug23.fib(10));

        // Aug23.printTo1(10);

        // String s = "abcdcba";
        // System.out.println(Aug23.isPalindrome(s, 0, s.length() - 1));

        // ! Aug 24 Problems
        // Aug24.printName(5, "Pavan");
        // System.out.println(Aug24.sumOfNumber(5));

        // int[] arr = new int[] { 1, 2, 3, 4, 4, 5, 6, 7, 8 };
        // System.out.println(Arrays.toString(arr));
        // Aug24.reverseArray(arr, 0, arr.length - 1);
        // System.out.println(Arrays.toString(arr));

        // System.out.println(Arrays.toString(Aug24.reverseArrayFunctional(
        // new int[] { 1, 2, 3, 4 },
        // 0
        // //
        // )));

        // System.out.println(Aug24.isPalindromeBetter(
        // "AmmA",
        // 0
        // //
        // ));

        // System.out.println(Aug24.reverseNumberMethod3(10));

        // System.out.println(Aug24.nthFibonacci(5));

        int[] arr = new int[] { 3, 1, 2 };
        // ArrayList<Integer> res = Aug24.printSubSets(arr, 0, new ArrayList<>());
        // System.out.println("Res -->" + res);
        System.out.println(Aug24.printSubSetsFunctional(arr, 0, new ArrayList<>()));
    }
}
