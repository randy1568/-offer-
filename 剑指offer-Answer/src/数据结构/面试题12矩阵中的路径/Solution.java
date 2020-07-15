package 数据结构.面试题12矩阵中的路径;

public class Solution {

    private boolean flag = false;
    private int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        boolean[] marked = new boolean[matrix.length];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                boolean path = findPath(marked, matrix, rows, cols, row, col, 0, str);
                if (path) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findPath(boolean[] marked, char[] matrix, int rows, int cols, int row, int col, int pLength, char[] str) {
        if (pLength == str.length) {
            return true;
        }
        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols &&  marked[row * cols + col] !=true && str[pLength] == matrix[row * cols + col]) {
            pLength++;
            marked[row * cols + col] = true;
            hasPath = findPath(marked, matrix, rows, cols, row, col - 1, pLength, str) ||
                    findPath(marked, matrix, rows, cols, row, col + 1, pLength, str) ||
                    findPath(marked, matrix, rows, cols, row - 1, col, pLength, str) ||
                    findPath(marked, matrix, rows, cols, row + 1, col, pLength, str);
            if(!hasPath){
                pLength--;
                marked[row * cols + col] = false;
            }
        }
        return hasPath;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
//        ABCESFCSADEE
        boolean b = solution.hasPath(new char[]{'A', 'B', 'C', 'E', 'S', 'F', 'C', 'S', 'A', 'D', 'E', 'E'}, 3, 4, new char[]{'A', 'B', 'C', 'C', 'E', 'D'});
        System.out.println(b);
    }
}
