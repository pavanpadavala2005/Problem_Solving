
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        // ! ============= Aug 23 Problems ============

        // System.out.println(Aug23.fib(10));

        // Aug23.printTo1(10);

        // String s = "abcdcba";
        // System.out.println(Aug23.isPalindrome(s, 0, s.length() - 1));

        // ! ============= Aug 24 Problems ============
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

        // int[] arr = new int[] { 3, 1, 2 };
        // ArrayList<Integer> res = Aug24.printSubSets(arr, 0, new ArrayList<>());
        // System.out.println("Res -->" + res);
        // System.out.println(Aug24.printSubSets Functional(arr, 0, new ArrayList<>()));

        // ! ============= Aug 25 Problems ============
        // Aug24.printSubSets(
        // new int[] { 3, 1, 2 },
        // 0,
        // new ArrayList<>()
        // //
        // );

        // System.out.println(Aug25.numSubseqHelper(
        // new int[] { 14, 4, 6, 6, 20, 8, 5, 6, 8, 12, 6, 10, 14, 9, 17, 16, 9, 7, 14,
        // 11, 14, 15, 13, 11, 10, 18,
        // 13, 17, 17, 14, 17, 7, 9, 5, 10, 13, 8, 5, 18, 20, 7, 5, 5, 15, 19, 14 },
        // 22,
        // 0,
        // new ArrayList<>()
        // //
        // ));

        // Aug25.printSubSequencesK(
        // new int[] { 1, 2, 1 },
        // 0,
        // 2,
        // new ArrayList<>(),
        // 0
        // //
        // );

        // int[] nums = new int[] {
        // // 3, 3, 6, 8
        // 2, 3, 3, 4, 6, 7
        // };
        // int target = 12;
        // System.out.println(
        // Aug25.numSubseqHelperV2(
        // nums,
        // 0,
        // new ArrayList<>(),
        // target,
        // -1,
        // Integer.MAX_VALUE
        // //
        // ));

        // int ans = Aug25.countSubSequencesSumToK(
        // new int[] { 2, 1, 1, 2 },
        // 0,
        // 2,
        // 0
        // //
        // );
        // System.out.println(ans);
        // int[] arr = new int[] { 9, 4, 3, 1, 2 };
        // Aug25.mergeSot(arr, 0, arr.length - 1);

        int[] arr = new int[] {
                9, 4, 3, 1, 2
        };
        // int[] res = Aug25.merge(
        // arr,
        // 0,
        // arr.length / 2,
        // arr.length - 1
        // //
        // );

        Aug25.mergeSot(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(
                // res
                arr
        //
        ));
    }
}
