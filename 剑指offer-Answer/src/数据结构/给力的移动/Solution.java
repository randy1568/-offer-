package 数据结构.给力的移动;

import java.util.Scanner;

/**
 * 输入  0<=length<=100000
 * 1<=数值<=length
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int length = in.nextInt();
            int[] num = new int[length];
            //保存每个输入值其对应的下标
            int[] pIndex = new int[length + 1];
            int[] d = new int[length];
            for (int i = 0; i < length; i++) {
                num[i] = in.nextInt();
                pIndex[num[i]] = i;
            }
            int res = 0;
            for (int i = 0; i < length; i++) {
                //找到比该值小1的那个数的下标
                int k = pIndex[num[i] - 1];
                //没有比1更小的数，偌num[i] == 1，则返回的k肯定为0，这个下标0对应的num里边的数可不是0
                if (num[i] == 1 || k >= i) {
                    d[i] = 1;
                } else {
                    d[i] = d[k] + 1;
                }
                res = Math.max(res, d[i]);
            }
            System.out.println(length - res);
        }
    }
}
