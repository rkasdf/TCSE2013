public class Solution {
    public int jump(int[] A) {
        if(A==null || A.length==0) return 0;
        int[] minLen = new int[A.length];
        int maxIndex = A.length-1;
        for(int i=0;i<=maxIndex;i++){
            int j = A[i]+i>maxIndex?maxIndex-i:A[i];
            for(;j>0;j--){
                int newIndex = i+j;
                if(newIndex == maxIndex) return minLen[i]+1;
                if(minLen[newIndex]==0){
                    minLen[newIndex] = minLen[i]+1;
                }else{
                    break;
                }
            }
        }
        return minLen[maxIndex];
    }
}