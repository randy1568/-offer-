package 数据结构.面试题33二叉搜索树的后续遍历序列;

public class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        return VerifySquenceOfBST(sequence, 0, sequence[sequence.length - 1], sequence.length - 1);
    }

    public boolean VerifySquenceOfBST(int[] sequence, int leftBeginIndex, int root, int rootIndex) {
        if (leftBeginIndex == rootIndex) {
            return true;
        }
        int tempIndex = leftBeginIndex;
        while (sequence[tempIndex] < root) {
            tempIndex++;
        }
        if (tempIndex == leftBeginIndex) {
            for (int i = leftBeginIndex;i<rootIndex;i++){
                if(sequence[i] < root){
                    return false;
                }
            }
            return VerifySquenceOfBST(sequence, leftBeginIndex, sequence[rootIndex - 1], rootIndex - 1);
        }
        if (tempIndex == rootIndex) {
            return VerifySquenceOfBST(sequence, leftBeginIndex, sequence[tempIndex - 1], tempIndex - 1);
        }
        for (int i = tempIndex;i<rootIndex;i++){
            if(sequence[i] < root){
                return false;
            }
        }
        return VerifySquenceOfBST(sequence, leftBeginIndex, sequence[tempIndex - 1], tempIndex - 1) ||
                VerifySquenceOfBST(sequence, tempIndex, sequence[rootIndex - 1], rootIndex - 1);
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.VerifySquenceOfBST(new int[]{4,6,12,8,16,14,10}));
    }
}
