package 数据结构.面试题24反转链表;

import 数据结构.ListNode;

public class Solution {

    /**
     * 递归实现
     * @param head
     * @return
     */
    public static ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null){
            return  head;
        }
        ListNode newHead = ReverseList(head.next);  //此处固定reverse后的头节点
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        head =  ReverseList(head);
        System.out.println(head);
    }
}
