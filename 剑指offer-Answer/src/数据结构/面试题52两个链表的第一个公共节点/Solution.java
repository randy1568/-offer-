package 数据结构.面试题52两个链表的第一个公共节点;

import 数据结构.ListNode;

import java.util.Stack;

public class Solution {
    /**
     * 栈
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        while (headA != null) {
            stackA.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            stackB.push(headB);
            headB = headB.next;
        }
        ListNode preNode = null;
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            ListNode tempA = stackA.pop();
            ListNode tempB = stackB.pop();
            if(tempA!=tempB){
                return preNode;
            }
            preNode = tempA;
        }
        return preNode;
    }

//    /**
//     * 双指针
//     * @param headA
//     * @param headB
//     * @return
//     */
//    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null) {
//            return null;
//        }
//
//    }
//
//    /**
//     * 长链表先走
//     * @param headA
//     * @param headB
//     * @return
//     */
//    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null) {
//            return null;
//        }
//
//    }
}
