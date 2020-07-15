package 数据结构.面试题53I在排序数组中查找数字;

public class Solution {

    public int search(int[] nums, int target) {

        int count = 0;
        int index = find(nums, target);
        if(index!=-1){
            count++;
            for (int i = index+1;i<nums.length;i++){
                if(target == nums[i]){
                    count++;
                }
            }
        }
        return count;
    }

    private int find(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int middle = (left + right) / 2;

            if (nums[middle] == target) {
                right = middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        if (left >= nums.length) {
            return -1;
        }
        if (left == 0 && nums[0] != target) {
            return -1;
        }
        return  nums[left] == target ? left :-1;
    }

    private int find2(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int middle = (left + right) / 2;

            if (nums[middle] == target) {
                left = middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        if (left >= nums.length) {
            return -1;
        }
        if (left == 0 && nums[0] != target) {
            return -1;
        }
        return  nums[left] == target ? left :-1;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int i = so.find2(new int[]{5,7,7,8,8,10}, 7);
        System.out.println(i);
    }
}
