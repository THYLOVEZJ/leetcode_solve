package com.leetcode.zigzaglevelorder;

import java.util.*;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        //根节点入队
        queue.offer(root);
        //用order记录需要正序还是倒序
        boolean order = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < queue.size(); i++) {
                //根节点出队
                TreeNode node = queue.poll();
                if (order){
                    //order为true
                    list.add(node.val);
                }else{
                    stack.add(node.val);
                }
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            //每一层的值已经遍历完
            if (order){
                lists.add(list);
            }else{
                while(!stack.isEmpty()){
                    list.add(stack.pop());
                }
                lists.add(list);
            }
            //清空list
            list.clear();
        }
        return lists;
    }
}
