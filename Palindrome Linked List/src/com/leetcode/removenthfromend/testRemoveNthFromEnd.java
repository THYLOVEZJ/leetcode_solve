package com.leetcode.removenthfromend;

public class testRemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2, null);
        ListNode node2 = new ListNode(1, node1);
        ListNode node = Solution.removeNthFromEnd(node2, 2);
        while(node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
