public class Solution {
    public int jump(int[] A) {
        int[] minJumpNum = new int[A.length];
        if(A == null || A.length <= 1) return 0;
        int target = A.length - 1;
        int reach = 0;
        for(int i = 0; i <= reach && reach < target; i++){
            if(reach < i + A[i]){
                for(int j = reach + 1; j <= i + A[i] && j <= target; j++){
                    minJumpNum[j] = minJumpNum[i] + 1;
                }
                reach = i + A[i];
            }
        }
        return minJumpNum[target];
    }
}
