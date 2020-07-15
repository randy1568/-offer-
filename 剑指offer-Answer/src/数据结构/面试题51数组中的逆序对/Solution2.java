package 数据结构.面试题51数组中的逆序对;

/**
 * 归并排序，在合并的时候计算逆序对
 */
public class Solution2 {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length < 2) {
            return 0;
        }

        int[] temp = new int[nums.length];

        return reversePairs(nums, 0, nums.length - 1, temp);
    }

    private int reversePairs(int[] nums, int start, int end, int[] temp) {
        if (start >= end) {
            return 0;
        }

        int middle = (start + end) / 2;

        int leftPairs = reversePairs(nums, start, middle, temp);
        int rightPairs = reversePairs(nums, middle + 1, end, temp);

        if (nums[middle] < nums[middle + 1]) {
            return leftPairs + rightPairs;
        }
        int middlePairs = merge(nums, start, middle, end, temp);

        return leftPairs + rightPairs + middlePairs;
    }

    private int merge(int[] nums, int start, int middle, int end, int[] temp) {

        System.arraycopy(nums, start, temp, start, end - start + 1);

        int i = start;
        int j = middle + 1;
        int count = 0;

        for (int k = start; k <=end; k++) {
            if(i == middle+1){
                nums[k] = temp[j++];
                continue;
            }
            if(j == end+1){
                nums[k] = temp[i++];
                continue;
            }
            //一定要加等于，因为会出现相同的数,且成为逆序对的条件是前边的数大于后边的数
            if(temp[i] <= temp[j]){
                nums[k] = temp[i++];
            }else {
                nums[k] = temp[j++];
                count += middle - i+1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution2 so = new Solution2();
        int i = so.reversePairs(new int[]{7, 5, 6, 4});
        System.out.println(i);
    }
}
