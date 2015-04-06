public class WordLadderEnum {	
    public int ladderLength(String start, String end, Set<String> dict) {
    	Map<String,Integer> map = new HashMap<String,Integer>();
    	Queue<String> queue = new LinkedList<String>();
    	queue.add(start);
    	map.put(start, 1);
    	while(!queue.isEmpty()){
    		String cur = queue.poll();
    		int dis = map.get(cur);
    		char[] c = cur.toCharArray();
    		for(int i=0; i < c.length; i++){
    			char original = c[i];
    			for(char j = 'a'; j <= 'z'; j++){
    				if(j!=original){
    					c[i]=j;
    					String tmp = String.valueOf(c);
    					if(tmp.equals(end)){
    						return dis+1;
    					}
    					if(dict.contains(tmp)&&!map.containsKey(tmp)){
    						queue.add(tmp);
    						map.put(tmp, dis+1);
    					}
    				}
    			}
    			c[i] = original;
    		}
    	}
		return 0;       
    }
}
