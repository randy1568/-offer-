package 数据结构.面试题8二叉树的下一个节点;

class TreeNode{
    int m_Val;
    TreeNode leftChild;
    TreeNode rightChiled;
    TreeNode parent;

    public TreeNode(TreeNode leftChild) {
        this.leftChild = leftChild;
    }
}

public class GetNext {

    public TreeNode getNext(TreeNode node){
        if (node == null ){
            return node;
        }
        if(node.rightChiled!=null){
            TreeNode nextNode = node.rightChiled;
            while (nextNode.leftChild !=null){
                nextNode = nextNode.leftChild;
            }
            return nextNode;
        }else if(node.parent!=null){
            TreeNode parent = node.parent;
            if (parent.leftChild == node){
                return parent;
            }else {
                while (parent.parent!=null){
                   TreeNode tempPatent = parent.parent;
                    if(tempPatent.leftChild == parent){
                        return tempPatent;
                    }
                    parent = tempPatent;
                }
            }
        }
        return null;
    }
}
