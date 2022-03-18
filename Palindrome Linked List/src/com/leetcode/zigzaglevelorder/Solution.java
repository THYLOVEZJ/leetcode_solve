package com.leetcode.zigzaglevelorder;

import java.util.*;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        //根节点入队
        stack.push(root);
        while(!stack.isEmpty()){

            //根节点出队
            TreeNode node = stack.pop();
            //将根节点的左右子节点压入栈
            stack.push(node.left);
            stack.push(node.right);

        }
    }
}
