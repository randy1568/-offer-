package 数据结构.面试题32把二叉树打印成多行;

import 数据结构.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int parentNum = 1, childNum = 0;
        ArrayList<Integer> tempList = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            tempList.add(node.val);
            parentNum--;
            if(node.left!=null){
                queue.add(node.left);
                childNum++;
            }
            if(node.right!=null){
                queue.add(node.right);
                childNum++;
            }
            if (parentNum == 0) {
                lists.add(new ArrayList<>(tempList));
                tempList.clear();
                parentNum = childNum;
                childNum = 0;
            }
        }
        return lists;
    }
}
