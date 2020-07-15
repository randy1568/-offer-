package 数据结构.面试题46把数字翻译成字符串;

/**
 * 状态转移方程 f[i] = f[i-1]+f[i-2]
 * f[i]:以第i位数字结尾的数字串，有多少翻译方法
 */
public class Solution {

    public int translateNum(int num) {
        String s = String.valueOf(num);
        int length = s.length();
        char[] array = s.toCharArray();
        int[] f = new int[length + 1];
        f[0] = 1;
        for (int i = 1; i <= length; i++) {
            f[i] = f[i - 1];
            if (i - 2 >= 0 && array[i - 2] - '0' <= 2 && array[i - 2] - '0' > 0 &&
                    Integer.parseInt(array[i - 2] + "" + array[i - 1]) <= 25) {
                f[i] += f[i - 2];
            }
        }
        return f[length];
    }

    /**
     * 滚动数组优化空间复杂度
     * @param num
     * @return
     */
    public int translateNum2(int num) {
        String s = String.valueOf(num);
        int length = s.length();
        int old = 0;
        int New = 1;
        for (int i = 1; i <= length; i++) {
            int temp = New;
            if (i - 2 >= 0 && s.charAt(i-2) - '0' <= 2 && s.charAt(i-2) - '0' > 0 &&
                    Integer.parseInt(s.charAt(i-2) + "" + s.charAt(i-1)) <= 25) {
                temp += old;
            }
            old = New;
            New = temp;
        }
        return New;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int i = so.translateNum(12258);
        System.out.println(i);
    }
}
