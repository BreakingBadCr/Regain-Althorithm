package T008;

public class Solution {
    public int stringToInt(String s) {
        int i = 0, ans = 0, sign = 1, len = s.length();
        while (i < len && s.charAt(i) == ' ') ++i; // 去除最前面空格
        if (i < len && (s.charAt(i) == '-') || s.charAt(i) == '+') {
            sign = s.charAt(i++) == '+' ? 1 : -1;
        }
        for (; i < len; i++) {
            int tmp = s.charAt(i) - '0';
            if (tmp < 0 || tmp > 9) break;
            if (ans > Integer.MAX_VALUE / 10 || ans == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < tmp)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            else
                ans = ans * 10 + tmp;
        }
        return sign * ans;
    }
}
