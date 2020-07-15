package 数据结构.面试题27二叉树的镜像;

import 数据结构.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    /**
     * 递归实现
     *
     * @param root
     */
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        Mirror(root.left);
        Mirror(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    /**
     * 非递归实现
     *
     * @param root
     */
    public void Mirror2(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> stack = new LinkedList<>() ;
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode tempNode = stack.poll();
            if(tempNode == null){
                continue;
            }
            TreeNode temporary = tempNode.left;
            tempNode.left = tempNode.right;
            tempNode.right = temporary;
            stack.add(tempNode.left);
            stack.add(tempNode.right);
        }
    }

}
