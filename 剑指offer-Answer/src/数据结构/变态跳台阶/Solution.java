package 数据结构.变态跳台阶;

/**
 * 状态转移方程 f[n] = f[i]求和 (其中 0< i < n)
 */
public class Solution {
    public static int JumpFloorII(int target) {
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 1; i <= target; i++) {
            f[i] = 0;
            for (int j = 0; j < i; j++) {
                if (i - j >= 1) {
                    f[i] += f[j];
                }
            }
        }
        return f[target];
    }

    public static void main(String[] args) {
        System.out.println(JumpFloorII(2));
    }
}
