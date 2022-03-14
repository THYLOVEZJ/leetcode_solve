package com.leetcode.insert;

public class testInsert {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(3, node1);
        node1.next = node2;
        Node res = Solution.insert(node1, 2);

    }
}
