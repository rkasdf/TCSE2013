public class Solution {
    public int removeDuplicates(int[] A) {
        if(A == null || A.length <1) return 0;
        int length = A.length;
        int currNum = A[0], currCount = 1, currOffset=0;
        for(int i=1;i<length;i++){
            if(A[i] == currNum){
                if(currCount == 2){
                    currOffset++;
                }else{
                    currCount++;
                }
            }else{
                currNum = A[i];
                currCount=1;
            }
            A[i-currOffset] = A[i];
        }
        return length-currOffset;
    }
}