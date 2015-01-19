class Solution:
    # @return an integer
    def positive(self, str):
        sum = 0
        for i in range(len(str)):
            if str[i] < '0' or str[i] > '9':
                return sum if sum > 0 else -1
            else:
                sum = sum*10 + int(str[i])
        return sum
    def atoi(self, str):
        if len(str) == 0:
            return 0
        i = 0
        while str[i] == ' ': i += 1
        if str[i] == '+':
            res = self.positive(str[i+1:])
            if res > 2147483647: return 2147483647
            return res if res !=-1 else 0
        if str[i] == '-':
            res = self.positive(str[i+1:])
            if res > 2147483648: return -2147483648
            return 0-res if res !=-1 else 0
        if str[i] >= '0' and str[i] <= '9':
            res = self.positive(str[i:])
            if res > 2147483647: return 2147483647
            return res if res != -1 else 0
        return 0