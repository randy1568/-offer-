package 数据结构.面试题26树的子结构;

import 数据结构.TreeNode;

public class Solution {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            result = CompareChildNode(root1, root2);
        }
        if (!result) {
            result = HasSubtree(root1.left, root2);
        }
        if (!result) {
            result = HasSubtree(root1.right, root2);
        }
        return result;
    }

    private boolean CompareChildNode(TreeNode root1, TreeNode root2) {
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }
        if(root1.val!=root2.val){
            return false;
        }
        return CompareChildNode(root1.left,root2.left) && CompareChildNode(root1.right,root2.right);
    }
}
