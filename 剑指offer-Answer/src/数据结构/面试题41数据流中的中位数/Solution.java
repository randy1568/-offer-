package 数据结构.面试题41数据流中的中位数;

import java.util.Collections;
import java.util.LinkedList;

public class Solution {

    LinkedList<Integer> list = new LinkedList<>();

    public void Insert(Integer num) {
        list.add(num);
    }

    public Double GetMedian() {

        Collections.sort(list);
        int length = list.size();
        if (length == 1) {
            return Double.valueOf(list.get(0));
        }
        if ((length & 0x1) != 1) {
            return Double.valueOf((double) (list.get(length / 2 - 1) + list.get(length / 2)) / 2.0);
        }
        return Double.valueOf(list.get(length / 2));
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        so.Insert(5);
        System.out.println(so.GetMedian());
        so.Insert(2);
        System.out.println(so.GetMedian());
    }
}
