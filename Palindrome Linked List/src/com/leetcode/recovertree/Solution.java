package com.leetcode.recovertree;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        inOrder(root, list);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).val>list.get(i+1).val&&res.size()==0)
                res.add(i);
            if (list.get(i).val>list.get(i+1).val&&res.size()==1)
                res.add(i+1);
        }
        TreeNode node1 = list.get(res.get(0));
        TreeNode node2 = list.get(res.get(1));
        int swap = 0;
        swap = node1.val;
        node1.val = node2.val;
        node2.val = swap;
    }

    public void inOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }
}
