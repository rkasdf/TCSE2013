class Solution:
    # @param haystack, a string
    # @param needle, a string
    # @return an integer
    def compute_next(self, needle):
        next = [-1] * len(needle)
        j = -1
        for i in range(1, len(needle)):
            while j > -1 and needle[j+1] != needle[i]:
                j = next[j]
            if needle[i] == needle[j+1]: j += 1
            next[i] = j
        return next

    def strStr(self, haystack, needle):
        if len(needle)==0: return 0
        #if len(needle)==0 or len(haystack)==0: return -1
        next = self.compute_next(needle)
        i = 0
        j = -1
        for i in range(len(haystack)):
            while j > -1 and haystack[i] != needle[j+1]:
                j = next[j]
            if haystack[i] == needle[j+1]: j += 1
            if j == len(needle) - 1:
                return i-j
        return -1