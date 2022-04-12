package com.leetcode.fib;

import java.util.HashMap;

public class Solution {
    final int mod = 1000000007;

    public int fib(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    /***
     * 利用备忘录进行剪枝操作
     * @param n
     * @return
     */
    public int fibI(int n) {
        if (n == 1 || n == 2) return 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        return help(map, n) % mod;
    }

    public int help(HashMap<Integer, Integer> map, int n) {
        if (n == 0) return 0;
        if (map.containsKey(n)) return map.get(n);

        map.put(n, help(map, n - 1) + help(map, n - 2));
        return map.get(n);
    }

    /***
     * 那么自低而上进行迭代的算法也很容易就能想到
     */
    public int fibII(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[n] = dp[n - 1] + dp[n - 2];
        }
        return dp[n];
    }

    /**
     * 但是对于上面的解法，我们的空间复杂度很高，实际上我们只需要关心前两个值的和即可
     * 下面是状态压缩后的解法
     */
    public int fibIII(int n) {
        if (n <= 1) return n;
        /**
         0 1 2 3 4
         0 1 1 2 3
         */
        int pre = 0;
        int cur = 1;
        int sum = 0;
        for (int i = 2; i < n + 1; i++) {
            sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return sum;
    }
}
