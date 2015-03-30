public class Solution {
    public int[] searchRange(int[] A, int target) {
        int start = 0, end = A.length-1, mid = (start+end)/2;
        int[] result = {-1,-1};
        while(start<=end){
            if(A[mid]<target) start = mid+1;
            else end = mid-1;
            mid = (start+end)/2;
        }
        if(start<A.length && A[start] == target) result[0] = start;
        end = A.length-1;
        while(start<=end){
            mid = (start+end)/2;
            if(A[mid]>target) end = mid-1;
            else start = mid+1;
        }
        if(end > -1 && A[end] == target) result[1] = end;
        return result;
    }
}