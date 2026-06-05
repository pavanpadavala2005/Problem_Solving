import java.util.*;

public class June04 {
    public static ArrayList<Integer> findLeaders(int[] nums) {
        // ! Brute Force --> Using 2 for loops

        // ArrayList<Integer> res = new ArrayList<>();a
        // for (int i = 0; i < n; i++) {
        // boolean isLeader = true;
        // for (int j = i + 1; j < n - 1; j++) {
        // if (elements.get(j) < elements.get(i))
        // isLeader = false;
        // }
        // if (isLeader)
        // res.add(elements.get(i));
        // }
        // return res;

        // ! Better --> Using Stack -- with Extra Space of O(N)
        // Stack<Integer> st = new Stack<>();
        // ArrayList<Integer> res = new ArrayList<>();
        // for (int i = nums.length - 1; i >= 0; i--) {
        // while (st.size() > 0 && st.peek() <= nums[i]) {
        // st.pop();
        // }
        // if (st.isEmpty()) {
        // res.add(0, nums[i]);
        // st.push(nums[i]);
        // }
        // }
        // return res;
        ArrayList<Integer> res = new ArrayList<>();
        int maxElem = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] >= maxElem) {
                maxElem = nums[i];
                res.add(0, maxElem);
            }
        }
        return res;
    }

    // ! Leet 1304
    public static int[] setZero(int n) {
        int[] res = new int[n];
        int idx = 0;
        int val = 1;
        if (n % 2 == 1) {
            res[idx] = 0;
            idx++;
        }
        for (int i = idx; i < n; i += 2) {
            res[i] = val;
            res[i + 1] = -val;
            val++;
        }
        return res;
    }

    // ! Leet 66
    public static int[] plusOne(int[] digits) {
        // int n = digits.length;
        // int[] res = new int[n];
        // int carry = 0;
        // int num = 1;
        // for (int i = n - 1; i >= 0; i--) {
        // int val = carry + digits[i] + num;
        // carry = val / 10;
        // res[i] = val % 10;
        // num = 0;
        // }
        // if (carry > 0) {
        // int[] newRes = new int[n + 1];
        // newRes[0] = carry;
        // for (int j = 0; j < n; j++)
        // newRes[j + 1] = res[j];
        // return newRes;
        // }
        // return res;

        // ! Optimal Approach

        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] > 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newArr = new int[n + 1];
        newArr[0] = 1;
        return newArr;
    }
}