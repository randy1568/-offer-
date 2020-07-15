package 数据结构.面试题51数组中的逆序对;

/**
 * 暴力超时
 */
public class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] > nums[i]){
                    count++;
                }
            }
        }
        return count;
    }
}
