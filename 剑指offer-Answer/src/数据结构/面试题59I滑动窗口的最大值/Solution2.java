package 数据结构.面试题59I滑动窗口的最大值;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 单调队列
 */
public class Solution2 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];

        MyQueue queue = new MyQueue();

        int n = 0;
        for (int i = 0; i < nums.length; i++) {
           if(i<k-1){
               queue.add(nums[i]);
           }else {
               queue.add(nums[i]);
               res[n++] = queue.max();
               queue.remove(nums[i-k+1]);
           }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 so = new Solution2();
        int[] ints = so.maxSlidingWindow(new int[]{1, -1}, 1);
        System.out.println(Arrays.toString(ints));
    }
}

class MyQueue {

    LinkedList<Integer> list;

    public MyQueue() {
        list = new LinkedList<>();
    }

    public Integer max() {
        return list.getFirst();
    }

    public void add(Integer num) {
        while (!list.isEmpty() && list.getLast() < num) {
            list.removeLast();
        }
        list.addLast(num);
    }

    public void remove(Integer num) {
        if (!list.isEmpty() && list.getFirst() == num) {
            list.removeFirst();
        }
    }
}


