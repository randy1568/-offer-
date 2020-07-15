package 数据结构.面试题21调整数组顺序使奇数位于偶数前面;

import java.util.Arrays;

public class Solution {

    public static void reOrderArray(int[] array) {

        int pt1 = 0;
        int pt2 = array.length - 1;
        int[] newArray = new int[array.length];
        for (int i = 0, j = array.length - 1; pt1 < array.length && pt2 >= 0; pt1++, pt2--) {
            if (array[pt1] % 2 == 1) {
                newArray[i++] = array[pt1];
            }
            if (array[pt2] % 2 == 0) {
                newArray[j--] = array[pt2];
            }
        }
        for (int k = 0;k<array.length;k++){
            array[k] = newArray[k];
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7};
        reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }
}
