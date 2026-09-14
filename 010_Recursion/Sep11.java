import java.util.*;

public class Sep11 {

    // TODO: SOLVE THE BELOW PROBLEMS BY SUNDAY
    // ! ============== LC241._Different_Ways_to_Add_Parentheses =============
    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        return res;
    }

    // TODO: NOT YET DONOE
    // https://chatgpt.com/c/6aa36fd7-e21c-83ee-aafe-ee18523d7775
    // ! ============== LC282. Expression Add Operators =============
    public static List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        dfs(num, 0, 0, 0, new StringBuilder(), res, target);
        return res;
    }

    public static void dfs(String s, int idx, int prev, int calc, StringBuilder sb, List<String> res,
            int target) {
        if (idx == s.length()) {
            if (calc == target)
                res.add(sb.toString());
            return;
        }
        int number = 0;
        for (int i = idx; i < s.length(); i++) {
            if (i > idx && s.charAt(idx) == '0')
                break;
            String temp = s.substring(idx, i + 1);
            // System.out.println(i + "->" + temp);
            System.out.println(i + "-->" + sb);
            number = number * 10 + (s.charAt(i) - '0');
            if (idx == 0) {
                sb.append(temp);
                dfs(s, i + 1, number, calc + number, sb, res, target);
                sb.deleteCharAt(sb.length() - temp.length());
            } else {
                sb.append('*').append(temp);
                dfs(s, i + 1, prev * number, calc - prev + prev * number, sb, res, target);
                sb.setLength(sb.length() - temp.length() - 1);

                sb.append('+').append(temp);
                dfs(s, i + 1, number, calc + number, sb, res, target);
                sb.setLength(sb.length() - temp.length() - 1);

                sb.append('-').append(temp);
                dfs(s, i + 1, -number, calc - number, sb, res, target);
                sb.setLength(sb.length() - temp.length() - 1);
            }
        }
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)

// // @ TC --> Same like addOperatorsV1 But added a new variable called Prev
// // @ SC --> Same like addOperatorsV1
// public static void addOperatorsV2(
// String num, int i,
// StringBuilder sb, int curr,
// int prev, List<String> res,
// int target) {
// if (i > num.length() - 1) {
// if (curr == target)
// res.add(sb.toString());
// return;
// }
// int digit = num.charAt(i) - '0';
// for (char ch : new char[] { '*', '+', '-' }) {
// sb.append(ch).append(num.charAt(i));
// if (ch == '+')
// addOperatorsV2(num, i + 1, sb, curr + digit, digit, res, target);
// else if (ch == '-')
// addOperatorsV2(num, i + 1, sb, curr - digit, -digit, res, target);
// else
// addOperatorsV2(num, i + 1, sb, curr - prev + (prev * digit), digit * prev,
// res, target);
// sb.setLength(sb.length() - 2);
// }
// }

// // ! Not Working perfectly
// // @ TC --> O(3^N-1) --> in first time we are passing first digits so N-1
// // @ SC --> O(2N) --> we are storing the expression in the String builder
// public static void addOperatorsV1(String num, int i, StringBuilder sb, int
// result, List<String> res, int target) {
// if (i >= num.length()) {
// if (result == target) {
// System.out.println(result);
// res.add(sb.toString());
// }
// return;
// }
// int digit = num.charAt(i) - 48;
// for (char ch : new char[] { '*', '+', '-' }) {
// sb.append(ch).append(num.charAt(i));
// if (ch == '+') {
// addOperatorsV1(num, i + 1, sb, result + digit, res, target);
// } else if (ch == '-')
// addOperatorsV1(num, i + 1, sb, result - digit, res, target);
// else {
// int prev = sb.charAt(sb.length() - 1) - 48;
// addOperatorsV1(num, i + 1, sb, result - prev + (prev * digit), res, target);
// }
// sb.deleteCharAt(sb.length() - 1);
// sb.deleteCharAt(sb.length() - 1);
// }
// }