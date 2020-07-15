package 数据结构.面试题18删除链表的节点;

import 数据结构.ListNode;

/**
 * 要求时间复杂度为O（1）
 * 这里的平均时间复杂度为O(1) ==> [O(1)*(n-1)+O(n)]/n ,结果还是O(1)
 */
public class Solution {
    //这里强调删除的节点在链表中一定能够找得到
    private void deleteNode(ListNode head, ListNode node){

        if(node.next!=null){
            ListNode nextNode = node.next;
            node.val = nextNode.val;
            node.next = nextNode.next;
        }else if(head == node){ //删除的是头节点，且只有一个节点
            head = null;
        }else{      //删除的是尾节点
            ListNode tempNode = head;
            while (tempNode.next!=node){
                tempNode = tempNode.next;
            }
            tempNode.next = null;
        }
    }
}
