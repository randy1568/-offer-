package 数据结构.面试题32按之字形顺序打印二叉树;

import 数据结构.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) {
            return lists;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        int parentNum = 1;
        int ChildNum = 0;
        int first = 1;
        int second = 0;
        stack1.add(pRoot);
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            TreeNode node = null;
            if (!stack1.isEmpty() && first == 1) {
                node = stack1.pop();
                list.add(node.val);
                parentNum--;
                if (node.left != null) {
                    stack2.add(node.left);
                    ChildNum++;
                }
                if (node.right != null) {
                    stack2.add(node.right);
                    ChildNum++;
                }
            }
            if (!stack2.isEmpty() && second == 1) {
                node = stack2.pop();
                list.add(node.val);
                parentNum--;
                if (node.right != null) {
                    stack1.add(node.right);
                    ChildNum++;
                }
                if (node.left != null) {
                    stack1.add(node.left);
                    ChildNum++;
                }
            }
            if (parentNum == 0) {
                lists.add(new ArrayList<>(list));
                list.clear();
                parentNum = ChildNum;
                ChildNum = 0;
                first = 1 - first;
                second = 1 - second;
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(6);
        node.right = new TreeNode(10);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(7);
        node.right.left = new TreeNode(9);
        node.right.right = new TreeNode(11);
        solution.Print(node);
    }
}
