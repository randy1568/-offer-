package 数据结构.面试题58I翻转单词顺序;

public class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split("\\s+");
        int left = 0;
        int right = strs.length - 1;
        while (left < right) {
            String temp = strs[left];
            strs[left] = strs[right];
            strs[right] = temp;
            left++;
            right--;
        }
        String res = "";

        for (String str : strs) {
            res += str + " ";
        }
        return res.trim();
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        so.reverseWords("a good   example");
    }
}
