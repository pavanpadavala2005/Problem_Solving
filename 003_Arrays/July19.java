public class July19 {

    // ! =============== FIND MIN ELEMENT IN ROTATED ARRAY II =============
    public static int findMinELemenet(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        System.out.println(i + " " + j);
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] <= nums[j])
                j = mid;
            else
                i = mid + 1;
            System.out.println(mid + "-" + i + "-" + j);
        }
        return nums[i];
    }
}