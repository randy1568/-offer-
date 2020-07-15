package 数据结构.面试题49丑数;

/**
 * 动态规划
 */
public class Solution3 {


    public int nthUglyNumber(int N) {

        int dp[] = new int[N];
        int dp2 = 0, dp3 = 0, dp5 = 0;
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            dp[i] = Math.min(Math.min(dp[dp2]*2,dp[dp3]*3),dp[dp5]*5);
            if(dp[i] == dp[dp2]*2){
                dp2++;
            }
            if(dp[i] == dp[dp3]*3){
                dp3++;
            }
            if(dp[i] == dp[dp5]*5){
                dp5++;
            }
        }
        return dp[N-1];

    }


    public static void main(String[] args) {
        Solution3 so = new Solution3();
        int i = so.nthUglyNumber(213);
        System.out.println(i);
    }
}
