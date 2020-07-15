package 数据结构.面试题28对称的二叉树;

import 数据结构.TreeNode;

public class Solution {

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetrical2(pRoot.left, pRoot.right);
    }

    boolean isSymmetrical2(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot1 == null && pRoot2 == null) {
            return true;
        } else if (pRoot1 == null && pRoot2 != null) {
            return false;
        } else if (pRoot1 != null && pRoot2 == null) {
            return false;
        }
        if(pRoot1.val == pRoot2.val){
            return isSymmetrical2(pRoot1.left,pRoot2.right) && isSymmetrical2(pRoot1.right,pRoot2.left);
        }else {
            return false;
        }
    }
}
