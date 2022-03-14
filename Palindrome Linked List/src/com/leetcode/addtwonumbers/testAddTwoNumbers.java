package com.leetcode.addtwonumbers;

public class testAddTwoNumbers {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(0, null);



        ListNode listNode5 = new ListNode(3, null);
        ListNode listNode6 = new ListNode(7, listNode5);


        ListNode listNode = Solution.addTwoNumbers(listNode1, listNode6);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
