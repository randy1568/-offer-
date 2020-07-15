package 数据结构.面试题35复杂链表的复制;

import 数据结构.RandomListNode;

public class Solution2 {


    private RandomListNode insertNode(RandomListNode head) {
        if (head == null) {
            return head;
        }
        RandomListNode temp = head;
        while (head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.next = head.next;
            head.next = newNode;
            head = newNode.next;
        }
        return temp;
    }

    private RandomListNode arrangeRandomNode(RandomListNode head) {
        if (head == null) {
            return head;
        }
        RandomListNode temp = head;
        while (head != null) {
            RandomListNode randomNode = head.next;
            if (head.random != null) {
                randomNode.random = head.random.next;
            }
            head = head.next.next;
        }
        return temp;
    }

    /**
     * 这里不要拆解掉原链表，否则牛客网直接判空
     * @param head
     * @return
     */
    private RandomListNode splitRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        RandomListNode pCloneNode = head.next;
        RandomListNode pCloneNode2 = head.next;

        head.next = pCloneNode2.next;
        head = head.next;
        pCloneNode2.next = null;

        while (head != null) {
           pCloneNode2.next = head.next;
           pCloneNode2 = pCloneNode2.next;
           head.next =  pCloneNode2.next;
           head = head.next;
        }
        return pCloneNode;
    }

    /**
     * 优化空间复杂度为O(1),时间复杂度为O(n)
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead) {
        RandomListNode randomListNode = insertNode(pHead);
        RandomListNode randomListNode1 = arrangeRandomNode(randomListNode);
        return splitRandomList(randomListNode1);
    }


    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        RandomListNode temp = head;
        for (int i = 2; i <= 5; i++) {
            temp.next = new RandomListNode(i);
            temp.next.random = temp;
            temp = temp.next;
        }
        temp.next = new RandomListNode(3);
        Solution2 so = new Solution2();
        RandomListNode randomListNode = so.Clone(head);


        System.out.println(randomListNode);
    }
}
