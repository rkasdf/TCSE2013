public class Solution {
    public int atoi(String str) {
        boolean sign = true, flag = true;
        long result = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ' && flag)
                continue;
            else {
                flag = false;
                if (c == '-' && isNumeric(str.charAt(i + 1)))
                    sign = false;
                else if (c == '+' && isNumeric(str.charAt(i + 1)))
                    sign = true;
                else if (!isNumeric(c))
                    break;
                else {
                    result = result * 10 + (c - 48);
                    if (result >= Integer.MAX_VALUE)
                        break;
                }
            }
        }

        if (sign)
            return result >= Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
        else
            return result > Integer.MAX_VALUE ? Integer.MIN_VALUE : (int) -result;
    }

    private boolean isNumeric(int c) {
        return c >= 48 && c <= 57;
    }
}
