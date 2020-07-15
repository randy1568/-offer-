package 数据结构.面试题41数据流中的中位数;

import 数据结构.ListNode;

public class Solution2 {

    ListNode head = null;
    ListNode pt1 = head;
    ListNode pt2 = head;
    private int size = 0;

    public void Insert(Integer num) {
        if (head == null) {
            head = new ListNode(num);
            pt1 = pt2 = head;
            size++;
        } else {
            ListNode temp = head;
            while (temp.next != null && temp.next.val < num) {
                temp = temp.next;
            }
            if (temp.next == null) {
                temp.next = new ListNode(num);
                size++;
                if ((size & 0x01) != 0) {
                    pt1 = pt1.next;
                } else {
                    pt2 = pt2.next;
                }
            } else {
                ListNode newNode = new ListNode(num);
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
    }

    public Double GetMedian() {
        if ((size & 0x01) != 0) {
            return (pt1.val + pt2.val) / 2.0;
        } else {
            return Double.valueOf(pt1.val);
        }
    }

    public static void main(String[] args) {
        Solution2 so = new Solution2();
        so.Insert(5);
        System.out.println(so.GetMedian());
        so.Insert(2);
        System.out.println(so.GetMedian());
    }
}
