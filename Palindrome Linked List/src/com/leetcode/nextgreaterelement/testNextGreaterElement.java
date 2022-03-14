package com.leetcode.nextgreaterelement;

public class testNextGreaterElement {
    public static void main(String[] args) {
        int[] res = Solution.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2});
        for (int i:res){
            System.out.println(i);
        }
    }
}
