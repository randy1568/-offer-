package 数据结构.面试题49丑数;

import java.util.HashMap;
import java.util.Map;

/**
 * 还是超时
 */
public class Solution2 {


    public int nthUglyNumber(int N) {

        int count = 1;
        Map<Integer, Boolean> map = new HashMap<>();
        map.put(1, true);
        int i = 2;
        while (count < N) {
            boolean temp = false;
            if(i % 2 == 0){
                temp = temp | map.getOrDefault(i / 2, false);
            }
            if(i % 3 == 0){
                temp = temp | map.getOrDefault(i / 3, false);
            }
            if(i % 5 == 0){
                temp = temp | map.getOrDefault(i / 5, false);
            }
            if (temp) {
                count++;
            }
            if (count == N) {
                return i;
            }
            map.put(i, temp);
            i++;
        }
        return 1;
    }


    public static void main(String[] args) {
        Solution2 so = new Solution2();
        int i = so.nthUglyNumber(213);
        System.out.println(i);
    }
}
