package chapter_2_listproblem;

import org.junit.Test;

/**
 * 题目一 ： 打印两个有序链表的公共部分
 */
public class Problem_01_PrintCommonPart {

    public static class Node{
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    public void printCommonPart(Node head1,Node head2){
        System.out.println("Commmon part:");
        while(head1!=null&&head2!=null){
            if(head1.val<head2.val){
                head1=head1.next;
            }else if(head1.val>head2.val){
                head2=head2.next;
            }else {
                System.out.print(head1.val+" ");
                head1=head1.next;
                head2=head2.next;
            }
        }
        System.out.println(" ");
    }
    @Test
    public void test(){
        Node node1=new Node(1);
        Node node2=new Node(3);
        Node node3=new Node(4);
        Node node4=new Node(6);
        Node node5=new Node(2);
        Node node6=new Node(3);
        Node node7=new Node(4);
        Node node8=new Node(7);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=null;
        node5.next=node6;
        node6.next=node7;
        node7.next=node8;
        node8.next=null;
        printCommonPart(node1,node5);
    }
}

