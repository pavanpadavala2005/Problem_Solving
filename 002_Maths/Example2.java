public class Example2 {
    // ! =============== Check Prime ================
    public static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        int i = 2;
        while (i * i <= num) {
            if (num % i == 0)
                return false;
            i++;
        }
        return true;
    }

    // ! =============== Factors ================
    public static void factors(int num) {
        int i = 1;
        while (i * i <= num) {
            if (num % i == 0) {
                System.out.print(i + " ");
                if ((num / i) != i)
                    System.out.print(num / i + " ");
            }
            i++;
        }
    }

    // ! =============== Primes in Range ================
    public static void primesInRange(int n) {
        boolean[] primes = new boolean[n + 1];
        for (int i = 2; i * i <= n; i++) {
            if (!primes[i]) {
                for (int j = i * 2; j <= n; j += i)
                    primes[j] = true;
            }
        }
        for (int i = 2; i <= n; i++) {
            if (!primes[i])
                System.out.print(i + " ");
        }
    }

    // ! =============== Square Root ================
    public static double sqrt(int n, int p) {
        int s = 0;
        int e = n;
        double root = 0.0d;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (mid * mid == n)
                return mid;
            if (mid * mid > n)
                e = mid - 1;
            else
                s = mid + 1;
        }
        double incr = 0.1d;
        for (int i = 0; i < p; i++) {
            while (root * root < n)
                root += incr;
            root -= incr;
            incr = incr / 10;
        }
        return root;
    }

    // ! =============== Square Root using Newton's Method ================
    public static double sqrtNewton(int n) {
        double x = n;
        double root;
        int count = 0;
        while (true) {
            count++;
            root = (x + (n / x)) * 0.5;
            if (Math.abs(root - x) < 0.05) // Changed on 09/07/2026
                break;
            x = root;
            System.out.println(root);
        }
        System.out.println(count);
        return root;
    }

    // ! =============== Factors V2 ================
    public static void factors1(int n) {
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (n / i == i)
                    System.out.print(" " + i + " ");
                else
                    System.out.print(i + " " + n / i + " ");
            }
        }
    }

}