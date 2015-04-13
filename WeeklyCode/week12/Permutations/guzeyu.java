public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(num,result,0);
        return result;
    }
	
	private void dfs(int[] num, List<List<Integer>> result, int start){
		if(start==num.length) result.add(convertArrToList(num));
		for(int currIndex=start;currIndex<num.length;currIndex++){
			if(hasDuplicate(num, start,currIndex)) continue;
			swap(num,start,currIndex);
			dfs(num,result,start+1);
			swap(num,start,currIndex);
		}
	}
	
	private List<Integer> convertArrToList(int[] num){
		List<Integer> curr = new ArrayList<Integer>();
		for(int i=0;i<num.length;i++){
			curr.add(num[i]);
		}
		return curr;
	}
	private void swap(int[] num, int x, int y){
		int temp = num[x];
		num[x] = num[y];
		num[y] = temp;
	}
	
	private boolean hasDuplicate(int[] num, int start,int currIndex){
		for(int j=start;j<currIndex;j++){
			if(num[j] == num[currIndex]){
				return true;
			}
		}
		return false;
	}
}