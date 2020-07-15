package 数据结构.面试题14剪绳子;

public class Solution {

    /**
     * 动态规划
     *
     * @param target
     * @return
     */
    public static int cutRope(int target) {
        if (target == 2) {
            return 1;
        }
        int[] f = new int[target + 1];
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= target; i++) {
            f[i] = i - 1;
            for (int j = 1; j < i; j++) {
                f[i] = Math.max(f[i], f[j] * (i - j));
            }
        }
        return f[target];
    }

    public static void main(String[] args) {
        System.out.println(cutRope(5));
    }
}
