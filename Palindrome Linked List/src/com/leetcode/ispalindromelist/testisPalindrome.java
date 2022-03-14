package com.leetcode.ispalindromelist;

public class testisPalindrome {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, null);
        ListNode listNode2 = new ListNode(2, listNode1);
//        ListNode listNode3 = new ListNode(2, listNode2);
//        ListNode listNode4 = new ListNode(1, listNode3);

        boolean bool = Solution.isPalindrome(listNode2);
        System.out.println(bool);
    }
}
