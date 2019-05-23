package chapter_2_listproblem;

/**
 * 题目2
 * 在单链表和双链表中删除倒数第K个节点，分别实现两个函数，
 * 一个可以删除单链表中的倒数第K个节点，
 * 另外一个可以删除双链表中的倒数第K个节点
 * 要求：
 * 如果链表长度为N时间复杂度达到O(n),额外的空间复杂度达到O（1）。
 **/
public class Problem_02_DeleteLastKthNode {

    public class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val=val;
        }
    }
    //删除单向链表中的倒数第k个节点
    public Node removeLastKthNode(Node node,int k){

        if(node==null|| k<1){
            return null;
        }
        int count=0;
        Node nodeCopy=node;
        while(nodeCopy.next!=null){
            nodeCopy=nodeCopy.next;
            count++;
            if(count<k){
                return null;
            }
            if(count >=k){
                node=node.next;
            }
        }
        Node temp=node.next;
        node.next=node.next.next;
        return temp;

    }
    public class DoubleNode{
        public int val;
        public DoubleNode pre;
        public DoubleNode next;

        public DoubleNode(int val) {
            this.val = val;
        }
    }
    public DoubleNode removeLastKthNode(DoubleNode node,int k){
        return null;
    }
}
