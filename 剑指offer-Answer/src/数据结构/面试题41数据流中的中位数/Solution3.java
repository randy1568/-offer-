package 数据结构.面试题41数据流中的中位数;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution3 {

    PriorityQueue<Integer> queueMin = new PriorityQueue<>();
    PriorityQueue<Integer> queueMax = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    private int size;

    public void Insert(Integer num) {
        size++;
        if ((size & 0x1) == 0) {
           if(queueMin.isEmpty()){
               if(!queueMax.isEmpty() && queueMax.peek()>num){
                   queueMax.add(num);
                   queueMin.add(queueMax.poll());
               }else {
                   queueMin.add(num);
               }
           }else {
               if(queueMin.peek() > num){
                   queueMax.add(num);
                   queueMin.add(queueMax.poll());
               }else {
                   queueMin.add(num);
               }
           }

        }else {
            if(queueMax.isEmpty() || queueMax.peek() >= num){
                queueMax.add(num);
            }else {
                queueMin.add(num);
                queueMax.add(queueMin.poll());
            }
        }
    }

    public Double GetMedian() {
        if((size & 0x1) ==0){
            return (queueMax.peek()+queueMin.peek())/2.0;
        }else {
            return Double.valueOf(queueMax.peek());
        }
    }

    public static void main(String[] args) {
        Solution3 so = new Solution3();
        so.Insert(5);
        System.out.println(so.GetMedian());
        so.Insert(2);
        System.out.println(so.GetMedian());
        so.Insert(3);
        System.out.println(so.GetMedian());
    }
}
