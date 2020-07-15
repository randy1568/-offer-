package 数据结构.面试题7重建二叉树;

import 数据结构.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ReConstructBinaryTree {

    public Map<Integer,Integer> map = new HashMap<>();
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {

        for (int i = 0;i<in.length;i++){
            map.put(in[i],i);
        }
       return  construct(pre,0,pre.length-1,0);

    }

    public TreeNode construct(int[] pre,int preLeft,int preRight,int inLeft){
        if(preLeft > preRight){
            return null;
        }
        TreeNode node = new TreeNode(pre[preLeft]);
        int indexOfIn = map.get(pre[preLeft]);
        int leftSize = indexOfIn - inLeft;
        node.left = construct(pre,preLeft+1,preLeft+leftSize,inLeft);
        node.right = construct(pre,preLeft+leftSize+1,preRight,indexOfIn+1);
        return node;
    }



}
