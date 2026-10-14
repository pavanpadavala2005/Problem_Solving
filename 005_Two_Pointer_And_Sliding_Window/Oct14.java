import java.util.HashMap;

public class Oct14 {
    // ! ============= GFG. Longest Substring with K Uniques =============
    /*
    @ TC --> O(N)
    @ SC --> O(26)
    */
    public static int longestKSubstrOptimal(String s, int k) {
        int[] map = new int[26];
        int count = 0;
        int i = 0;
        int maxLen = -1;
        for (int j = 0; j < s.length(); j++) {
            int right = s.charAt(j) - 'a';
            map[right]++;
            if (map[right] == 1)
                count++;
            if (count > k) {
                int left = s.charAt(i) - 'a';
                map[left]--;
                if (map[left] == 0)
                    count--;
                i++;
            }
            if (count == k)
                maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }

    /* 
    @ TC --> O(N+N) --> inner while loop is Not running for Every i
    @ SC --> O(26) --> as we are Storing the Characters in HashMap
    */
    public static int longestKSubstrBetter(String s, int k) {
        int[] map = new int[26];
        int count = 0;
        int i = 0;
        int maxLen = -1;
        for (int j = 0; j < s.length(); j++) {
            int right = s.charAt(j) - 'a';
            map[right]++;
            if (map[right] == 1)
                count++;
            while (count > k) {
                int left = s.charAt(i) - 'a';
                map[left]--;
                if (map[left] == 0)
                    count--;
                i++;
            }
            if (count == k)
                maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }

    // ! ============= LC904. Fruit Into Baskets =============
    public static int totalFruitOptimalV2(int[] fruits) {
        int n = fruits.length;
        int maxLen = Integer.MIN_VALUE;
        int[] map = new int[n];
        int count = 0;
        int i = 0;
        for (int j = 0; j < fruits.length; j++) {
            int right = fruits[j];
            map[right]++;
            if (map[right] == 1)
                count++;

            if (count > 2) {
                int left = fruits[i];
                map[left]--;
                if (map[left] == 0)
                    count--;
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;

    }

    /*
    @ TC --> O(N) --> in the Loop we are using if statement to Not grow the Window Size Beyond Max Limit
    @ SC --> O(N) --> We are Storing in a Map
    */
    public static int totalFruitOptimal(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        int i = 0;
        for (int j = 0; j < fruits.length; j++) {
            int right = fruits[j];
            map.put(right, map.getOrDefault(right, 0) + 1);

            if (map.size() > 2) {
                int left = fruits[i];
                map.put(left, map.get(left) - 1);

                if (map.get(left) <= 0)
                    map.remove(left);
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }

    /*
    @ TC --> O(N + N) --> inner loop is not running for Every i
    @ SC --> O(N) --> We are Storing in a Map
    */
    public static int totalFruitBetter(int[] fruits) {
        int maxLen = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (int j = 0; j < fruits.length; j++) {
            int right = fruits[j];

            map.put(right, map.getOrDefault(right, 0) + 1);

            while (map.size() > 2) {
                int left = fruits[i];
                map.put(left, map.get(left) - 1);

                if (map.get(left) <= 0)
                    map.remove(left);
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
}
// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC904. Fruit Into Baskets ✅
// 2. GFG. Longest Substring with K Uniques ✅