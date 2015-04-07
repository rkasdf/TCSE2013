class Solution:
    # @param s, a string
    # @return a list of strings
    def restoreIpAddresses(self, s):
        def backTracking(s, seq, ip, ret):
            if seq == 4:
                if s == '':
                    ret.append(ip[1:])
                return
            for i in range(1, 4):
                if i <= len(s):
                    if int(s[:i]) < 256:
                        backTracking(s[i:], seq+1, ip+'.'+s[:i], ret)
                    if s[0] == '0':
                        break
        ret = []
        backTracking(s, 0, '', ret)
        return ret