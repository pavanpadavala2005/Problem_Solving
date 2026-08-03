import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        // ! July 26 Stuff

        // System.out.println(July26.intToBin(10));

        // System.out.println(July26.binToInt(July26.intToBin(10)));

        // System.out.println(15 ^ 1);
        // System.out.println(July26.rightMostSetBit(10));
        // System.out.println(Integer.toBinaryString(~(1 << 31) | (1 << 31)));

        // !
        // System.out.println(
        // Integer.toBinaryString(
        // ((~(1 << 31) | (1 << 31)) ^ 10)));
        // System.out.println(
        // Integer.toBinaryString(10));

        // System.out.println(10 ^ 2);

        // int a = 12;
        // int b = 7;
        // System.out.println((a ^ b) + ((a & b) << 1));
        // ! July 27 Stuff
        // System.out.println(July27.singleNumberII(
        // new int[] {
        // 5, 5, 5, 3, 2, 2, 2
        // }));

        // String s = BitManuplationUtils.getBinary(20);
        // System.out.println(
        // BitManuplationUtils.getInteger(s));

        // System.out.println(-1 >>> 31);
        // System.out.println(~10);

        // System.out.println(Integer.toBinaryString(1 << 7));

        // System.out.println(BitManipulationUtils.removeRightSetBit(0));
        // System.out.println(BitManipulationUtils.findRightMostSetBitPosition(0));
        // System.out.println(
        // BitManipulationUtils.rangeMask(1, 2, 3, 4));

        // System.out.println(BitManipulationUtils.rangeMaskOptimal(1, 4));
        // System.out.println(BitManipulationUtils.findRightMostSetBitPosition(20));

        // System.out.println(July28.powerSetArray(
        // new int[] { 1, 2, 3 }));
        // System.out.println(July28.powerSetString(
        // "abc"));

        // System.out.println(
        // July28.singleNumberIIOptimal1(
        // new int[] { 1 }));

        // System.out.println(July28.singleNumberIIOptimal2(
        // new int[] {
        // 2, 2, 2, 1 }));

        System.out.println(Arrays.toString(
                July28.singleNumberIIIOptimal(new int[] {
                        // 2, 4, 2, 14, 3, 7, 7, 3
                        1, 2, 1, 3, 2, 5
                })));

        System.out.println(BitManipulationUtils.findRightMostSetBitPosition(10));
    }
}
