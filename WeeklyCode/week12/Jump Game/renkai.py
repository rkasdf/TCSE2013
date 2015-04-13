class Solution:
    # @param A, a list of integers
    # @return an integer
    def jump(self, A):
        cur = 0; last = 0; ret = 0
        for i in range(len(A)):
            if i > last: ret += 1; last = cur
            cur = max(cur, i+A[i])
        return ret

		
class Solution:
    # @param A, a list of integers
    # @return an integer
    def jump(self, A):
        i = 0; j = 1; cur = 0; step=0
        if len(A) == 0: return
        if len(A) == 1: return 0
        while i < len(A)-1 and i + A[i] < len(A)-1:
            cur = j
            if not A[i]: return
            for j in range(j, A[i]+i+1):
                if cur+A[cur] < j+A[j]: cur = j
            i = cur
            step += 1
        return step+1