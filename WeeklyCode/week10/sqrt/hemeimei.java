public class Solution {
    public int sqrt(int x) {
        if(x<0) return 0;
        int count = 1,num10 = x;
        while((num10/=10)>0){
            count++;
        }
        int bit = (count-1)/2;
        int start = 1;
        int end = 9;
        while((bit--)>0){
            start *=10;
            end = end*10+9;
        }
        if(end>x) end = x;
        int mid = (start+end)/2, result = 0;
        while(start <= end){
            int mul = mid*mid;
            if(mul == x){
                return mid;
            }else if(mul<0 || mul>x){
                end = mid-1;
            }else{
            	result = mid;
                start = mid+1;
            }
            mid = (start+end)/2;
        }
        return result;
    }
}