package com.leetcode.issymmetric;

import java.util.*;

/***
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * 思路，采用广度优先遍历，判断每一层是否为回文数？
 *
 * 这种思路存在一定问题，就是如果两棵树的结构不同，那么我们应该如何处理，比如这种测试用例[1,2,2,null,3,null,3]
 */

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
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
            //判断该list是否为回文串,并清空字符串
            if (!symmetric(list)) {
                return false;
            }
            list.clear();
        }
        return true;
    }

    public boolean symmetric(List<Integer> list) {
        int slow = 0;
        int fast = list.size() - 1;
        if (list.size() % 2 == 1 && list.size() != 1) {
            return false;
        }
        while (slow < fast) {
            if (list.get(slow) != list.get(fast)) {
                return false;
            }
            slow++;
            fast--;
        }
        return true;
    }


    public boolean isSymmetricI(TreeNode root){
        return check(root,root);
    }

    public boolean check(TreeNode p,TreeNode q){
        //递归终止条件
        if (p==null&&q==null){
            return true;
        }
        if (p!=null&&q==null||p==null&&q!=null){
            return false;
        }

        return p.val==q.val&&check(p.left,q.right)&&check(p.right,q.left);
    }
}
