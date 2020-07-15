package 数据结构.面试题44数字序列中某一位的数字;

public class Solution {

    /**
     * 超时
     *
     * @param n
     * @return
     */
    public int findNthDigit(int n) {

        int count = 0;
        for (int i = 0, level=1; i <= n; i++) {
            if (i / 10 != 0) {
                String s = String.valueOf(i);
                for (int k = 0;k<s.length();k++){
                    if(count == n){
                        return s.charAt(k)-'0';
                    }
                    count++;
                }
                continue;
            }
            if (count == n) {
                return i;
            }
            count++;
        }
        return -1;
    }

    public int findNthDigit2(int n) {

        if (n < 10) {
            return n;
        }
        return findNthDigit2(n - 9, 1);
    }

    private int findNthDigit2(int n, int level) {

        int length =  countofIntegers(level);
        if (n < length) {
            int temp = n / (level + 1);
            int temp2 = n % (level + 1);
            int temp3 = temp + beginNum(level);
            if (temp2 == 0) {
                temp3--;
                return temp3 % 10;
            }
            int answer = 0;
            for (int i = level + 1; i >= temp2; i--) {
                answer = temp3 % 10;
                temp3 /= 10;
            }
            return answer;
        }
        return findNthDigit2((int) (n -length), level + 1);
    }
    private int beginNum(int level){
       return (int) Math.pow(10,level);
    }

    private int countofIntegers(int level){
        return (int) (Math.pow(10,level)*(level+1)*9);
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int nthDigit2 = so.findNthDigit(1000000000);
        System.out.println(nthDigit2);
        System.out.println();
    }

}
