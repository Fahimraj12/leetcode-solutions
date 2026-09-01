class Solution {
    public int divide(int dividend, int divisor) {

        // Overflow case:
        // -2147483648 / -1 = 2147483648
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Use long to safely handle Integer.MIN_VALUE
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int quotient = 0;

        // Find the quotient using powers of 2
        for (int i = 31; i >= 0; i--) {

            if ((b << i) <= a) {
                a -= (b << i);
                quotient += (1 << i);
            }
        }

        // Determine the sign
        if ((dividend < 0) ^ (divisor < 0)) {
            quotient = -quotient;
        }

        return quotient;
    }
}