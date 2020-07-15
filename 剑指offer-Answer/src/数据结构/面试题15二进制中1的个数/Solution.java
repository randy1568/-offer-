package 数据结构.面试题15二进制中1的个数;

public class Solution {
    public int NumberOf1(int n) {

        int countNum = 0;
        String s = Integer.toBinaryString(n);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                countNum++;
            }
        }
        return countNum;
    }

    public static int NumberOf2(int n) {
        int countNum = 0;
        if (n < 0) {
            n = n ^ 0x7FFFFFFF + 1 ;
            countNum++;
        }

        for (int i = 0; i < 32; i++) {
            int k = 1 << i;
            int res = n & k;
            if (((n & k) > 0)) {
                countNum++;
            }
        }
        return countNum;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf2(-1));
    }
}
