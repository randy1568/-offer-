package 数据结构.面试题23链表环的入口点;

import 数据结构.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode temp = pHead;
        while (temp!=null){
            if(!list.contains(temp)){
                list.add(temp);
            }else {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
