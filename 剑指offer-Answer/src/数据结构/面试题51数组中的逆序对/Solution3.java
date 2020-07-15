package 数据结构.面试题51数组中的逆序对;

import java.util.Arrays;

/**
 * 归并排序：自顶向下
 */
public class Solution3 {

    public void sort(int[] nums) {

        sort(nums, 0, nums.length - 1);
    }

    public void sort(int[] nums, int start, int end) {

        if (start >= end) {
            return;
        }
        int middle = (start + end) / 2;
        sort(nums, start, middle);
        sort(nums, middle + 1, end);
        merge(nums, start, middle, end);
    }

    private void merge(int[] nums, int start, int middle, int end) {
        int[] tempNum = new int[end - start + 1];
        int startA = start;
        int startB = middle + 1;
        int k = 0;

        while (startA <= middle && startB <= end) {
            if (nums[startA] <= nums[startB]) {
                tempNum[k++] = nums[startA++];
            } else {
                tempNum[k++] = nums[startB++];
            }
        }

        while (startA <= middle) {
            tempNum[k++] = nums[startA++];
        }
        while (startB <= end) {
            tempNum[k++] = nums[startB++];
        }

        for (int i = 0; i < k; i++) {
            nums[start + i] = tempNum[i];
        }
    }

    public static void main(String[] args) {
        Solution3 so = new Solution3();
        int[] nums = new int[]{1000, 1, 2, 6, -1, 100, 200};
        so.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
