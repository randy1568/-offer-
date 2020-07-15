package 数据结构.面试题45把数组排成最小的数;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 基于一种新的排序规则
 */
public class Solution {
    public String PrintMinNumber(int[] numbers) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = o1+""+o2;
                String str2 = o2+""+o1;
                return str1.compareTo(str2);
            }
        });
        String s = "";
        for (Integer temp:list){
            s+=temp;
        }
        return s;
    }



}
