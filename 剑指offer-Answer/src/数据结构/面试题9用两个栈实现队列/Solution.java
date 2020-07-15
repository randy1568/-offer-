package 数据结构.面试题9用两个栈实现队列;

import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
/**
 * 方法一：
    public void push(int node) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
 **/

    public void push(int node) {

        stack1.push(node);
    }

    public int pop() {
       if(stack2.isEmpty()){
          while (!stack1.isEmpty()){
              stack2.push(stack1.pop());
          }
       }
        return stack2.pop();
    }
}
