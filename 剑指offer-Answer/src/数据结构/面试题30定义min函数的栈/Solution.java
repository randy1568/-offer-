package 数据结构.面试题30定义min函数的栈;

import java.util.PriorityQueue;
import java.util.Stack;

public class Solution {
    private Stack<Integer> stack = new Stack<>();
    private int minMun = Integer.MAX_VALUE;
    private PriorityQueue<Integer> queue = new PriorityQueue<>();

    public void push(int node) {
        if (node < minMun) {
            minMun = node;
        }
        queue.add(node);
        stack.push(node);
    }

    public void pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        if( stack.peek() == minMun){
            queue.remove(minMun);
            minMun = queue.peek();
        }
        queue.remove( stack.pop());
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        return stack.peek();
    }

    public int min() {
        if (stack.isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        return minMun;
    }
}
