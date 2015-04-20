public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        //dp[i][j] s1 (0 - i) s2 (0 - j)
        if(s3.length() > s1.length() + s2.length()) return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for(int index = 0; index < s3.length(); index++){
            char cur = s3.charAt(index);
            //i ，j 代表选择的个数
            for(int i = index + 1, j = 0; i >= 0 && j <= index + 1; i--, j++){
                if(i <= s1.length() && j <= s2.length()){
                    if(i != 0 && s1.charAt(i - 1) == cur){
                        if(dp[i - 1][j]) dp[i][j] = true;
                    }
                    if(j != 0 && s2.charAt(j - 1) == cur){
                        if(dp[i][j - 1]) dp[i][j] = true;
                    }
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
