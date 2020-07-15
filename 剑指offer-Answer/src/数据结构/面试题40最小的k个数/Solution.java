package 数据结构.面试题40最小的k个数;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input == null || k <1 || k>input.length){
            return list;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < input.length; i++) {
            if (queue.size() < k) {
                queue.add(input[i]);
            } else if (input[i] < queue.peek()) {
                queue.poll();
                queue.add(input[i]);
            }
        }
       while (!queue.isEmpty()){
            list.add(queue.poll());
       }
        return list;
    }

    public static void main(String[] args) {

    }
}
