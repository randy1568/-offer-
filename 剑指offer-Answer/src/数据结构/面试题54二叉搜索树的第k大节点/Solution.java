package 数据结构.面试题54二叉搜索树的第k大节点;

import 数据结构.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<Integer> list = new ArrayList<>();

    public int kthLargest(TreeNode root, int k) {

        kthLargest(root);
        return list.get(list.size()-k);
    }

    public void kthLargest(TreeNode root) {

        if (root == null) {
            return;
        }
        kthLargest(root.left);
        list.add(root.val);
        kthLargest(root.right);
    }
}
