package 数据结构.面试题10矩形覆盖;

public class Solution {
    //动态规划
    public int RectCover(int target) {
        if(target == 0){
            return 0;
        }else if(target == 1){
            return 1;
        }
        int[] f = new int[target+1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2;i<=target;i++){
            f[i] = f[i-1]+f[i-2];
        }
        return f[target];
    }


}
