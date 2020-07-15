package 数据结构.面试题37序列化二叉树;

import 数据结构.TreeNode;

public class Solution {

    /**
     * 前序遍历
     * @param root
     * @return
     */
    String Serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        Serialize(root, builder);
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    void Serialize(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("#" + ',');
            return;
        }
        builder.append(root.val + ",");
        Serialize(root.left, builder);
        Serialize(root.right, builder);
    }

    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] nodes = str.split(",");
        TreeNode root = new TreeNode(-1);
        Deserialize(nodes, 0, root);
        return root;
    }

    /**
     * 反序列化也同样采用前序遍历的方式
     * @param nodes
     * @param nodeIndex
     * @param root
     * @return
     */
    private int Deserialize(String[] nodes, int nodeIndex, TreeNode root) {
        if (nodes[nodeIndex].equals("#")) {
            return nodeIndex;
        }
        int nodeValue = Integer.parseInt(nodes[nodeIndex]);
        root.val = nodeValue;
        root.left = null;
        if (!nodes[nodeIndex+1].equals("#")) {
           root.left = new TreeNode(-1);
        }
        nodeIndex = Deserialize(nodes, nodeIndex + 1, root.left);
        root.right = null;
        if (!nodes[nodeIndex+1].equals("#")) {
            root.right = new TreeNode(-1);
        }
        nodeIndex = Deserialize(nodes, nodeIndex + 1, root.right);
        return nodeIndex;
    }

    private void print(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        print(root.left);
        print(root.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        String serialize = solution.Serialize(node);
//        System.out.println(serialize);
        TreeNode deserialize = solution.Deserialize(serialize);
        solution.print(deserialize);
    }
}
