public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] result = {-1, -1};
        int low = 0, high = A.length - 1, mid;
        while(low <= high) {
            mid = (low + high) >> 1;
            if(A[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        if(low < A.length && A[low] == target)  result[0] = low;
        else    return result;

        high = A.length - 1;
        while(low <= high) {
            mid = (low + high) >> 1;
            if(A[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        result[1] = high;
        return result;
    }
}