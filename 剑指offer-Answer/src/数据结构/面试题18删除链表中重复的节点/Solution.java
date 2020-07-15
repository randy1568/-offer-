package 数据结构.面试题18删除链表中重复的节点;

import 数据结构.ListNode;

/**
 * 更巧妙的办法，这里就是要考虑头节点被删除的情况，那么自己构造一个头节点，就和删除中间节点的情况一致了
 */
public class Solution {


    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return pHead;
        }
        ListNode aheadNode = pHead;
        ListNode currentNode = pHead;
        ListNode nextNode = null;
        while (currentNode != null) {
            nextNode = currentNode.next;
            if (nextNode != null && currentNode.val == nextNode.val) {
                ListNode preNode = nextNode;
                nextNode = nextNode.next;
                while (nextNode != null && preNode.val == nextNode.val) {
                    preNode = nextNode;
                    nextNode = nextNode.next;
                }
                if (nextNode == null) {
                    if (aheadNode == currentNode) {
                        return null;
                    }
                    aheadNode.next = null;
                    currentNode = null;
                } else {
                    if(aheadNode == currentNode){
                        aheadNode = nextNode;
                        currentNode = nextNode;
                        pHead =aheadNode;
                        continue;
                    }
                    aheadNode.next = nextNode;
                    currentNode = nextNode;
                }
            }else {
                aheadNode = currentNode;
                currentNode = nextNode;
            }
        }
        return pHead;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode temp = listNode;
        temp.next = new ListNode(1);
        temp = temp.next;
        temp.next = new ListNode(1);
        temp = temp.next;
        temp.next = new ListNode(1);
        temp = temp.next;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(3);

        listNode = deleteDuplication(listNode);
        System.out.println(listNode);

    }
}
