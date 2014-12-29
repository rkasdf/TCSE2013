__author__ = 'kai'
class Solution:
    # @return an integer
    def threeSumClosest(self, num, target):
        num.sort()
        num_len = len(num)
        mindiff = float("inf")
        closest = 0
        for i in range(num_len-2):
            first = i + 1
            last = num_len - 1
            while first < last:
                diff = num[i] + num[first] + num[last]
                if abs(diff - target) < mindiff:
                    mindiff = abs(diff - target)
                    closest = diff
                if diff == target:
                    return  target
                elif diff < target:
                    first += 1
                else:
                    last -= 1
        return  closest