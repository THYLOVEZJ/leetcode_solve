package com.thylovezj.selectsort;

public class InsertSort {
    private InsertSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0)
                    swap(arr, j, j - 1);
            }
        }
    }

    public static <E extends Comparable<E>> void sortI(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            E temp = arr[i];
            for (int j = i; j > 0; j--) {
                if (temp.compareTo(arr[j - 1]) < 0)
                    arr[j] = arr[j-1];
                else arr[j] = temp;
            }
        }
    }


    public static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] datasize = {10000, 100000};
        for (int n : datasize) {
            Integer[] arr = ArrayGenerate.generateArray(n, n);
            SortingHelper.sortTest("InsertSort", arr);
        }
    }
}
