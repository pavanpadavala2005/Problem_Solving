import java.util.*;

public class Sep14 {
    // ! ============== LC476. Number Complement =============
    /*
     @ TC --> O(log N) --> every time number is reducing by 2
     @ SC --> O(1) --> not using anything other than variables
    */
    public static int findComplement(int num) {
        int res = 0;
        int i = 0;
        while (num != 0) {
            if ((num & 1) == 0)
                res = res | (1 << i);
            num = num >>> 1;
            i++;
        }
        return res;
    }

    // ! ============== LC405. Convert a Number to Hexadecimal =============
    // * Interesting
    // @ TC --> o(log4(N) * 4) --> every time number getting reduced /4 and
    // extracting last 4 bits
    // @ SC --> O(32/4) --> because 8 bits --> 1 hex and 8 Hex are required to show
    // max
    public static String toHex(int num) {
        if (num == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int rem = 0;
            int val = 1;
            for (int i = 0; i < 4; i++) {
                if ((num & (1 << i)) != 0)
                    rem += val;
                val = val << 1;
            }
            if (rem < 10)
                sb.append((char) ('0' + rem));
            else
                sb.append((char) ('a' + (rem - 10)));
            num = num >>> 4;
        }
        return sb.reverse().toString();
    }

    // ! ============== LC78. Subsets =============
    /*
     @ TC --> O(2ⁿ) --> we need to get every combination
     @ SC --> O(nⁿ) --> Store all Possible combos
    */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < 1 << nums.length; i++) {
            List<Integer> elems = new ArrayList<>();
            int num = i;
            int count = 0;
            while (num > 0) {
                if ((num & 1) != 0)
                    elems.add(nums[count]);
                count++;
                num = num >> 1;
            }
            res.add(elems);
        }
        return res;
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC405. Convert a Number to Hexadecimal ✅
// 2. LC78. Subsets ✅
// 3. LC476. Number Complement ✅