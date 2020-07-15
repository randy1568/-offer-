package 数据结构.面试题19正则表达式匹配;

public class Solution {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchString(str, 0, pattern, 0);
    }

    private boolean matchString(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        //patternIndex + 1 < pattern.length这里没必要加，因为前边的判断限定了这个永远成立
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && str[strIndex] == pattern[patternIndex]) ||
                    (strIndex != str.length &&  pattern[patternIndex] == '.')) {
                //这里第一个情况是str到尾了，而pattern还没有
                return matchString(str, strIndex, pattern, patternIndex + 2) ||
                        matchString(str, strIndex + 1, pattern, patternIndex) ||
                        matchString(str, strIndex + 1, pattern, patternIndex + 2);
            } else {
                return matchString(str, strIndex, pattern, patternIndex + 2);
            }
        }
        if (strIndex != str.length) {
            if (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.') {
                return matchString(str, strIndex + 1, pattern, patternIndex + 1);
            }
        }
        //str到尾了，而pattern还没有，如果pattern最后一个字符不是*，那么就会匹配不成功
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean match = solution.match(new char[]{'a'}, new char[]{'.','*'});
        System.out.println(match);
    }
}
