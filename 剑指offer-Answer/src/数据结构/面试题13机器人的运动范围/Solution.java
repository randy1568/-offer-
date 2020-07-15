package 数据结构.面试题13机器人的运动范围;

public class Solution {
    private int countNum = 0;

    int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int movingCount(int threshold, int rows, int cols) {

        if (rows < 1 || cols < 1) {
            return 0;
        }

        boolean[][] marked = new boolean[rows][cols];
        movingCountCore(threshold, marked, rows, cols, 0, 0);
        return countNum;
    }

    private void movingCountCore(int threshold, boolean[][] marked, int rows, int cols, int row, int col) {

        if (row >= 0 && row < rows && col >= 0 && col < cols && !marked[row][col] && doesFit(threshold, row, col)) {
            countNum++;
            marked[row][col] = true;
            for (int[] direction : directions) {
                int nrow = row + direction[0];
                int ncol = col + direction[1];
                movingCountCore(threshold, marked, rows, cols, nrow, ncol);
            }
        }
    }

    private boolean doesFit(int threshold, int row, int col) {
        int sum = 0;
        while (row != 0) {
            sum += row % 10;
            row /= 10;
        }
        while (col != 0) {
            sum += col % 10;
            col /= 10;
        }
        return sum <= threshold;
    }


}
