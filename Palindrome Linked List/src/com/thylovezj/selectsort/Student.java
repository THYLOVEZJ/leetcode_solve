package com.thylovezj.selectsort;

public class Student implements Comparable<Student>{
    private int score;
    private String name;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student() {
    }

    public Student(int score, String name) {
        this.score = score;
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        return this.score-o.score;
    }

    @Override
    public String toString() {
        return String.format("name: %s,score: %d",name,score);
    }
}
