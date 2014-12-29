public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length == 0)
            return 0;

        int i = 0;
        boolean flag = false;

        for (int j = i + 1; j < A.length; j++) {
            if (A[j] == A[i] && !flag) {
                flag = true;
                A[++i] = A[j];
            } else if (A[j] != A[i]) {
                A[++i] = A[j];
                flag = false;
            }
        }

        return i + 1;
    }
}