package 数据结构.面试题48最长不含重复字符的子字符串;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int maxLength = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                char temp = s.charAt(j);
                if (!s.substring(i, j).contains(temp + "")) {
                    maxLength = maxLength > (j - i + 1) ? maxLength : j - i + 1;
                } else {
                    break;
                }
            }
        }
        return maxLength;
    }

    /**
     * f[s.length][26]
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int maxLength = 1;
        char[] A = s.toCharArray();
        int[][] f = new int[A.length + 1][26];
        f[0][A[0] - 'a'] = 1;
        for (int i = 1; i < A.length; i++) {
            int tempCount = 0;
            if (f[i - 1][A[i] - 'a'] == 1) {
                for (int k = A[i] - 'a'; k < 26; k++) {
                    f[i][k] = f[i - 1][k];
                    if (f[i][k] == 1) {
                        tempCount++;
                    }
                }
            } else {
                for (int j = 0; j < 26; j++) {
                    f[i][j] = f[i - 1][j];
                    if (f[i][j] == 1) {
                        tempCount++;
                    }
                }
                f[i][A[i] - 'a'] = 1;
                tempCount++;
            }
            if (maxLength < tempCount) {
                maxLength = tempCount;
            }
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring3(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int[] position = new int[26];
        for (int i = 0;i<26;i++){
            position[i] = -1;
        }
        int maxLength = 0;
        int curLength = 0;
        for (int i = 0;i<s.length();i++){
            int preIndex = position[s.charAt(i)-'a'];
            if(preIndex == -1 || i-preIndex>curLength){
                curLength++;
            }else {
                curLength = i-position[i];
            }
            position[s.charAt(i)-'a'] = i;
            if(curLength > maxLength){
                maxLength = curLength;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.lengthOfLongestSubstring2("abcdeabc"));
    }
}
