package 数据结构.面试题35复杂链表的复制;

import 数据结构.RandomListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * 使用hash表优化时间复杂度
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode randomHead = new RandomListNode(-1);
        RandomListNode tempP = pHead;
        RandomListNode tempRandom = randomHead;
        while (tempP != null) {
            tempRandom.next = new RandomListNode(tempP.label);
            tempRandom = tempRandom.next;
            map.put(tempP, tempRandom);
            tempP = tempP.next;
        }
        tempP = pHead;
        tempRandom = randomHead.next;
        while (tempRandom != null) {
            if (tempP.random != null) {
                tempRandom.random = map.get(tempP.random);
            }
            tempRandom = tempRandom.next;
            tempP = tempP.next;
        }
        return randomHead.next;
    }

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        RandomListNode temp = head;
        for (int i = 2; i <= 5; i++) {
            temp.next = new RandomListNode(i);
            temp.next.random = temp;
            temp = temp.next;
        }
        Solution so = new Solution();
        RandomListNode clone = so.Clone(head);

    }
}
