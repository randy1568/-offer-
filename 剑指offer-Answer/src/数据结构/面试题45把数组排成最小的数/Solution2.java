package 数据结构.面试题45把数组排成最小的数;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 列出所有可能的组合，找到组合中数值最小的那个组合，回溯法
 */
public class Solution2 {

    private ArrayList<String> lists = new ArrayList<>();

    public String PrintMinNumber(int[] numbers) {
        if (numbers == null) {
            return null;
        }
        String[] strs = new String[numbers.length];
        LinkedList<Integer> list = new LinkedList<>();
        PrintMinNumber(numbers,list);
        Collections.sort(lists);
        return lists.get(0);
    }

    private void PrintMinNumber(int[] numbers,  LinkedList<Integer> list) {
        if (list.size() == numbers.length) {
            String s = "";
            for (Integer temp:list){
                s+=temp;
            }
            lists.add(s);
            return;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (list.contains(numbers[i])) {
                continue;
            }
            list.add(numbers[i]);
            PrintMinNumber(numbers,list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        solution.PrintMinNumber(new int[]{3,32,321});
    }


}
