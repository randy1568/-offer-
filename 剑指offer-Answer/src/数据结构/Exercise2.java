package 数据结构;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;
        while (in.hasNext()) {
            int length = in.nextInt();
            int[] num = new int[length];
            for (int i = 0; i < length; i++) {
                num[i] = in.nextInt();
            }
            Arrays.sort(num);
            ArrayList<Integer> listA = new ArrayList<>();
            ArrayList<Integer> listB = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                if (num[i] % 2 == 0) {
                    listB.add(num[i]);
                } else {
                    listA.add(num[i]);
                }
            }
            int[] answerA =  findMax(listA,1);
            int[] answerB =  findMax(listB,0);
            if(answerA[1] > answerB[1]){
                System.out.println(answerA[0]);
                System.out.println(answerA[1]);
            }else if(answerA[1] == answerB[1]){
                if(answerA[0] < answerB[0]){
                    System.out.println(answerA[0]);
                    System.out.println(answerA[1]);
                }else {
                    System.out.println(answerB[0]);
                    System.out.println(answerB[1]);
                }
            }else {
                System.out.println(answerB[0]);
                System.out.println(answerB[1]);
            }
        }
    }

    private static int[] findMax(ArrayList<Integer> list,int direction) {
        int[] answer = new int[2];
        if(list == null){
            if(direction == 1){
                answer[0] = 1;
                answer[1] = 50;
            }else {
                answer[0] = 2;
                answer[0] = 50;
            }
        }
        for (int i = 0 ;i< list.size();i++){
            int temp;
            if(i+1 < list.size()){
               temp = list.get(i+1) - list.get(i);
            }else {
                if(list.get(i)%2 != 0){
                    temp = 99 - list.get(i);
                }else {
                    temp = 100 - list.get(i);
                }
            }
            if(answer[1] < temp){
                answer[0] = list.get(i)+2;
                answer[1] = temp /2 ;
            }
        }
        return answer;
    }

}
