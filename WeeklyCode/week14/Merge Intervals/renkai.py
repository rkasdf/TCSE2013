class Solution:
    # @param {Interval[]} intervals
    # @return {Interval[]}
    def merge(self, intervals):
        intervals.sort(key = lambda x : x.start)
        res = []
        for i in range(len(intervals)):
            if res == []: res.append(intervals[i])
            else:
                if res[-1].start <= intervals[i].start and intervals[i].start <= res[-1].end:
                    res[-1].end = max(res[-1].end, intervals[i].end)
                else: res.append(intervals[i])
        return res