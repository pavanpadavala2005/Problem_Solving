
public class Aug18 {

    // ! =============== LC451. Sort Characters By Frequency =========
    public static String frequencySortMoreBetter(String s) {
        // TODO : FIX THE ISSUE of OTHER THAN ALPHABETS
        if (s == null || s.equals(""))
            return "";
        StringBuilder res = new StringBuilder();
        int[] freq = new int[52];
        for (int i = 0; i < s.length(); i++) {
            int asc = s.charAt(i);
            int idx;
            if (asc >= 65 && asc <= 90)
                idx = asc - 65;
            else
                idx = asc - 71;
            freq[idx]++;
        }
        int idx = getMaxIdx(freq);
        while (idx >= 0) {
            for (int i = 0; i < freq[idx]; i++) {
                char ch;
                if (idx >= 0 && idx <= 25)
                    ch = (char) (idx + 65);
                else
                    ch = (char) (idx + 71);
                res.append(ch);
            }
            freq[idx] = 0;
            idx = getMaxIdx(freq);
        }
        return res.toString();

    }

    // @ TC -> O(s) + O(256) + O(count * 256)
    // @ SC -> O(256)
    public static String frequencySortBetter(String s) {
        if (s == null || s.equals(""))
            return "";
        StringBuilder res = new StringBuilder();
        int[] freq = new int[256];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i)]++;
        int idx = getMaxIdx(freq);
        while (idx > 0) {
            for (int i = 0; i < freq[idx]; i++)
                res.append((char) idx);
            freq[idx] = 0;
            idx = getMaxIdx(freq);
        }
        return res.toString();
    }

    // ! ============ HELPER FUNCTION for LC451 ===========
    public static int getMaxIdx(int[] nums) {
        int maxIdx = -1;
        int maxVal = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}