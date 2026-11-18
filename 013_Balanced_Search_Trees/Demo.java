public class Demo {

    public static void main(String[] args) {
        System.out.println(solve(new int[] { 7, 9, 5, 2 }));
    }

    public static int solve(int[] nums) {
        int n = nums.length;
        int j = n - 1;
        while (j >= 0) {
            if (nums[j] != 0 && nums[j] % 2 == 0)
                break;
            j--;
        }
        int i = 0;
        while (i < n) {
            if (nums[i] != 0 && nums[i] % 2 == 0)
                break;
            i++;
        }
        if (i >= j)
            return 0;
        return j - i;
    }

}
