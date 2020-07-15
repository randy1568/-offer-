package 数据结构.面试题60n个骰子的点数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Semaphore;

public class Solution {

    public double[] twoSum(int n) {

        int[][] dp = new int[n][6*n+1];

        for (int i = 1; i <= 6; ++i) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= 6*n; j++) {
                for (int num = 1; num <= 6; num++) {
                    if (j - num >= 0) {
                        dp[i][j] += dp[i - 1][j - num];
                    }
                }
            }
        }


        ArrayList<Double> list = new ArrayList<>();
        int count = 0;
        for (int i = n; i < 6 * n + 1; i++) {
            if(dp[n-1][i]>0){
                count+=dp[n-1][i];
            }
        }

        for (int i = n; i < 6 * n + 1; i++) {
            if(dp[n-1][i]>0){
                list.add((double)dp[n-1][i]/count);
            }
        }
        double[] res = new double[list.size()];
        int k = 0;
        for (double temp:list){
            res[k++] = temp;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        double[] doubles = so.twoSum(2);
        System.out.println(Arrays.toString(doubles));
    }
}
