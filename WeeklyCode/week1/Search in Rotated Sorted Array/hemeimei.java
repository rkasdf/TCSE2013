public class Solution {
    public int search(int[] A, int target) {
        int low=0,high=A.length-1,mid;
        while(low <= high){
            mid = (low+high)/2;
            if(target == A[mid]){
                return mid;
            }
            
            if(A[low] <= A[mid]){
                if(target < A[mid] && target >= A[low]){
                	high = mid-1;
                }else{
                	low = mid+1;
                }
            }else{
                if(target > A[mid] && target <= A[high]){
                    low = mid +1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}