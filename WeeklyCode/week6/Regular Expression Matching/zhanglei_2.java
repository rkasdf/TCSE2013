public class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;

        for (int j = 1; j <= pLen; j++) {
            if (p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 2];
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*')
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && isEqual(p.charAt(j - 2), s.charAt(i - 1)));
                else
                    dp[i][j] = dp[i - 1][j - 1] && isEqual(p.charAt(j - 1), s.charAt(i - 1));
            }
        }

        return dp[sLen][pLen];
    }

    private boolean isEqual(char i, char j) {
        return i == j || i == '.';
    }
}