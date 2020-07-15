package 数据结构.面试题22链表中倒数第k个节点;

import 数据结构.ListNode;

public class Solution {

    /**
     * 遍历两次链表
     * @param head
     * @param k
     * @return
     */
    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 1) {
            return null;
        }
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        if (k > length) {
            return null;
        }
        temp = head;
        for (int i = 0; i < length - k; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 快慢指针解法，只遍历一次链表
     * @param head
     * @param k
     * @return
     */
    public static ListNode FindKthToTail2(ListNode head, int k) {
        if (head == null || k < 1) {
            return null;
        }
        ListNode pt1 = head;
        ListNode pt2 = head;
        int index = 0;
        while (index < k  && pt1!=null){
            pt1 = pt1.next;
            index++;
        }
        if(pt1 == null){
            if(index <k){
                return null;
            }else {
                return pt2;
            }
        }
        while (pt1!=null){
            pt1 = pt1.next;
            pt2 = pt2.next;
        }
        return pt2;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        System.out.println(FindKthToTail2(head, 5));
    }
}
