package com.thylovezj.array;

public class Main {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>(10);
        for (int i = 0; i < 10; i++)
            arr.addLast(i);
        System.out.println(arr);
        arr.addFirst(100);
        System.out.println(arr);

        arr.remove(0);
        System.out.println(arr);

//        boolean bool = arr.contains(8);
//        System.out.println(bool);

//        Array<Student> stu_arr = new Array<>();
//        stu_arr.addLast(new Student(60,"Alice"));
//        stu_arr.addLast(new Student(70,"Tom"));
//        stu_arr.addLast(new Student(90,"Cream"));
//        System.out.println(stu_arr);
//        stu_arr.remove(0);
//        System.out.println(stu_arr);
    }
}
