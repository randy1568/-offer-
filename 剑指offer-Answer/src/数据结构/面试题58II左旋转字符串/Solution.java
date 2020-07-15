package 数据结构.面试题58II左旋转字符串;

public class Solution {
    public String reverseLeftWords(String s, int n) {
        String substring = s.substring(0, n);
        String substring1 = s.substring(n);
        return substring1+substring;
    }
}
