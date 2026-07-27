public class BitManuplationUtils {

    public static String getBinary(int n) {
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            int last = n & 1;
            res.append(Integer.toString(last));
            n >>= 1;
        }
        return res.reverse().toString();
    }

}
