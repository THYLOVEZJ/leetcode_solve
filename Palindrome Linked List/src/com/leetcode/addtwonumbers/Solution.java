package com.leetcode.addtwonumbers;


import java.util.Stack;

public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode result = new ListNode(0, null);
        ListNode p = result;
        int carry = 0;
        int m = 0;
        int n = 0;
        int sum = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                m = 0;
                n = stack2.pop();
            }else if (stack2.isEmpty()) {
                n = 0;
                m = stack1.pop();
            }else if (!stack1.isEmpty() && !stack2.isEmpty()) {
                m = stack1.pop();
                n = stack2.pop();
            }

            sum = m + n + carry;
            p.next = new ListNode(sum % 10, null);
            p = p.next;
            carry = sum / 10;
        }
        if (carry != 0) {
            p.next = new ListNode(carry,null);
        }
        return reverse(result.next);
    }

    public static ListNode reverse(ListNode head){
        ListNode pre = head;
        ListNode cur = null;
        ListNode pree = null;
        while(pre!=null){
            pree = pre.next;
            pre.next = cur;
            cur = pre;
            pre = pree;
        }
        return cur;
    }
}
