package 数据结构.面试题36二叉搜索树与双向链表;

import 数据结构.TreeNode;

public class Solution {

    private TreeNode preNode = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Convert2(pRootOfTree);
        while (pRootOfTree.left != null) {
            pRootOfTree = pRootOfTree.left;
        }
        return pRootOfTree;
    }

    /**
     * 中序遍历
     * @param root
     */
    public void Convert2(TreeNode root) {
        if (root == null) {
            return ;
        }
        Convert2(root.left);
        root.left = preNode;
        if (preNode != null) {
            preNode.right = root;
        }
        preNode = root;
        Convert2(root.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(6);
        node.right = new TreeNode(14);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(8);
        node.right.left = new TreeNode(12);
        node.right.right = new TreeNode(16);
        System.out.println(solution.Convert(node));
    }

}
