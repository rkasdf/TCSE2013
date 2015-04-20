class Solution:
    # @param s, a string
    # @return an integer
    def minCut(self, s):
        dp = [i for i in range(len(s)+1)]
        p = [ [ False for i in range(len(s)) ] for j in range(len(s)) ]
        for i in range(1, len(s)):
            for j in range(i-1, -1, -1):
                if s[i] == s[j] and (p[i-1][j+1] or (i-j) < 3):
                    p[i][j] = True
                    dp[i+1] = min(dp[i+1], dp[j]+1)
                else:
                    dp[i+1] = min(dp[i+1], dp[i]+1)
        return dp[len(s)]-1