package 数据结构.面试题55平衡二叉树;

import 数据结构.TreeNode;

public class Solution {


    public boolean isBalanced(TreeNode root) {

        int depth = depth(root);
        return depth == -1 ? false : true;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if (leftDepth != -1 && rightDepth != -1 && Math.abs(leftDepth - rightDepth) <= 1) {
            return Math.max(leftDepth, rightDepth)+1;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
