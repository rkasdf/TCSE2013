public class Solution {
    public int trap(int[] A) {
        if (A.length == 0)
            return 0;

        int l = 0;
        int r = A.length - 1;
        int res = 0;

        while (l < r) {
            int min = Math.min(A[l], A[r]);
            if (A[l] == min) {
                l++;
                while (l < r && A[l] < min) {
                    res += min - A[l];
                    l++;
                }
            } else {
                r--;
                while (l < r && A[r] < min) {
                    res += min - A[r];
                    r--;
                }
            }
        }
        return res;
    }
}