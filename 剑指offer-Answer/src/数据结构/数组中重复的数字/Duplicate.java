package 数据结构.数组中重复的数字;

/**
 * 题目描述：
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 * 方法一：对数组排序，再遍历一遍数组，找出重复数字，时间复杂度nlgn
 * 方法二：使用hash表找到重复数字，时间复杂度O(n),空间复杂度O(n)
 * 方法三：时间复杂度O(n),空间复杂度O(1),利用数组下标和输入数组的特点解决
 */
public class Duplicate {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        for (int i = 0;i<length;i++){

            while (numbers[i]!=i){

                if(numbers[numbers[i]] == numbers[i]){
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers,numbers[i],i);
            }
        }
        return false;
    }

    public void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
