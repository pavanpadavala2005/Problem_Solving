public class BitManipulation {
    public static boolean isSetBit(int n, int k) {
        return (n & (1 << k)) != 0;
    }
}
