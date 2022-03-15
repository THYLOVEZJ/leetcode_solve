package com.leetcode.sumnumbers;


import java.util.ArrayList;
import java.util.List;

/***
 * 给定一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 *
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3Etpl5
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    public int sum(TreeNode root, int res) {
        if (root == null) return 0;
        res = res * 10 + root.val;
        if (root.left == null && root.right == null) {
            return res;
        } else {
            return sum(root.left, res) + sum(root.right, res);
        }
    }

    List<String> list = new ArrayList<>();


    public int sumNumbersI(TreeNode root) {

        int res = 0;
        dfs(root,"");
        for (String s : list) {
            res = res + Integer.valueOf(s);
        }
        return res;
    }

    public void dfs(TreeNode node,String bs) {
        if (node == null) return;
        bs = bs+node.val;
        if (node.left == null && node.right == null) {
            list.add(bs.toString());
        }
        dfs(node.left,bs);
        dfs(node.right,bs);
    }
}
