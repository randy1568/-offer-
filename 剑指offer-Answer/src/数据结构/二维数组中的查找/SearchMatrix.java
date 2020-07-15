package 数据结构.二维数组中的查找;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        final int colSize = matrix[0].length;
        final int rowSize = matrix.length;
        int col = colSize-1;
        int row = 0;

        while (row < rowSize && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                col--;
            }else {
                row++;
            }
        }
        return false;
    }
}
