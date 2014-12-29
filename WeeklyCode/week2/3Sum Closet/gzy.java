public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
		if(num == null || num.length < 3){
			return Integer.MIN_VALUE;
		}
        Arrays.sort(num);
        int difference = num[0]+num[1]+num[2]-target;
        for(int i=0;i<num.length-2;i++){
        	int newDifference = twoSumCloset(num, target-num[i], i+1);
        	if(Math.abs(newDifference) < Math.abs(difference)){
        		difference = newDifference;
        	}
        }
        return difference+target;
    }
	
	public int twoSumCloset(int[] num, int target, int startIndex) {
		if(num == null || num.length < 3){
			return Integer.MIN_VALUE;
		}
        int begin = startIndex;
        int end = num.length-1;
        int difference = num[begin] + num[end] - target;
        while(begin < end) {
        	int newDifference = num[begin] + num[end] - target;
        	if(newDifference == 0){
        		return 0;
        	}
        	if(newDifference < 0){
        		begin++;
        	}
        	if(newDifference > 0){
        		end--;
        	}
        	if(Math.abs(newDifference) < Math.abs(difference)){
        		difference = newDifference;
        	}
        }
        return difference;
    }
}