public class Solution {
    public int removeDuplicates(int[] A) {
        if(A == null){
            return 0;
        }
        int n = A.length;
        if(n < 3){
            return n;
        }
        int pos = 2;
        for(int i=2; i<n; i++){
            if(A[i]!=A[pos-1] || A[i]!=A[pos-2]){
                A[pos++] = A[i];
            }
        }
        return pos;
    }
}
