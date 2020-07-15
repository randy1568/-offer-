package 数据结构.面试题62圆圈中最后剩下的数字;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {

    public int lastRemaining(int n, int m) {

        ArrayList<Integer> queue = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }

        int preIndex = 0;
        while (queue.size() > 1) {
            int size = queue.size();
            queue.remove((preIndex + m-1) % size);
            preIndex = (preIndex + m-1) % (size );

        }
        return queue.get(0);
    }


    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println( so.lastRemaining(56795, 87778));
    }
}
