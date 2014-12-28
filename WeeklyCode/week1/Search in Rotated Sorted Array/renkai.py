__author__ = 'inferno'
class Solution:
    def search(self, A, target):
        A_len = len(A)
        start = 0
        end = A_len - 1
        while start != end:
            mid = int((end + start)/2)
            if A[mid] == target:
                return mid
            elif A[start] <= A[mid]:
                if A[start] <= target and target < A[mid]:
                    end = mid
                else:
                    start = mid + 1
            else:
                if A[mid] < target and target <= A[end]:
                    start = mid+1
                else:
                    end = mid
        print start
        if A[start] == target:
            return start
        return -1

A = [3,1]
target = 1
a = Solution()
b = a.search(A,target)
print b