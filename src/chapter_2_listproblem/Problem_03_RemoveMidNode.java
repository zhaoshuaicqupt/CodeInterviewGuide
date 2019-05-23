package chapter_2_listproblem;

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
    public class Node{
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    //链表的长度每增加2 ，要删除的节点就后移一个节点。
    public Node removeMidNode(Node head){
        if(head==null|| head.next==null){
            return head;
        }
        if(head.next.next==null){
            return head.next;
        }
        Node pre=head;
        Node cur=head.next.next;
        while(cur.next!=null && cur.next.next!=null){
            pre=pre.next;
            cur=cur.next.next;
        }
        pre.next=pre.next.next;
        return head;
    }
}
