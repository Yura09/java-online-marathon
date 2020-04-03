//Given a 32-bit signed integer, reverse digits of an integer.
class Solution {
     public int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            if (reversed > Integer.MAX_VALUE / 10)
                return 0;
            if (reversed < Integer.MIN_VALUE / 10)
                return 0;
            reversed = reversed * 10 + digit;
        }
        return reversed;
    }
}
