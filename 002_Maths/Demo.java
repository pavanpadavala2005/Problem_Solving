public class Demo {
    public static void main(String[] args) {

        // ! ============== Sep 21 Problems =============
        // System.out.println(Sep21.powerExponentiationV2(
        //     2, 10
        // 
        // ));

        // ! ============== Sep 22 Problems =============

        // Sep22.sieveOfEratosthenes(40);

        // System.out.println(Sep22.sqrtBrute(40, 3));

        // System.out.println(Sep22.newtonSquareRootBrute(
        // 40
        // 36
        // ));

        // System.out.println(Sep22.isUglyV1(-2147483648));
    }
}

// TODO:
// ! ============= GEN. Newton Raphson Square Root method =============
public static double newtonSquareRootBrute(int num) {
    double error = 0.01;
    double x = 1.0;
    while (Math.abs(((x + (num / x)) / 2) - x) > error) {
        x = (x + (num / x)) / 2;
    }
    return x;
}
