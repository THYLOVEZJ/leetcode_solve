package com.leetcode.treetodoublelist;

import java.util.LinkedList;

public class Solution {
    public static Node treeToDoublyList(Node root) {
        //题目中给出了将一个二叉搜索树转换为一个排序的双向链表，排序意味着中序遍历
        LinkedList<Node> lists = new LinkedList<>();
        LinkedList<Node> list = inOrder(root, lists);
        Node first = list.get(0);
        Node last = list.get(list.size() - 1);
        first.left = last;
        last.right = first;
        for (int i = 0; i < list.size() - 1; i++) {
            Node pre = list.get(i);
            Node cur = list.get(i + 1);
            pre.right = cur;
            cur.left = pre;
        }
        return first;
    }

    public static LinkedList<Node> inOrder(Node root, LinkedList<Node> list) {
        //递归终止条件
        if (root == null) return null;
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
        return list;
    }
}
