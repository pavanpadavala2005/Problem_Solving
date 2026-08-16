import java.util.LinkedList;

public class July23 {

    // ! =============== Binary to Decimal V1 ================
    public static int binToDecV1(String s) {
        int res = 0;
        int val = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1')
                res += val;
            val *= 2;
        }
        return res;
    }

    // ! =============== Decimal to Binary V1 ================
    public static LinkedList<Integer> decimalToBinV1(int num) {
        LinkedList<Integer> res = new LinkedList<>();
        while (num > 0) {
            int rem = num % 2;
            res.addFirst(rem);
            num /= 2;
        }
        return res;
    }

    // ! =============== Decimal to Binary V2 ================
    public static StringBuilder decimalToBinV2(int num) {
        StringBuilder res = new StringBuilder("");
        while (num > 0) {
            int rem = num % 2;
            res.append(Integer.toString(rem));
            num /= 2;
        }
        return res.reverse();
    }
}