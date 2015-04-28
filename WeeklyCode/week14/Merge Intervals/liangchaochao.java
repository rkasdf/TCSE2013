/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() < 2) return intervals;
        List<Interval> answer = new ArrayList<>();
        for(Interval cur : intervals){
            answer = insert(answer, cur);
        }
        return answer;
    }
    
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> answer = new ArrayList<>();
        boolean compare = true;
        for(Interval cur : intervals){
            if(compare && isOverlapped(cur, newInterval)){
                newInterval = merge(cur, newInterval);
            }else if(compare && cur.start > newInterval.end){
                compare = false;
                answer.add(newInterval);
                answer.add(cur);
            }else{
                answer.add(cur);
            }
        }
        if(compare) answer.add(newInterval);
        return answer;
    }
    
    public boolean isOverlapped(Interval a, Interval b){
        return (b.end - a.start) * (b.start - a.end) <= 0;
    }
    
    public Interval merge(Interval a, Interval b){
        int end = a.end > b.end ? a.end : b.end;
        int start = a.start < b.start ? a.start : b.start;
        return new Interval(start, end);
    }
}
