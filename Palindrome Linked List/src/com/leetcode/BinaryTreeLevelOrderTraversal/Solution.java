package com.leetcode.BinaryTreeLevelOrderTraversal;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //定义一个结果返回
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //头节点进入队列
        queue.add(root);
        //当队列不为空时，将结果添加至
        while(!queue.isEmpty()){
            //新建一个列表，存储每一层的数据
            List<Integer> list = new ArrayList<Integer>();
            int count = queue.size();
            for (int i = 0;i<count;i++){
                TreeNode node = queue.remove();
                list.add(node.val);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
