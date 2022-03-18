package com.leetcode.levelorderbottom;

import java.util.*;

/***
 * leetcode107
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *输入：root = [3,9,20,null,null,15,7]
 * 输出：[[15,7],[9,20],[3]]
 *
 */
public class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(list);
        }
        List<List<Integer>> res = reverse(ans);
        return res;
    }

    public List<List<Integer>> reverse(List<List<Integer>> ans) {
        Stack<List<Integer>> stack = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();
        int size = ans.size();
        for (int i = 0; i < size; i++) {
            stack.add(ans.remove(0));
        }
        for (int i = 0; i < size; i++) {
            res.add(stack.pop());
        }
        return res;
    }
}
