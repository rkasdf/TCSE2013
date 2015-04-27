public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> ans = new LinkedList<Interval>();
		Collections.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				if(o1.start == o2.start){
					return o1.end-o2.end;
				}
				return o1.start-o2.start;
			}	
		});
		for(int i=0;i<intervals.size();i++){
			Interval cur = intervals.get(i);
			while(i<intervals.size()-1 && cur.end>=intervals.get(i+1).start){
				cur.end= cur.end >intervals.get(i+1).end? cur.end :intervals.get(i+1).end;
				i++;
			}
			ans.add(cur);
		}
		return ans;		     
    }	
}
