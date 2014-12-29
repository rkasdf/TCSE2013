public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        int Dvalue, sum;
        Arrays.sort(num);
        for(int i=0; i<num.length; i++){
            int j = i + 1;
            int k = num.length - 1;
            while(j<k){
                sum = num[i] + num[j] + num[k];
                Dvalue = Math.abs(sum-target);
                if(Dvalue == 0) return sum;
                else if(Dvalue < min){
                    min = Dvalue;
                    result = sum;
                }
                if(sum < target){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return result;
    }
}
