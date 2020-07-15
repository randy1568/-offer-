package 数据结构.面试题57II和为s的连续正数序列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 滑动窗口
 */

public class Solution2 {
    public int[][] findContinuousSequence(int target) {

        List<int[]> lists = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList();
        int left = 1;
        int right = 1;
        int sum = 0;

        while (right <= target/2+1) {
            list.add(right);
            sum += right;
            right++;

            while (sum >= target) {
                if (sum == target) {
                    int[] num = add(left, right-1);
                    lists.add(num);
                    break;
                } else if (sum > target) {
                    int temp = list.removeFirst();
                    sum -= temp;
                    left++;
                }
            }
        }
        return lists.toArray(new int[lists.size()][]);
    }

    private int[] add(int left,int right){
        int[] num = new int[right-left+1];
        int k = 0;
        for (int i = left;i<=right;i++){
            num[k++] = i;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution2 so = new Solution2();
        int[][] continuousSequence = so.findContinuousSequence(71);
        System.out.println(Arrays.deepToString(continuousSequence));
    }
}
