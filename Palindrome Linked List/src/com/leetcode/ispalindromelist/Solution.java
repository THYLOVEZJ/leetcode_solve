package com.leetcode.ispalindromelist;

public class Solution {
    public static boolean isPalindrome(ListNode head) {
        //先通过快慢指针找到链表的中点
        ListNode quick = head;
        ListNode slow = head;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        if (quick != null) {
            slow = slow.next;
        }
        ListNode reverse = reverse(slow);

        ListNode p1 = head;
        ListNode p2 = reverse;
        while (p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;
        ListNode pree = null;
        while (pre != null) {
            pree = pre.next;
            pre.next = cur;
            cur = pre;
            pre = pree;
        }
        return cur;
    }
}
