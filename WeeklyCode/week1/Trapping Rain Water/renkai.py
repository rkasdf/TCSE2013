__author__ = 'kai'
class Solution:
    # @param A, a list of integers
    # @return an integer
    def trap(self, A):
        A_len = len(A)
        left = [0] * A_len
        right = [0] * A_len
        for i in range(1, A_len, 1):
            if A[i-1] > left[i-1]:
                left[i] = A[i-1]
            else:
                left[i] = left[i-1]
        for i in range(A_len-2, -1, -1):
            if A[i+1] > right[i+1]:
                right[i] = A[i+1]
            else:
                right[i] = right[i+1]
        sum = 0
        for i in range(1, A_len-1, 1):
            minvalue = min(left[i], right[i])
            if minvalue > A[i]:
                sum += minvalue - A[i]
        return sum
