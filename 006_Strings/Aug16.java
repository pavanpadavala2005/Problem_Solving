
public class Aug16 {
    // ! =============== LC151. Reverse Words in a Strings ================
    public static String reverseWordsBetter(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (temp.length() > 0) {
                    res.append(temp).append(" ");
                    temp.setLength(0);
                }
            } else
                temp.insert(0, s.charAt(i));
        }
        res.append(temp);
        return res.toString().trim();
    }

    public static String reverseWordsBrute(String s) {
        String rev = "";
        String temp = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!temp.equals("") && s.charAt(i) == ' ') {
                rev += temp + " ";
                temp = "";
            } else if (temp.equals(" ") && s.charAt(i) == ' ')
                continue;
            else
                temp = s.charAt(i) + temp;
        }
        rev += temp;
        return rev.trim();
    }
}