class Solution:
    # @param num, a list of integer
    # @return a list of lists of integer
    def subsetsWithDup(self, S):
        def backTracking(seq, start, subS, ret):
            if subS not in ret: ret.append(subS)
            if seq == len(S): return
            for i in range(start, len(S)):
                backTracking(seq+1, i+1, subS + [S[i]], ret)
        S.sort()
        ret = []
        backTracking(0, 0, [], ret)
        return ret
		
		
class Solution:
    # @param num, a list of integer
    # @return a list of lists of integer
    def subsetsWithDup(self, S):
        S.sort()
        newS, undupS = {}, []
        for i in range(len(S)):
            if newS.has_key(S[i]):
                newS[S[i]] += 1
            else:
                newS[S[i]] = 1
                undupS.append(S[i])
        def getSetsWithDup(undups, newS, ret, seq, subS):
            if seq == len(newS):
                ret.append(subS)
            else:
                num = newS[undups[seq]]
                temp = []
                for i in range(num+1):
                    if i:
                        temp.append(undups[seq])
                    getSetsWithDup(undups, newS, ret, seq+1, subS+temp)
        ret = []
        getSetsWithDup(undupS, newS, ret, 0, [])
        return ret