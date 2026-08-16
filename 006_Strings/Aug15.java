
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Aug15 {
    // ! =============== LC242. Valid Anagram ================
    public static boolean isAnagramOptimal(String s, String t) {
        if (s.length() != t.length())
            return false;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i);
            res ^= t.charAt(i);
        }
        return res == 0;
    }

    public static boolean isAnagramBetter(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] res = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int idx1 = s.charAt(i) - 97;
            int idx2 = t.charAt(i) - 97;
            res[idx1]++;
            res[idx2]--;
        }
        for (int i = 0; i < 26; i++)
            if (res[i] != 0)
                return false;
        return true;
    }

    public static boolean isAnagramBrute(String s, String t) {
        HashMap<Character, Integer> freq1 = new HashMap<>();
        HashMap<Character, Integer> freq2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freq1.put(s.charAt(i), freq1.getOrDefault(s.charAt(i), 0) + 1);
            freq2.put(t.charAt(i), freq2.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (char ch : freq1.keySet())
            if (!freq1.get(ch).equals(freq2.get(ch)))
                return false;
        return true;
    }

    // ! =============== LC796. Rotate String ================
    // TODO Do this on Aug 16
    public static boolean rotateStringBrute(String s, String goal) {
        int n1 = s.length();
        int n2 = goal.length();
        if (n1 != n2)
            return false;
        int idx = 0;
        while (idx < goal.length() && goal.charAt(idx) != s.charAt(0))
            idx++;
        for (int i = 0; i < n1; i++)
            if (s.charAt(i) != goal.charAt(idx++ % n1))
                return false;
        return true;
    }

    // ! =============== LC1903. Largest Odd Number in String ================
    public static String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if (Integer.valueOf(num.charAt(i)) % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    // ! =============== LC412. Fi zz Buzz ================
    public static List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                res.add("FizzBuzz");
            else if (i % 3 == 0)
                res.add("Fizz");
            else if (i % 5 == 0)
                res.add("Buzz");
            else
                res.add(Integer.toString(i));
        }
        return res;
    }

    // ! =============== LC14. Longest Common Prefix ================
    public static String longestCommonPrefixOptimal(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(res) != 0) {
                res = res.substring(0, res.length() - 1);
                if (res.isEmpty())
                    return "";
            }
        }
        return res;
    }

    public static String longestCommonPrefixBrute(String[] strs) {
        int n = strs.length;
        if (n == 0)
            return "";
        String res = strs[0];
        for (int i = 1; i < n; i++)
            res = getPrefix(res, strs[i]);
        return res;
    }

    public static String getPrefix(String s1, String s2) {
        StringBuilder prefix = new StringBuilder();
        int i = 0;
        while (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) != s2.charAt(i))
                break;
            prefix.append(s1.charAt(i));
            i++;
        }
        return prefix.toString();
    }

    // ! =============== LC28. Find Index of First Occurrence ================
    public static int strStrOptimal(String haystack, String needle) {
        // TODO: NEED TO IMPLEMENT THIS LOGIC on Aug 16
        return -1;
    }

    public static int strStrBetter(String haystack, String needle) {
        int i = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int idx = i;
                int ptr = 0;
                while (idx < haystack.length() && ptr < needle.length()) {
                    if (haystack.charAt(idx) != needle.charAt(ptr))
                        break;
                    idx++;
                    ptr++;
                }
                if (ptr == needle.length())
                    return i;
            }
            i++;
        }
        return -1;
    }

    public static int strStrBrute(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int idx = i;
                int ptr = 0;
                while (idx < haystack.length() && ptr < needle.length() && haystack.charAt(idx) == needle.charAt(ptr)) {
                    idx++;
                    ptr++;
                }
                if (ptr == needle.length())
                    return i;
            }
        }
        return -1;

    }

    // ! =============== LC205. Isomorphic Strings ================
    public static boolean isIsomorphic(String s, String t) {
        // * Using Two Arrays
        int[] arr1 = new int[256], arr2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (arr1[s.charAt(i)] != arr2[t.charAt(i)])
                return false;
            arr1[s.charAt(i)] = i + 1;
            arr2[t.charAt(i)] = i + 1;
        }
        return true;
    }

    public static boolean isIsomorphicOptimal(String s, String t) {
        HashMap<Character, Character> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char org = s.charAt(i);
            char rep = t.charAt(i);
            if (freq.containsKey(org) && freq.get(org) != rep)
                return false;
            else if (freq.containsValue(rep))
                return false;
            freq.put(org, rep);
        }
        return true;
    }

    public static boolean isIsomorphicBetter(String s, String t) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map1.containsKey(s.charAt(i)))
                map1.put(s.charAt(i), i);
            if (!map2.containsKey(t.charAt(i)))
                map2.put(t.charAt(i), i);
            if (!map1.get(s.charAt(i)).equals(map2.get(t.charAt(i))))
                return false;
        }
        return true;
    }

    public static boolean isIsomorphicWaste(String s, String t) {
        int n = s.length();
        HashMap<Character, Integer> freq1 = new HashMap<>();
        HashMap<Character, Integer> freq2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freq1.put(s.charAt(i), freq1.getOrDefault(s.charAt(i), 0) + 1);
            freq2.put(t.charAt(i), freq2.getOrDefault(t.charAt(i), 0) + 1);
        }

        return freq1.keySet().size() == freq2.keySet().size();
    }

    // ! =============== LC13. Roman to Integer ==================
    public static int romanToIntegerBetter(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            int curr = map.get(s.charAt(i));
            int next = map.get(s.charAt(i + 1));
            if (curr < next)
                res -= curr;
            else
                res += curr;
        }
        return res += map.get(s.charAt(n - 1));
    }

    public static int romanToIntegerBrute(String s) {
        int n = s.length();
        if (n <= 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        if (n == 1)
            return map.get(s.charAt(0));
        int res = 0;
        int i = 0;
        while (i < n) {
            if (i + 1 < n && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                res += map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
                i += 1;
            } else {
                res += map.get(s.charAt(i));
            }
            i += 1;
        }
        return res;
    }

    // ! =============== PALINDROME NUMBER ==================
    public static boolean isPalindromeNumber(int n) {
        if (n < 0)
            n = -n;
        int temp = n;
        int rev = 0;
        while (temp != 0) {
            rev = rev * 10 + temp % 10;
            temp = temp / 10;
        }
        return rev == n;
    }

    // ! =============== PALINDROME SENTENCE ==================
    public static boolean isPalindromeSentence(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!isAlphaNumeric(s.charAt(i))) {
                i++;
                continue;
            } else if (!isAlphaNumeric(s.charAt(j))) {
                j--;
                continue;
            }
            if (s.substring(i, i + 1).compareToIgnoreCase(s.substring(j, j + 1)) != 0)
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static boolean isAlphaNumeric(char ch) {
        return (ch >= 65 && ch <= 90) ||
                (ch >= 97 && ch <= 122) ||
                (ch >= 48 && ch <= 57);
    }

    // ! =============== PALINDROME STRING ==================
    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static boolean isPalindromeBrute(String s) {
        String rev = "";
        for (int i = 0; i < s.length(); i++)
            rev = s.charAt(i) + rev;
        return rev.equals(s);
    }
    // ! =============== REVERSE STRING ==================

    public static String reverseStringBetter(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }

    public static String reverseStringBrute(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++)
            res = s.charAt(i) + res;
        return res;
    }

}
