package com.leetcode.trailingZeroes;

public class Solution {
    /***
     * 这种思路为计算n的阶乘，但是阶乘太大了很难计算，放弃
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int res = cal(n);
        return calo(res);
    }

    public int cal(int n) {
        if (n == 1) return 1;
        int res = cal(n - 1) * n;
        return res;
    }

    public int calo(int n) {
        int res = 0;
        while (n % 10 == 0) {
            n = n / 10;
            res++;
        }
        return res;
    }

    /***
     *
     */
    public int trailingZeroesI(int n) {
        int res = 0;
        for (int i = 5; i <= n; i++) {
            int x = i;
            while (x % 5 == 0) {
                x = x / 5;
                res++;
            }
        }
        return res;
    }
}
