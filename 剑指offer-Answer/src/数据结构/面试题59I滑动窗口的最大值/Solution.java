package 数据结构.面试题59I滑动窗口的最大值;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 优先队列
 */
public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int n = 0;
        for (int i = 0;i< k;i++){
            queue.add(nums[i]);
        }
        res[n++] = queue.peek();
        queue.remove(nums[n-1]);
        for (int i = 2; i < nums.length; i++) {
            queue.add(nums[i]);
            res[n++] = queue.peek();
            queue.remove(nums[n-k+1]);
        }
        return res;
    }
}
