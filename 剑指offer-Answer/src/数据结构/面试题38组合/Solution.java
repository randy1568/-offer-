package 数据结构.面试题38组合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 力扣 77
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Solution {

    private List<List<Integer>> lists = new ArrayList<>();

    /**
     * 回溯法
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> listNum = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            listNum.add(i);
        }
        LinkedList<Integer> list = new LinkedList<>();
        combine(listNum, k, listNum.size(), list);
        return lists;
    }


    private void combine(LinkedList<Integer> listNum, int k, int size, LinkedList list) {
        if (size < k) {
            return;
        }
        if (k == 0) {
            lists.add(new ArrayList<>(list));
            return;

        }
        list.add(listNum.getFirst());
        int firstValue = listNum.removeFirst();
        //选当前这个数
        combine(listNum, k - 1, listNum.size(), list);
        //不选当前这个数
        list.remove(Integer.valueOf(firstValue));
        combine(listNum, k, listNum.size(), list);
        listNum.addFirst(firstValue);
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        so.combine(4, 2);
        for (List<Integer> list : so.lists) {
            System.out.println(list);
        }
    }
}
