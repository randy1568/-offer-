package 数据结构.面试题29顺时针打印矩阵;

import java.util.ArrayList;

public class Solution {


    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int x1Middle, y1Middle, x2Middle, y2Middle;
        x1Middle = (row % 2 == 0) ? row / 2 - 1 : row / 2;
        x2Middle = row / 2;
        y1Middle = (col % 2 == 0) ? col / 2 - 1 : col / 2;
        y2Middle = col / 2;
        for (int x1 = 0, y1 = 0, x2 = row - 1, y2 = col - 1; x1 <= x1Middle && y1 <= y1Middle && x2 >= x2Middle && y2 >= y2Middle; x1++, y1++, x2--, y2--) {
            printSubMatrix(matrix, x1, y1, x2, y2, list);
        }
        return list;
    }

    public void printSubMatrix(int[][] matrix, int x1, int y1, int x2, int y2, ArrayList<Integer> list) {
        for (int y = y1; y < y2; y++) {
            list.add(matrix[x1][y]);
        }
        for (int x = x1; x < x2; x++) {
            list.add(matrix[x][y2]);
        }
        for (int y = y2; y > y1; y--) {
            list.add(matrix[x2][y]);
            if(x1 == x2){   //处理数组为{1，2，3，4.。}的情况
                break;
            }
        }
        for (int x = x2; x > x1  ; x--) {
            list.add(matrix[x][y1]);
            if(y1 == y2){   //处理数组为{{1}，{2}，{3}，{4}，{5}}的情况
                break;
            }
        }
        if (x1 == y1 && x1 == x2 && x2 == y2) {
            list.add(matrix[x1][y1]);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] array = new int[][]{{1, 2, 3,4}, { 5, 6,7,8}, { 9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> list = solution.printMatrix(array);
        System.out.println(list);
    }
}
