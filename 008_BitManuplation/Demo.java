import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        // ! July 27 Stuff
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
