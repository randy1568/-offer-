package 数据结构.面试题49丑数;

/**
 * 暴力超时
 */
public class Solution {
    public int nthUglyNumber(int N) {

        int count = 1;
        int i = 2;
        while (count < N){
            if (isUglyNumber(i++)){
                count++;
            }
            if(count == N){
                return i-1;
            }
        }
        return 0;
    }

    private boolean isUglyNumber(int n) {
        int i = 2;
        while (n != 1) {
            if (n % i != 0) {
                i++;
            } else {
                if(i !=2 && i!=3 && i!=5){
                    return false;
                }
                n = n / i;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int i = so.nthUglyNumber(3);
        System.out.println(i);
    }
}
