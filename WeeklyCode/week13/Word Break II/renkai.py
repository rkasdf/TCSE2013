class Solution:
    # @param s, a string
    # @param dict, a set of string
    # @return a list of strings
    def wordBreak(self, s, dict):
        def check(str):
            if hash.has_key(str):
                return hash[str]
            dp = [False for i in range(len(str)+1)]
            dp[0] = True
            for i in range(1, len(str)+1):
                for j in range(i):
                    if dp[j] and str[j:i] in dict:
                        dp[i] = True
                        break
            hash[str] = dp[len(str)]
            return dp[len(str)]
        def dfs(str, subres):
            if len(str) == 0:
                res.append(subres[1:])
            if check(str):
                for i in range(1, len(str)+1):
                    if str[:i] in dict:
                        dfs(str[i:], subres+' '+str[:i])
        hash = {}; res = []
        dfs(s, '')
        return res