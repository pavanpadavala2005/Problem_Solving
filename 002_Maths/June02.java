public class June02 {

    // ! =============== LC1295. Find Numbers with Even Number of Digits
    // ================
    public static int findNumbers(int[] nums) {
        int ctr = 0;
        for (int i : nums) {
            int temp = i;
            int count = 0;
            while (temp > 0) {
                count++;
                temp /= 10;
            }
            if (count % 2 == 0)
                ctr++;
        }
        return ctr;
    }
}