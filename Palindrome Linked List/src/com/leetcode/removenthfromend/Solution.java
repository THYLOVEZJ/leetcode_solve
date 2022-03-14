package com.leetcode.removenthfromend;

public class Solution {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        ListNode right = head;
        ListNode left = head;
        for (int p1 = 0; p1 < n; p1++) {
            //
            right = right.next;
        }
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        if (left.next.next != null) {
            left.next = left.next.next;
        } else {
            left.next = null;
        }
        if (head == null) {
            return left;
        } else {
            return head;
        }
    }
}
