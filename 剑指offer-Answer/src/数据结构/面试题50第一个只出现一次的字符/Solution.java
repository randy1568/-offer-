package 数据结构.面试题50第一个只出现一次的字符;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public int FirstNotRepeatingChar(String str) {

        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if(!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),1);
            }else {
                map.replace(str.charAt(i),map.get(str.charAt(i))+1);
            }
        }
        for (int i = 0;i<str.length();i++){
            if(map.get(str.charAt(i))==1){
                return str.indexOf(str.charAt(i));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int google = so.FirstNotRepeatingChar("google");
//        System.out.println("goodle".indexOf('l'));
        System.out.println(google);
    }
}
