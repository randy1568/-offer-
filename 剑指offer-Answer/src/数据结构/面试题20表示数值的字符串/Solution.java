package 数据结构.面试题20表示数值的字符串;

public class Solution {


    public static void main(String[] args) {
        System.out.println(isValidNum(new char[]{'1','2','3','.'}));
    }

    private static boolean isValidNum(char[] charSequence) {
        if (charSequence == null || charSequence.length == 0) {
            return false;
        }
        return checkNum(charSequence, 0, '.');
    }

    private static boolean checkNum(char[] charSequence, int i, char specialChar) {
        int tempLoc = i;
        if (specialChar == '.') {
            if (charSequence[i] == '+' || charSequence[i] == '-') {
                tempLoc++;
            }
            while (tempLoc < charSequence.length && charSequence[tempLoc] <= '9' && charSequence[tempLoc] >= '0') {
                tempLoc++;
            }
            if (tempLoc == charSequence.length) {
                return true;
            }
            if (charSequence[tempLoc] == '.') {
                return checkNum(charSequence, tempLoc + 1, 'e');
            } else if (tempLoc > 0 && (charSequence[tempLoc] == 'e' || charSequence[tempLoc] == 'E')) {
                return checkNum(charSequence, tempLoc, 'e');
            } else {
                return false;
            }
        } else if (specialChar == 'e' || specialChar == 'E') {
            while (tempLoc < charSequence.length && charSequence[tempLoc] <= '9' && charSequence[tempLoc] >= '0') {
                tempLoc++;
            }
            if (tempLoc == charSequence.length) {
                return true;
            }
            if (charSequence[tempLoc] == 'e' || charSequence[tempLoc] == 'E') {
                return checkNum(charSequence, tempLoc + 1, 'p');
            } else {
                return false;
            }
        } else {
            if( tempLoc == charSequence.length){
                return false;
            }
            if (charSequence[i] == '+' || charSequence[i] == '-') {
                tempLoc++;
            }
            while (tempLoc < charSequence.length && charSequence[tempLoc] <= '9' && charSequence[tempLoc] >= '0') {
                tempLoc++;
            }
            if (tempLoc == charSequence.length) {
                return true;
            } else {
                return false;
            }
        }
    }
}
