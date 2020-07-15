package 数据结构.面试题10青蛙跳台阶;

public class JumpFloor {

    public int getJumpFloor(int n){
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2;i<=n;i++){
            f[i] = f[i-1]+f[i-2];
        }
        return f[n];
    }
}
