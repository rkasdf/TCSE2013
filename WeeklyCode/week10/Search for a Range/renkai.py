class Solution:
    # @param A, a list of integers
    # @param target, an integer to be searched
    # @return a list of length 2, [index1, index2]
    def searchRange(self, A, target):
        i = 0; j = len(A)-1
        while i <= j:
            mid = (i+j) / 2
            if A[mid] > target:
                j = mid - 1
            elif A[mid] < target:
                i = mid + 1
            else:
                ret = [0, len(A)-1]
                if A[i] == target: ret[0] = i
                if A[j] == target: ret[1] = j
                for k in range(mid, j+1):
                    if A[k] != target: ret[1] = k-1; break
                for k in range(mid, i-1, -1):
                    if A[k] != target: ret[0] = k+1; break
                return ret
        return [-1, -1]