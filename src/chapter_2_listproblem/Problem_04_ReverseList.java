package chapter_2_listproblem;

/**
 * 题目四：
 * 分别实反转单向链表和反转双向链表的函数
 * 要求：
 * 如果链表长度为N，时间复杂度要求为O（n）,额外的时间复杂度为O（1）.
 */
public class Problem_04_ReverseList {
    public class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    public class DoubleNode{
        public int val;
        public DoubleNode pre;
        public DoubleNode next;

        public DoubleNode(int val) {
            this.val = val;
            }
    }
    public Node reverseList(Node head){
        Node pre=null;
        Node next=null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
    //反向双向链表
    public DoubleNode reverseList(DoubleNode head){
        DoubleNode pre=null;
        DoubleNode next=null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            head.pre=next;
            pre=head;
            head=next;
        }
        return pre;

    }


}
