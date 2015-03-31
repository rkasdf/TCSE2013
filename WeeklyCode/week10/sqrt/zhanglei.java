public class Solution {
    public int sqrt(int x) {
        if (x <= 0) return 0;
        int low = 1, high = x / 2 + 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            int value = x / mid;
            if (value == mid) return mid;
            else if (value < mid) high = mid - 1;
            else low = mid + 1;
        }

        return high;
    }
}