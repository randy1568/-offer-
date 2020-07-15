package 数据结构.面试题40最小的k个数;

import java.util.ArrayList;

public class Solution2 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        if (input == null || k < 1 || k > input.length) {
            return list;
        }
        int left = 0;
        int right = input.length - 1;
        int p = partition(input, left, right);
        while (p != k - 1) {
            if (p > k - 1) {
                right = p - 1;
            } else {
                left = p + 1;
            }
            p = partition(input, left, right);
        }
        for (int i = 0; i <= p; i++) {
            list.add(input[i]);
        }
        return list;
    }

    private int partition(int[] input, int left, int right) {
        int temp = input[right];
        int p = left - 1;
        for (int i = left; i < right; i++) {
            if (input[right] > input[i]) {
                p++;
                swap(input,i,p);
            }
        }
        swap(input,p+1,right);
        return p+1;
    }

    private void swap(int[] input, int i, int p) {
        int temp = input[i];
        input[i] = input[p];
        input[p] = temp;
    }

    public static void main(String[] args) {

    }
}
