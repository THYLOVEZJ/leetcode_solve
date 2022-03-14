package com.thylovezj.selectsort;

import java.util.List;

public class SelectionSort {
    private SelectionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        /**
         * 第一层循环遍历数组，i指向选择的元素
         * */
        for (int i = 0; i < arr.length - 1; i++) {
            //k用来指向[i,arr.length-1]最小元素
            int k = i;
            //第二层循环寻找[i+1,arr.length-1]最小的元素
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[k].compareTo(arr[j]) > 0) {
                    k = j;
                }
            }
            //交换arr[i]和arr[k]
            E temp = arr[k];
            arr[k] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        /**
         * 计算排序所需时间
         * */
        int[] datasize = {10000,100000};
        for (int n:datasize){
            Integer[] arr = ArrayGenerate.generateArray(n, n);
            SortingHelper.sortTest("SelectionSort",arr);
        }
    }
}
