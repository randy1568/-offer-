package 数据结构.面试题56II数组中数字出现的次数;

public class Solution {
    public int singleNumber(int[] nums) {

        int ax = 1;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            if(i>0){
                ax <<= 1;
            }
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & ax) >= 1) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                res |= ax;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int i = so.singleNumber(new int[]{5,4,5,5,4,1,4});
        System.out.println(i);
    }
}
