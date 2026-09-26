import java.util.*;

public class Sep26 {
    // ! ============= LC319. Bulb Switcher =============
    /*
    @ TC --> O(Sqrt(N)) --> because the bulbs which are active by the end of N iterations are perfect Squares 
    @ SC --> O(1)
    */
    public static int bulbSwitchBetter(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++)
            count++;
        return count;
    }

    /*
    @ TC --> O(N^2 * N) --> computing and counting
    @ SC --> For Storing State 
    */
    public static int bulbSwitchBrute(int n) {
        boolean[] track = new boolean[n];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i)
                track[j - 1] = !track[j - 1];
        }
        int count = 0;
        for (int i = 0; i < n; i++)
            if (track[i])
                count++;
        System.out.println(n + "-->" + Arrays.toString(track));
        return count;
    }

    // ! ============= LC3842. Toggle Light Bulbs =============
    /*
    @ TC --> O(N + 100) --> Setting Bulbs and Counting
    @ SC --> O(100) --> Tracking the bulb state
    */
    public static List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        boolean[] track = new boolean[100];
        for (int i : bulbs)
            track[i - 1] = !track[i - 1];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < track.length; i++)
            if (track[i])
                res.add(i + 1);
        return res;
    }

    // ! ============= LC1780. Check if Number is a Sum of Powers of Three =============
    /*
    @ TC --> O(log N) --> because if we convert the number to base 3
                        (91)₁₀ = (10101)₃   --> TRUE
                        (12)₁₀ = (00110)₃   --> TRUE
                        (46)₁₀ = (01201)₃   --> FALSE
                        --> so in base 3 if we had 2 as bit it is False 
    @ SC --> o(1) --> not using any extra Data Structure         
    */
    public static boolean checkPowersOfThreeBetter(int n) {
        while (n > 0) {
            if (n % 3 == 2)
                return false;
            n = n / 3;
        }
        return true;
    }

    /*
    @ TC --> O(N !) --> every time running loop and REC from idx --> idx+1,idx+2.....
    @ SC --> O(N !) --> recursive Stack space Ignorable         
    */
    public static boolean checkPowersOfThreeBrute(int n) {
        return checkPow(0, 10, n);
    }

    public static boolean checkPow(int i, int n, int target) {
        if (target == 0)
            return true;
        if (target < 0)
            return false;
        for (int idx = i; idx <= n; idx++) {
            int pow = (int) Math.pow(3, idx);
            if (pow > target)
                break;
            boolean res = checkPow(idx + 1, n, target - pow);
            if (res)
                return true;
        }
        return false;
    }
}
// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC1780. Check if Number is a Sum of Powers of Three ✅
// 2. LC319. Bulb Switcher ✅
// 3. LC3842. Toggle Light Bulbs ✅