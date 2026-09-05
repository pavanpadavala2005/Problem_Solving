import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sep05 {
    // ! ============== LC79. Word Search =============
    public static boolean exist(char[][] board, String word) {
        exist(board, word, 0, 0, 0, new StringBuilder(), new boolean[board.length][board[0].length]);
        return true;
    }

    public static void exist(char[][] board, String word, int i, int row, int col, StringBuilder sb,
            boolean[][] path) {
        if (sb.toString().equals(word)) {
            System.out.println(sb);
            return;
        }
        System.out.println(word.charAt(i));

        if (isPossible(board, row + 1, col, word.charAt(i + 1), path)) {
            System.out.println("Exec");
            path[row][col] = true;
            sb.append(word.charAt(i));
            exist(board, word, i + 1, row + 1, col, sb, path);
            sb.deleteCharAt(sb.length() - 1);
            path[row][col] = false;
        }

        if (isPossible(board, row, col - 1, word.charAt(i + 1), path)) {
            System.out.println("Exec");
            path[row][col] = true;
            sb.append(word.charAt(i));
            exist(board, word, i + 1, row, col - 1, sb, path);
            sb.deleteCharAt(sb.length() - 1);
            path[row][col] = false;
        }

        if (isPossible(board, row + 1, col + 1, word.charAt(i + 1), path)) {
            System.out.println("Exec");
            path[row][col] = true;
            sb.append(word.charAt(i));
            exist(board, word, i + 1, 1, col + 1, sb, path);
            sb.deleteCharAt(sb.length() - 1);
            path[row][col] = false;
        }

        if (isPossible(board, row - 1, col, word.charAt(i + 1), path)) {
            System.out.println("Exec");
            path[row][col] = true;
            sb.append(word.charAt(i));
            exist(board, word, i + 1, row - 1, col, sb, path);
            sb.deleteCharAt(sb.length() - 1);
            path[row][col] = false;
        }

    }

    public static boolean isPossible(char[][] board, int row, int col, char ch, boolean[][] path) {
        if (row < 0 || row > board.length ||
                col < 0 || col > board[0].length ||
                !path[row][col] || board[row][col] != ch)
            return false;
        return true;
    }

    // ! ============== LC17. Letter Combinations of a Phone Number =============
    // @ Works for GFG and LC
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        HashMap<Character, String> map = new HashMap<>();
        map.put('0', " ");
        map.put('1', " ");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        letterCombinations(map, digits, 0, new StringBuilder(), res);
        return res;
    }

    // @ TC --> O(4^n) --> because every time multiplying and calling recursion
    // @ SC ---> O(10) --> numbers stored in HashMap
    public static void letterCombinations(HashMap<Character, String> map, String s, int i, StringBuilder sb,
            List<String> res) {
        if (i >= s.length()) {
            res.add(sb.toString());
            return;
        }
        if (map.get(s.charAt(i)).equals(" ")) {
            letterCombinations(map, s, i + 1, sb, res);
        } else {
            for (char ch : map.get(s.charAt(i)).toCharArray()) {
                sb.append(ch);
                letterCombinations(map, s, i + 1, sb, res);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

}

// ! Target Min -> 3 , Max -> 5 (Quality Problems Only)
// 1. LC17. Letter Combinations of a Phone Number ✅
// 2. LC79. Word Search 