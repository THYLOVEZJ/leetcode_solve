package com.thylovezj.linearsearch;

public class LinearSearch {
    /**
     * 阻止用户创建该类的实例
     * */
    private LinearSearch(){}

    /**
     * 声明其为static方法
     * */

    public static <E> int Search(E[] data, E target) {
        for (int i = 0; i < data.length; i++)
            if (data[i].equals(target))
                return i;
        return -1;
    }

    public static void main(String[] args) {
        /**
         * java语言不能将一个基本类型的数组自动的转换为包装类
         * */
        Integer[] data = new Integer[]{24,18,12,9,16,66,32,4};

        int res = LinearSearch.Search(data, 16);
        System.out.println(res);

        int res2 = LinearSearch.Search(data, 1);
        System.out.println(res2);

        Student[] students = new Student[]{new Student("Alice"),
        new Student("Tom"),new Student("Jack")};

        Student stu = new Student("tom");
        int res3 = LinearSearch.Search(students, stu);
        System.out.println(res3);
    }
}
