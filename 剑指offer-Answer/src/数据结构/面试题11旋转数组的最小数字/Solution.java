package 数据结构.面试题11旋转数组的最小数字;

public class Solution {

    //二分法
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = left;
        while (array[left] >= array[right]) {
            if (right - left == 1) {
                mid = right;
                break;
            }
            mid = (left + right) >> 1;
            //辅助需要顺序遍历
            if (array[left] == array[right] && array[mid] == array[left]) {
                return minNumberByOrder(array, left, right);
            }
            if (array[mid] >= array[left]) {
                left = mid;
            } else if (array[mid] <= array[right]) {
                right = mid;
            }
        }
        return array[mid];
    }


    private int minNumberByOrder(int[] array, int left, int right) {
        int temp = array[left];
        for (int i = left + 1; i <= right; i++) {
            if (array[i] < temp) {
                temp = array[i];
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.minNumberInRotateArray(new int[]{3, 4, 5, 1, 2});
        System.out.println(i);
    }
}
