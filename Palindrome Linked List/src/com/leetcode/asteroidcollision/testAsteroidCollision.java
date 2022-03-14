package com.leetcode.asteroidcollision;

public class testAsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = new int[]{5,10,-5};
        int[] res = Solution.asteroidCollision(asteroids);
        for (int i:res){
            System.out.println(i);
        }
    }
}
