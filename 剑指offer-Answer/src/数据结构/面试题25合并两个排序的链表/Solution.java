package 数据结构.面试题25合并两个排序的链表;

import 数据结构.ListNode;

public class Solution {
    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null && list2 != null) {
            return list2;
        } else if (list1 != null && list2 == null) {
            return list1;
        }
        return list1.val > list2.val ? Merge1(list2,list1) :Merge1(list1,list2);
    }

    private static ListNode Merge1(ListNode list1,ListNode list2){
        if (list1 == null && list2 == null) {
            return null;
        }  else if (list1 == null && list2 != null) {
            return list2;
        } else if (list1 != null && list2 == null) {
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = Merge(list1.next,list2);
        }else {
            ListNode tempList = list1.next;
            ListNode tempList2 = list2.next;
            list1.next = list2;
            list2.next = tempList;
            list2.next = Merge(tempList,tempList2);
        }
        return list1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 3; i <= 9; i+=2) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        ListNode head2 = new ListNode(2);
        ListNode temp1 = head2;
        for (int i = 4; i <= 8; i+=2) {
            temp1.next = new ListNode(i);
            temp1 = temp1.next;
        }
        head = Merge(head,head2);
        System.out.println(head);
    }
}
