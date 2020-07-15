package 数据结构.有序矩阵中第K小的元素;

import java.util.Arrays;

public class HeapSort {

    public void sort(int[] nums) {
        for (int i = nums.length / 2; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }
        for (int j = nums.length-1;j>=0;j--){
            swap(nums,0,j);
            adjustHeap(nums,0,j);
        }
    }

    private void adjustHeap(int[] nums, int i, int length) {
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if(k+1 < length && nums[k] < nums[k+1]){
                k++;
            }
            if(nums[i] < nums[k]){
                swap(nums,i,k);
                i = k;
            }
        }
    }

    public void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] nums =  new int[]{1,3,0,2,9,10,5};
        heapSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
