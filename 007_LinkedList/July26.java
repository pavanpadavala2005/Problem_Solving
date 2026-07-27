import java.util.*;

public class July26 {
    public static boolean isOdd(int num) {
        return (num & 1) == 0;
    }

    public static int rightMostSetBit(int num) {
        return num & -num;
    }

    // public static int twosCompliement(int num) {

    // }
}
