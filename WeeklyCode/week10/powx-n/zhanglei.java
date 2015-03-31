public class Solution {
    public double pow(double x, int n) {
        if (n == 0) return 1;
        if (n == Integer.MIN_VALUE) return 1 / pow(x, 0);
        if (n < 0) return 1 / pow(x, -n);
        return ((n & 1) == 1) ? pow(x * x, n >> 1) * x : pow(x * x, n >> 1);
    }
}