
public class June1 {
    public static int maxOf4Numbers(int a, int b, int c, int d) {
        // if (a > b && a > c && a > d)
        // return a;
        // else if (b > a && b > c && b > d)
        // return b;
        // else if (c > a && c > b && c > d)
        // return c;
        // return d;

        int max = Integer.MIN_VALUE;
        if (a > max)
            max = a;

        if (b > max)
            max = b;
        if (c > max)
            max = c;
        if (d > max)
            max = d;
        return max;
    }

    public static boolean inRange(float num) {
        return num >= 0 && num <= 10;
    }

    public static boolean isLeap(int num) {
        // if (year % 400 == 0)
        // return true;
        // else if (year % 100 != 0)
        // return false;
        // else if (year % 4 == 0)
        // return true;
        // return false;

        if (num % 400 == 0)
            return true;
        else if (num % 4 == 0)
            if (num % 100 == 0)
                return false;
            else
                return true;
        return false;

    }

}
