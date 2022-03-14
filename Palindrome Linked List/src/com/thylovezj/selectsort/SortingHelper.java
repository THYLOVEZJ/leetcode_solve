package com.thylovezj.selectsort;

public class SortingHelper {
    private SortingHelper(){};

    /**
     * 该方法用来判断数组是否有序
     * */
    public static <E extends Comparable<E>> boolean isSorted(E[] arr){
        for (int i = 1 ; i < arr.length; i++){
            if (arr[i-1].compareTo(arr[i])>0)
                return false;
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortname,E[] arr){
        long start = System.nanoTime();
        if (sortname.equals("SelectionSort"))
            SelectionSort.sort(arr);
        else if (sortname.equals("InsertSort"))
            InsertSort.sort(arr);
        else if (sortname.equals("InsertSortI"))
            InsertSort.sortI(arr);
        long end = System.nanoTime();
        double time = (end-start)/1000000000.0;

        if (!SortingHelper.isSorted(arr))
            throw new RuntimeException("Selection Sort Failed");
        System.out.println(String.format("%s, n = %d : %f:",sortname,arr.length,time));
    }
}
