package com.leetcode.connectII;

import com.thylovezj.queue.Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/***
 * 这题跟leetcode161不同的点在于
 * 该二叉树不是完全二叉树
 * 因此使用递归不是很方便，那么采用BFS应该是一种很好的方法
 */
public class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                //判断是否为该层最后一个元素，如果为该层最后一个元素，那么我们就不改变其next
                if (i != size - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
