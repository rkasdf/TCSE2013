public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
		HashMap<String,Integer> dist = new HashMap<String,Integer>();
		Queue<String> queue = new LinkedList<String>();
		queue.add(start);
		dist.put(start,1);
		while(!queue.isEmpty()){
		    String head = queue.poll();
		    int headDist = dist.get(head);
		    for(int i=0;i<head.length();i++){
		        for(char j='a';j<='z';j++){
		            if(head.charAt(i) == j) continue;
		            StringBuilder sb = new StringBuilder(head);
		            sb.setCharAt(i,j);
		            String word = sb.toString();
		            if(word.equals(end))return headDist+1;
		            if(dict.contains(word) && !dist.containsKey(word)){
		                queue.add(word);
		                dist.put(word,headDist+1);
		            }
		        }
		    }
		}
		return 0;
    }
}