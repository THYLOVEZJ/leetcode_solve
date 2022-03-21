package com.leetcode.twosumIV;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * 输入: root = [5,3,6,2,4,null,7], k = 9
 * 输出: true
 */
public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //当队列不为空，将二叉树的左子树和右子树添加到队列里
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            //判断lists里是否存在一个值等于k-val
            if (lists.contains(k-node.val)){
                return true;
            }
            lists.add(node.val);
            if (node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }
        }
        return false;
    }
}
