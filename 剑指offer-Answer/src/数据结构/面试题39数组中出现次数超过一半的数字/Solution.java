package 数据结构.面试题39数组中出现次数超过一半的数字;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {

    public int MoreThanHalfNum_Solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.replace(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        Set<Integer> keys = map.keySet();
        for (Integer key:keys){
            if(map.get(key) > (array.length)/2){
                return key;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.MoreThanHalfNum_Solution(new int[]{1,2,3,2,2,2,5,4,2});
    }
}
