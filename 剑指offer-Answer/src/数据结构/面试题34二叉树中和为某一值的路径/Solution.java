package 数据结构.面试题34二叉树中和为某一值的路径;

import 数据结构.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {

    private ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return lists;
        }
        LinkedList<Integer> list = new LinkedList<>();
        FindPath2(root, target, list);
        return lists;
    }

    /**
     * 回溯法
     * @param root
     * @param target
     * @param list
     */
    private void FindPath2(TreeNode root, int target, LinkedList<Integer> list) {
        list.add(root.val);
        if (target == root.val) {
            if(root.left == null && root.right == null){
                lists.add(new ArrayList<>(list));
            }
            list.removeLast();
            return ;
        } else if (root.val > target) {    //剪枝
            list.removeLast();
            return ;
        } else if (root.left == null && root.right == null) {
            list.removeLast();
            return ;
        }
        for (int i = 0; i < 2; i++) {
            if (i == 0 && root.left != null) {
                 FindPath2(root.left, target - root.val, list);
            } else if (root.right != null) {
                FindPath2(root.right, target - root.val, list);
            }
        }
        list.removeLast();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(12);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(7);
        solution.FindPath(node,22);
    }
}
