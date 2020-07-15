package 数据结构.面试题38组合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 力扣 77
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Solution2 {

    private List<List<Integer>> lists = new ArrayList<>();
    private int k = 0;
    private int n = 0;

    /**
     * 回溯法
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        this.k = k;
        this.n = n;
        backTrack(1,list);
        return lists;
    }


    private void backTrack(int num, LinkedList list) {
       if(list.size() == k){
           lists.add(new ArrayList<>(list));
           return;
       }

       for (int i = num;i<=n;i++){
           //选当前这个数
           list.add(i);
           backTrack(i+1,list);
           //不选当前这个数
           list.removeLast();
       }
    }

    public static void main(String[] args) {
        Solution2 so = new Solution2();
        so.combine(4, 2);
        for (List<Integer> list : so.lists) {
            System.out.println(list);
        }
    }
}
