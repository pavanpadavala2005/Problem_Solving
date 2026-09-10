import java.util.*;

public class Sep10 {

    // ! ============== LC2094. Finding 3-Digit Even Numbers =============
    public static int[] findEvenNumbers(int[] digits) {
        Arrays.sort(digits);
        ArrayList<Integer> res = new ArrayList<>();
        findEvenNumbers(digits, 0, res, new boolean[digits.length]);
        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            resArr[i] = res.get(i);
        return resArr;
    }

    public static void findEvenNumbers(int[] digits, int num, ArrayList<Integer> res, boolean[] track) {
        if (num >= 100 && num <= 999) {
            if (num % 2 == 0)
                res.add(num);
            return;
        }
        for (int i = 0; i < digits.length; i++) {
            if (num == 0 && digits[i] == 0 || track[i])
                continue;
            if (i > 0 && digits[i] == digits[i - 1] && !track[i - 1])
                continue;
            track[i] = true;
            num = num * 10 + digits[i];
            findEvenNumbers(digits, num, res, track);
            num = num / 10;
            track[i] = false;
        }
    }
}

// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC2094. Finding 3-Digit Even Numbers ✅
// 2. LC282. Expression Add Operators ❌