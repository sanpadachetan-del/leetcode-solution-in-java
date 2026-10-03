class Solution {
    public int divide(int dividend, int divisor) {

        // Special case: overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Check whether answer should be negative
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Use long to safely handle Integer.MIN_VALUE
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        long quotient = 0;

        // Repeatedly subtract the largest possible multiple
        while (a >= b) {

            long temp = b;
            long multiple = 1;

            // Double temp using addition (no multiplication)
            while (a >= temp + temp) {
                temp = temp + temp;
                multiple = multiple + multiple;
            }

            a = a - temp;
            quotient = quotient + multiple;
        }

        if (negative) {
            quotient = -quotient;
        }

        return (int) quotient;
    }
}
