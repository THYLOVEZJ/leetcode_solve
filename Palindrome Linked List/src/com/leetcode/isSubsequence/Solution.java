package com.leetcode.isSubsequence;

public class Solution {
    public boolean isSubsequence(String s, String t) {

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        if(sArr.length==0)return true;
        int p1 = 0;
        for (int i = 0; i < tArr.length; i++) {
            if (tArr[i]==sArr[p1]){
                p1++;
                if (p1==sArr.length)return true;
            }
        }
        return false;
    }
}
