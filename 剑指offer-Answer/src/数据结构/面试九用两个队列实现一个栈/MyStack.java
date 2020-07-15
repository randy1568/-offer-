package 数据结构.面试九用两个队列实现一个栈;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue = null;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (queue.isEmpty()){
            queue.add(x);
        }else {
            Queue<Integer> queueTemp = new LinkedList<>();
            queueTemp.add(x);
            while (!queue.isEmpty()){
                queueTemp.add(queue.poll());
            }
            queue = queueTemp;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}