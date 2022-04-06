package com.leetcode.NumMatrix;

public class testNumMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        Solution solution = new Solution(matrix);
        int res = solution.sumRegion(2, 1, 4, 3);
        System.out.println(res);
    }
}
