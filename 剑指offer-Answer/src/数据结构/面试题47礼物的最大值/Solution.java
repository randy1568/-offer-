package 数据结构.面试题47礼物的最大值;

public class Solution {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[2][n];
        int old = 1;
        int New = 0;
        for (int i = 0; i < m; i++) {
            New = 1-New;
            old = 1-old;
            for (int j = 0; j < n; j++) {
                f[New][j]=grid[i][j];
                if(i > 0){
                    f[New][j]  = Math.max(f[New][j],f[old][j]+grid[i][j]);
                }
                if(j > 0){
                    f[New][j] = Math.max(f[New][j],f[New][j-1]+grid[i][j]);
                }
            }
        }
        return f[New][n-1];
    }

    public int maxValue2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[m][n];
        f[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j]=grid[i][j];
                if(i > 0){
                    f[i][j]  = Math.max(f[i][j],f[i-1][j]+grid[i][j]);
                }
                if(j > 0){
                    f[i][j] = Math.max(f[i][j],f[i][j-1]+grid[i][j]);
                }
            }
        }
        return f[m-1][n-1];
    }
}
