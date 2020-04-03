/*
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
*/
class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int start = 1, end = x, result = 0;
        while (start <= end) {
            int middle = (start + end) / 2;


            if (middle * middle == x)
                return middle;

            if (middle * middle < x) {
                start = middle + 1;
                result = middle;
            } else
                end = middle - 1;
        }
        return result;
    }
}
