package 数据结构.面试题59II队列的最大值;

import java.util.LinkedList;

public class Solution {

    LinkedList<Integer> listA;
    LinkedList<Integer> listB;


    public Solution() {
        listA = new LinkedList<>();
        listB = new LinkedList<>();
    }

    public int max_value() {
        if(listA!=null){
            return listA.getFirst();
        }else {
            return -1;
        }
    }

    public void push_back(int value) {
        while (!listA.isEmpty() && listA.getLast()<value){
            listA.removeLast();
        }
        listA.addLast(value);
        listB.addLast(value);
    }

    public int pop_front() {
        if(listB.isEmpty()){
            return -1;
        }
        Integer first = listB.getFirst();
        if(first.equals(max_value())){
            listA.remove(first);
        }
        listB.removeFirst();
        return first;
    }
}
