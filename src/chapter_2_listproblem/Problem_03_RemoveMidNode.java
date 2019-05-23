package chapter_2_listproblem;

import org.junit.Test;

/**
 * 删除中间节点
 * 给定链表的头节点head  实现删除链表的中间节点的函数
 * 分析；
 * 如果链表为空或者长度为1 ，不需要调整直接返回.
 * 如果链表的长度为2 ，则将头节点删除即可。
 * 如果链表长度为3，应该删除第二个节点。
 * 如果链表长度为4，应该删除第二个节点。
 * 如果链表长度为5 ，应该删除第三个节点。
 */
public class Problem_03_RemoveMidNode {
    public class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    //链表的长度每增加2 ，要删除的节点就后移一个节点。
    public Node removeMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        Node pre = head;
        Node cur = head.next.next;
        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    public Node removeByRatio(Node head, int a, int b) {
        if (a < 1 || a > b) {
            return head;
        }
        int n = 0;
        Node cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        n = (int) Math.ceil(((double) (a * n)) / (double) b);
        if (n == 1) {
            head = head.next;

        }
        if (n > 1) {
            cur = head;
            while (--n != 1) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    @Test
    public void test(){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head = removeByRatio(head, 1, 3);
        printLinkedList(head);

    }
}
