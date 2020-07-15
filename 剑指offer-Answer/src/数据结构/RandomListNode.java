package 数据结构;

public class RandomListNode {
    public int label;
    public RandomListNode next;
    public RandomListNode random;

    public RandomListNode(int value) {
        this.label = value;
    }

    @Override
    public String toString() {

        if(random!=null){
            return "RandomListNode{" +
                    "label=" + label +
                    ",random=" + random.label +
                    ", next=" + next +
                    '}';
        }else {
            return "RandomListNode{" +
                    "label=" + label +
                    ",random=" + null +
                    ", next=" + next +
                    '}';
        }

    }
}
