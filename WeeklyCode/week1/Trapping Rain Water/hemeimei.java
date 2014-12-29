public class Solution {
    public int trap(int[] A) {
        if(A == null || A.length < 3) return 0;
        int rainCount = 0;
        int left=A[0], right=A[A.length-1], i=1, j=A.length-2;
        while(i <= j){
            if(left < right){
                if(A[i] <= left){
                    rainCount += left - A[i]; 
                }else{
                    left = A[i];
                }
                i++;
            }else{
                if(A[j] <= right){
                    rainCount += right - A[j];
                }else{
                    right = A[j];
                }
                j--;
            }
        }
        return rainCount;
    }
}