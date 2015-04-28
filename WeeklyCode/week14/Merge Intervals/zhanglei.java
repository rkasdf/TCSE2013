public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        for (int i = 0; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            for (; i < intervals.size() - 1 && curr.end >= intervals.get(i + 1).start; i++) {
                curr.end = Math.max(curr.end, intervals.get(i + 1).end);
            }
            result.add(curr);
        }

        return result;
    }
}