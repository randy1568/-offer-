package 数据结构.替换空格;

public class ReplaceSpace {
    public static String replaceSpace(StringBuffer str1) {
        char[] s = str1.toString().toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0;i<s.length;i++){
            if (s[i] == ' '){
                builder.append("%20");
                continue;
            }
            builder.append(s[i]);
        }
        return builder.toString();
    }
}
