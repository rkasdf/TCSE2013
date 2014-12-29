__author__ = 'kai'
class Solution:
    def removeDuplicates(self, A):
        index = 0
        for i in range(len(A)):
            if i > 0 and i < len(A)-1 and A[i] == A[i-1] and A[i] == A[i+1]:
                print i
                continue
            A[index] = A[i]
            index += 1
        return index