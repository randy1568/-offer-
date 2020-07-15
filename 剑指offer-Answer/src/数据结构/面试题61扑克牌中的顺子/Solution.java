package 数据结构.面试题61扑克牌中的顺子;

import java.util.Arrays;

public class Solution {
    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int count = 0;
        int pre = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                if (pre == 0) {
                    pre = nums[i];
                } else {
                   if(nums[i] == pre){
                       return false;
                   }
                   if(nums[i] - pre -1>count){
                       return false;
                   }else {
                       count -=(nums[i] - pre -1);
                   }
                }
            }
            pre = nums[i];
        }
        return true;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        so.isStraight(new int[]{0,0,3,1,5});
    }
}
