/*Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward*/
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int palindrome = x;
        int reversedNumber = 0;
        while (x != 0) {
            reversedNumber = (reversedNumber * 10) + x % 10;
            x /= 10;
        }
        return reversedNumber == palindrome;
    }

}
