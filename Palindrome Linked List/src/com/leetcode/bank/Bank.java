package com.leetcode.bank;

public class Bank {
    private long[] balance;

    public Bank(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        //如果account的账户小于0或者大于n，直接返回false
        if (balance.length  < account1 || account1 < 0 || account2 < 0 || account2 > balance.length ) {
            return false;
        }
        //如果account1账户余额不够的话，直接返回false
        if (balance[account1 - 1] < money) {
            return false;
        }

        //转账
        balance[account1 - 1] = balance[account1 - 1] - money;
        balance[account2 - 1] = balance[account2 - 1] + money;

        return true;
    }

    public boolean deposit(int account, long money) {
        if (balance.length  < account || account < 0) {
            return false;
        }
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (balance.length < account || account < 0) {
            return false;
        }
        if (balance[account-1] - money < 0) {
            return false;
        }
        balance[account - 1] -= money;
        return true;
    }
}
