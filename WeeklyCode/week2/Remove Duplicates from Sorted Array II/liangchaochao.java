public class Solution {
    public static int removeDuplicates(int[] A) {
        if(A.length<1) return 0;
        int count=0;
        int toCompare=A[0];
        int waitToReplace=0;
        for(int index=0;index<A.length;index++){
            if(A[index]==toCompare){
                count++;
                if(count<=2){
                    A[waitToReplace]=A[index];
                    waitToReplace++;
                }
            }else{
                toCompare=A[index];
                count=1;
                A[waitToReplace]=A[index];
                waitToReplace++;
            }
        }
        return waitToReplace;
    }
}
