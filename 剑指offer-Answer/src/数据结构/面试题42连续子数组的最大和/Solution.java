package 数据结构.面试题42连续子数组的最大和;

public class Solution {
    /**
     * f[i]代表以ai结尾的连续子数组的最大和
     * 状态转移方程 ：f[i] = max(f[i],f[i-1]+array[i])
     * 初始条件：f[0] = array[0]
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null) {
            return 0;
        }
        int[] f = new int[array.length];
        f[0] = array[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; i++) {
            f[i] = array[i];
            f[i] = Math.max(f[i],f[i-1]+array[i]);
            res = Math.max(res,f[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "abcdefg";
        for (int i = 0;i<str.length();i++){
            for (int j = i+1;j<=str.length();j++){
                System.out.println(str.substring(i,j));
            }
        }
    }
}
