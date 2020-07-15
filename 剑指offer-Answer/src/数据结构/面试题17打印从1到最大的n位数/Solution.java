package 数据结构.面试题17打印从1到最大的n位数;

/**
 * 难点在与用什么样的方式来表示大数
 */
public class Solution {
    void print1ToMAxDigits(int n) {
        char[] num = new char[n];
        for (int i = 0; i < n; i++) {
            num[i] = '0';
        }
        while (!increment(num)) {
            printNum(num);
        }
    }

    //全排列解决
    void print1ToMAxDigits1(int n) {
        char[] num = new char[n];
        for (int i = 0; i < 10; i++) {
            num[0] = (char) ('0' + i);
            print1ToMAxDigitsBackTracking(num, 1);
        }
    }
    private void print1ToMAxDigitsBackTracking(char[] num, int index) {
        if (index == num.length) {
            printNum(num);
            return;
        }
        for (int i = 0; i < 10; i++) {
            num[index] = (char) ('0'+i);
            print1ToMAxDigitsBackTracking(num,index+1);
        }
    }

    private void printNum(char[] num) {
        for (int i = 0; i < num.length; i++) {
            if (num[i] != '0') {
                for (int j = i; j < num.length; j++) {
                    System.out.print(num[j]);
                }
                System.out.println();
                return;
            }
        }
    }
    //对字符数组的操作
    private boolean increment(char[] num) {
        for (int i = num.length - 1; i >= 0; i--) {
            if (num[i] < '9') {
                num[i] += 1;
                return false;
            } else {
                if (i == 0) {
                    break;
                }
                num[i] = '0';
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.print1ToMAxDigits1(5);
    }

}
