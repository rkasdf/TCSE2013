class Solution:
    # @param s, a string
    # @return a boolean
    def isPalindrome(self, s):
        if len(s) == 0:
            return True
        i = 0
        j = len(s) - 1
        s = s.lower()
        while i < j :
            if s[i] < '0' or s[i] > 'z' or s[i] > '9' and s[i] < 'a':
                i += 1
                continue
            if s[j] < '0' or s[j] > 'z' or s[j] > '9' and s[j] < 'a':
                j -= 1
                continue
            if s[i] != s[j]:
                return False
            i += 1
            j -= 1
        return True