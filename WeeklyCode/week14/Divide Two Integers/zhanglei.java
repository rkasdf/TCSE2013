public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) throw new ArithmeticException("Divide zero!");
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        long p = Math.abs((long) dividend), q = Math.abs((long) divisor);
        int res = 0;

        while (p >= q) {
            int count = 0;
            long temp = q;
            for (; temp <= p; count++) temp <<= 1;
            res += 1 << (count - 1);
            p -= q << (count - 1);
        }

        return (dividend > 0 ^ divisor > 0) ? -res : res;
    }
}