package com.leetcode.reorderlist;

public class testReorderList {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4, null);
        ListNode listNode2 = new ListNode(3, listNode1);
        ListNode listNode3 = new ListNode(2, listNode2);
        ListNode listNode4 = new ListNode(1, listNode3);
        ListNode head = Solution.reorderList(listNode4);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
