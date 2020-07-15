package 数据结构.面试题31栈的压入弹出序列;

import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (popA == null || pushA == null || pushA.length != popA.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0, popIndex = 0;
        for (; pushIndex < pushA.length; pushIndex++) {
            if (stack.isEmpty()) {
                stack.push(pushA[pushIndex]);
            } else if (pushA[pushIndex] != popA[popIndex] && pushA[pushIndex - 1] != popA[popIndex]) {
                stack.push(pushA[pushIndex]);
            } else if (pushA[pushIndex] == popA[popIndex]) {
                popIndex++;
                continue;
            } else if (pushA[pushIndex - 1] == popA[popIndex]) {
                stack.pop();
                popIndex++;
                pushIndex--;
            }
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != popA[popIndex]) {
                return false;
            }
            popIndex++;
        }
        return true;
    }

    public boolean IsPopOrder2(int[] pushA, int[] popA) {
        if (popA == null || pushA == null || pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0, popIndex = 0;
        for (; pushIndex < pushA.length; pushIndex++) {
            if (stack.isEmpty()) {
                stack.push(pushA[pushIndex]);
            } else if (stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
                pushIndex--;
            }else {
                stack.push(pushA[pushIndex]);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != popA[popIndex]) {
                return false;
            }
            popIndex++;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.IsPopOrder2(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    }
}
