package com.leetcode.validpalindrome;

public class Solution {
    public static boolean validPalindrome(String s) {
        for (int left = 0, right = s.length() - 1; left <= right; left++, right--) {
            if (s.charAt(left)!=s.charAt(right)){
                return isValid(s,left+1,right) || isValid(s,left,right-1);
            }
        }
        return true;
    }


    public static boolean isValid(String s,int left,int right) {
        String newString = s.toUpperCase();
        char[] charArray = newString.toCharArray();
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
