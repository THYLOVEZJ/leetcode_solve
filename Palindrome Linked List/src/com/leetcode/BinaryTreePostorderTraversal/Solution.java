package com.leetcode.BinaryTreePostorderTraversal;

import java.util.List;
import java.util.ArrayList;

public class Solution {
    List<Integer> ans = new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        traverse(root);
        return ans;
    }

    public void traverse(TreeNode root){
        if(root==null)return;
        //前序遍历
        ans.add(root.val);
        traverse(root.left);
        //中序遍历
//        ans.add(root.val);
        traverse(root.right);
        //后序遍历
//        ans.add(root.val);
    }
}
