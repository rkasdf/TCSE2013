class Solution:
    # @return a boolean
    def isValid(self, s):
        stack = []
        for i in range(len(s)):
            if s[i] in '([{':
                stack.append(s[i])
            elif s[i] in ')]}':
                if len(stack) < 1: return False
                if ord(s[i]) - ord(stack.pop()) > 2: return False
        return False if len(stack) else True