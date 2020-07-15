package 数据结构.从尾到头打印链表;

import 数据结构.ListNode;

public class PrintListFromTailToHead {

    public static ListNode printListFromTailToHead(ListNode listNode){
        if (listNode.next  == null){
            return listNode;
        }
        ListNode node = printListFromTailToHead(listNode.next);

        ListNode t = listNode.next;
        t.next = listNode;
        listNode.next = null;
        return node;
    }
    public static ListNode printListFromTailToHead2(ListNode listNode){

        ListNode head = new ListNode(-1);
        while (listNode!=null){
            ListNode temp = head.next;
            ListNode temp2 = listNode;
            head.next = listNode;
            listNode = listNode.next;
            temp2.next = temp;
        }
        return head.next;
    }

    public static ListNode printListFromTailToHead3(ListNode head){

        if (head == null || head.next == null) {
            return head;
        }
        ListNode pt1 = head;
        ListNode pt2 = head.next;
        while (pt2 != null) {

            ListNode temp = pt2;
            pt2 = pt2.next;
            temp.next = pt1;

            pt1 = temp;
        }
        head.next = null;
        return pt1;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next= new ListNode(4);
        head =  printListFromTailToHead3(head);
        System.out.println(head);
    }
}
