public class July06 {
    public static int searchRotatedArrayRec(int[] nums, int target) {
        return searchRotatedArrayRec(nums, target, 0, nums.length - 1);
    }

    public static int searchRotatedArrayRec(int[] nums, int target, int i, int j) {
        if (i > j) {
            return -1;
        }
        int mid = i + (j - i) / 2;
        if (nums[mid] == target)
            return mid;
        // Left Part is Sorted
        else if (nums[i] <= nums[mid]) { 
            if (nums[i] <= target && target <= nums[mid])
                return searchRotatedArrayRec(nums, target, i, mid - 1);
            else
                return searchRotatedArrayRec(nums, target, mid + 1, j);
        }
        // Right Part is Sorted
        else {
            if (nums[mid] <= target && target <= nums[j])
                return searchRotatedArrayRec(nums, target, mid + 1, j);
            else
                return searchRotatedArrayRec(nums, target, i, mid - 1);
        }
    }

    public static int searchRotatedArray(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            System.out.println(mid);
            if (nums[mid] == target)
                return mid;
            // Left Part is Sorted --> Search i Left Array
            else if (nums[i] <= nums[mid]) {
                if (nums[i] <= target && target <= nums[mid])
                    j = mid - 1;
                else
                    i = mid + 1;
            }
            // Right Part is Sorted --> Search i Right Array
            else {
                if (nums[mid] <= target && target <= nums[j])
                    i = mid + 1;
                else
                    j = mid - 1;
            }
        }
        return -1;
    }

    // // Right Part is Sorted
    // else if (nums[mid] <= nums[j]) {
    // if (target >= nums[mid] && target <= nums[j])
    // i = mid + 1;
    // else
    // j = mid - 1;
    // }
    // // Left Part is Sorted
    // else {
    // if (target >= nums[i] && target <= nums[mid])
    // i = mid + 1;
    // else
    // j = mid - 1;
    // }
    private static int firstOccurance(int[] nums, int target) {
        // ! Utility Method for Finding First Occurance
        int i = 0;
        int j = nums.length - 1;
        int f = -1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                f = mid;
                j = mid - 1;
            } else if (nums[mid] < target)
                i = mid + 1;
            else
                j = mid - 1;
        }
        return f;
    }

    private static int lastOccurance(int[] nums, int target) {
        // ! Utility Method for Finding First Occurance
        int i = 0;
        int j = nums.length - 1;
        int f = -1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                f = mid;
                i = mid + 1;
            } else if (nums[mid] < target)
                i = mid + 1;
            else
                j = mid - 1;
        }
        return f;
    }

    public static int[] getFirstAndLastOccuranceOptimal(int[] nums, int target) {
        int lb = firstOccurance(nums, target);
        if (lb == -1)
            return new int[] { -1, -1 };
        int ub = lastOccurance(nums, target);
        return new int[] { lb, ub };
    }

    public static int[] getFirstAndLastOccuranceBrute(int[] nums, int target) {
        int lb = lowerBound(nums, target);
        int ub = upperBound(nums, target);
        if (lb == nums.length || nums[lb] != target) {
            return new int[] { -1, -1 };
        }
        return new int[] { lb, ub - 1 };
    }

    public static int findFloor(int[] nums, int target) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        int idx = -1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] <= target) {
                idx = mid;
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return idx;
    }

    public static int lowerBound(int[] nums, int target) {
        // Need to Find an smallest possible index whew arr[index] >= target
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        int idx = n;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] >= target) {
                idx = mid;
                j = mid - 1;
            } else
                i = mid + 1;
        }
        return idx;
    }

    public static int upperBound(int[] nums, int target) {
        // Need to Find an smallest possible index whew arr[index] > target
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        int idx = -1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > target) {
                idx = mid;
                j = mid - 1;
            } else
                i = mid + 1;
        }
        return idx;
    }

    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        int idx = n;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] >= target) {
                idx = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return idx;
    }
}
