package 数据结构.面试题56II数组中数字出现的次数;

import java.util.Arrays;

public class Solution2 {
    public int singleNumber(int[] nums) {

        Arrays.sort(nums);
        int pre = nums[0];
        int count = 1;
        for(int i = 1;i<nums.length;i++){
            if(pre!=nums[i] && count<=1){
                return pre;
            }
            if(pre!=nums[i]){
                pre = nums[i];
                count=1;
            }else{
                count++;
            }
        }
        return pre;
    }
}
