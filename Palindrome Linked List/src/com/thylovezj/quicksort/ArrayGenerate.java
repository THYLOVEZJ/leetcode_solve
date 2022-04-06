package com.thylovezj.quicksort;

import java.util.Random;

public class ArrayGenerate {
    /**
     * 私有化构造方法，使其不能实例化该对象
     */
    private ArrayGenerate() {
    }

    ;

    /**
     * 创建一个随机数组
     */
    public static Integer[] generateArray(int n, int bound) {
        Integer[] arr = new Integer[n];
        Random rdm = new Random();
        for (int i = 0; i < n; i++) {
            //生成的随机数在区间[0,bound)里
            arr[i] = rdm.nextInt(bound);
        }
        return arr;
    }
}
