public class Oct20 {
    // ! ============= LC152. Maximum Product Subarray ============
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProd = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;

        for (int i = 0; i < n; i++) {
            if (prefix == 0)
                prefix = 1;
            if (suffix == 0)
                suffix = 1;
            prefix *= nums[i];
            suffix *= nums[i];
            maxProd = Math.max(maxProd, Math.max(prefix, suffix));
        }
        return maxProd;
    }
}
// ! Target Min -> 2 , Max -> 5 (Quality Problems Only)
// 1. LC152. Maximum Product Subarray ✅
