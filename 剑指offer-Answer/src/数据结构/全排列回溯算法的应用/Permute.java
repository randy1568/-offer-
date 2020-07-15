package 数据结构.全排列回溯算法的应用;

import java.util.LinkedList;
import java.util.List;

public class Permute {

    private List<List<Integer>> lists = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {

        LinkedList<Integer> list = new LinkedList<>();
        backtrack(nums, list);
        return lists;
    }

    private void backtrack(int[] nums, LinkedList<Integer> list) {

        if (list.size() == nums.length) {

            lists.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            backtrack(nums, list);
//            list.remove(Integer.valueOf(nums[i]));
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        List<List<Integer>> lists = permute.permute(new int[]{1, 2, 3});
        for (List<Integer> list : lists){
            System.out.println(list);
        }
    }
}
