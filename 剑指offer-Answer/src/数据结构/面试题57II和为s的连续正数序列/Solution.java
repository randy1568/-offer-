package 数据结构.面试题57II和为s的连续正数序列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] findContinuousSequence(int target) {

        List<List> lists = new ArrayList<>();
        for (int i = 1; i <= target/2; i++) {
            int sum = 0;
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < target; j++) {
                if (sum < target) {
                    list.add(j);
                    sum += j;
                } else if (sum > target) {
                    break;
                } else {
                    lists.add(list);
                    break;
                }
            }
        }
        int[][] nums = new int[lists.size()][];
        int k = 0;
        for (List<Integer> list : lists) {
            nums[k] = new int[list.size()];
            int index = 0;
            for (Integer temp : list) {
                nums[k][index++] = temp;
            }
            k++;
        }
        return nums ;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int[][] continuousSequence = so.findContinuousSequence(9);
        System.out.println(Arrays.deepToString(continuousSequence));
    }
}
