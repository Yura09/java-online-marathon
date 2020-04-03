/*
Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
*/

class Solution {
    public int divide(int dividend, int divisor) {
       if (dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
       if (divisor == 1) {
            return dividend;
        }
        int sign = ((dividend < 0) ^
                (divisor < 0)) ? -1 : 1;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);


        int quotient = 0;

        while (dividend >= divisor) {
            dividend -= divisor;
            ++quotient;
        }
        return sign * quotient;
    }
}
