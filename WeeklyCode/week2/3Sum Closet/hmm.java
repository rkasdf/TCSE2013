public class Solution {
    private int[] quickSort(int[] num, int begin, int end){
	        if(begin >= end) return num;
	        int i=begin+1,j=end,temp;
	        while(i<j){
	            while(i<end && num[i]<=num[begin])i++;
	            while(j>begin && num[j]>=num[begin])j--;
	            if(i<j){
	                temp = num[i];
	                num[i] = num[j];
	                num[j] = temp;
	            }
	        }
	        temp = num[j];
	        num[j] = num[begin];
	        num[begin] = temp;
	        num = quickSort(num, begin, j-1);
	        num = quickSort(num, j+1, end);
	        return num;
	 }
    public int threeSumClosest(int[] num, int target) {
        if(num == null || num.length < 3) return -1;
        //sort
        num = quickSort(num,0,num.length-1);
        int closest = num[0]+num[1]+num[2];
        int sum, i, j;
        for(int k=0;k<num.length;k++){
            int oneNum = num[k];
            i = 0;
            j = num.length-1;
            while(i<j){
                if(i == k){
                    i++;
                    continue;
                }else if(j == k){
                    j--;
                    continue;
                }
                sum = oneNum + num[i] + num[j];
                if(Math.abs(target-closest) > Math.abs(target-sum)){
                    closest = sum;
                }
                if(sum > target){
                    j--;
                }else{
                    i++;
                }
            }
        }
        return closest;
    }
}