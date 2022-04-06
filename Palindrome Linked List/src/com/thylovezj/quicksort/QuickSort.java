package com.thylovezj.quicksort;

import java.util.Random;

/***
 * 该版本的快速排序法是存在问题的
 * 首先，如果对于近乎有序的数组，我们的时间复杂度会变为O(n^2)，且递归的深度会变为O(n)，因此，该版快速排序
 * 在面对近乎有序的数组时，速度会非常慢，且有可能产生栈溢出
 */
public class QuickSort {
    public QuickSort() {
    }

    public static <E extends Comparable<E>> void quickSort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) return;
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public static <E extends Comparable<E>> int partition(E[] arr, int l, int r) {
        /**
         * 该段代码即为了消除有序数组的影响
         */
        //生成[l,r]之间的随机索引
        int p = new Random().nextInt(r - l + 1);
        swap(arr, p, l);


        int i = l;
        //[l+1...i]<arr[l],[i+1...r]>=arr[l]

        for (int j = l + 1; j <= r; j++) {
            if (arr[j].compareTo(arr[l]) < 0) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, l, i);
        return i;
    }

    public static <E extends Comparable<E>> void swap(E[] arr, int l, int r) {
        E swap = arr[l];
        arr[l] = arr[r];
        arr[r] = swap;
    }

    public static void main(String[] args) {
        Integer[] arr = ArrayGenerate.generateArray(100, 100);
        SortingHelper.sortTest("quickSort", arr);
    }
}
