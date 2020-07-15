package 数据结构.面试题38字符串的排列;

import java.util.*;

public class Solution {


    private ArrayList<String> lists = new ArrayList<>();

    /**
     * 回溯法
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return lists;
        }
        char[] array = str.toCharArray();
        StringBuilder builder = new StringBuilder();
        LinkedList<Integer> list = new LinkedList();
        Permutation(array, builder, list, array.length);
        return lists;
    }

    private void Permutation(char[] array, StringBuilder builder, LinkedList<Integer> list, int length) {
        if (builder.length() == length) {
            if(!lists.contains(builder.toString())){
                lists.add(builder.toString());
            }
            return;
        }

        for (int i = 0; i < array.length; i++) {
            if (list.contains(i)) {
                continue;
            }
            list.add(i);
            builder.append(array[i]);
            Permutation(array, builder, list, length);
            list.removeLast();
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.Permutation("aa");
        System.out.println(solution.lists);
    }
}
