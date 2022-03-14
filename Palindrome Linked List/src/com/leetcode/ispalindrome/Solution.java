package com.leetcode.ispalindrome;

public class Solution {
    public static boolean isPalindrome(String s) {
        String newString = s.toUpperCase();
        char[] charArray = newString.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left != right) {
            while ((!Character.isLetterOrDigit(charArray[left])) || (!Character.isLetterOrDigit(charArray[right]))) {

                if (!Character.isLetterOrDigit(charArray[left])) {
                    left++;
                }
                if (!Character.isLetterOrDigit(charArray[right])){
                    right--;
                }
                if (left==right||right<left)return true;
            }
            if (charArray[left]!=charArray[right])return false;
            left++;
            right--;
            if (left>right)return true;
        }
        return true;
    }
}
