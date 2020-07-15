package 数据结构.面试题51数组中的逆序对;

import java.util.Arrays;

/**
 * 快排
 */
public class Solution4 {

    public void sort(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }
        sort(nums, 0, nums.length - 1);
    }

    public void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = partition(nums, start, end);

        sort(nums, start, middle - 1);
        sort(nums, middle + 1, end);
    }

    private int partition(int[] nums, int start, int end) {

        int temp = nums[end];
        int pre = start - 1;
        for (int i = start; i <= end - 1; i++) {
            if (nums[i] < temp) {
                pre++;
                swap(nums, i, pre);
            }
        }
        swap(nums,pre+1,end);
        return pre+1;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


    public static void main(String[] args) {
        Solution4 so = new Solution4();
        int[] nums = new int[]{0,1000, 1, 2, 6, -1, 100, 200};
        so.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
