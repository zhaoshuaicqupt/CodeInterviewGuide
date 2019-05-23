package chapter_2_listproblem;

/**
 * 问题六：约瑟夫问题
 * 输入：一个环形单向链表的头节点head和报数的值m
 * 返回最后生存下来的节点，且这个节点自己组成环形单向链表，其他节点都删除掉。
 * 问题要在O（n）时间内完成。
 *
 */
public class Problem_06_JosephusProblem {
    public class Node{
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    //注意： 此种解法的时间复杂度为O（m*n）
    public Node josephusKill1(Node head,int m){
        if(head==null||head.next==head){
            return head;
        }
        //找出第一个和最后一个节点
        Node last=head;
        while(head.next!=last){
            last=last.next;
        }
        //
        int count=0;
        while(head!=last){
            if(++count==m){
                last.next=head.next;
                count=0;
            }else {
                last=last.next;
            }
            head=last.next;
        }
        return head;
    }


    /**
     * 进阶解法
     * 1. 遍历链表： 求链表的节点个数计为n, 时间复杂度为O（n）
     * 2. 根据n & m 的值，还有上下文分析Num(i-1)和Num(i)的关系，递归求出生存节点的编号；
     *    这一步的具体过程如getLive方法，getLive为单决策的递归函数，递归为N层，所以时间复杂度
     *    为O（n）
     * 3. 最后根据生存节点的编号，遍历链表找到该节点，时间复杂度为O（n）
     * 总的时间复杂度为O（n）.
     * @param head
     * @param m
     * @return
     */
    public Node josephuskill(Node head,int m){
        if(head ==null|| head.next==head|| m<1){
            return head;
        }
        Node cur=head.next;
        int temp=1;
        while(cur!=head){
            temp++;
            cur=cur.next;
        }
        temp=getLive(temp,m);
        while (--temp!=0){
            head=head.next;
        }
        head.next=head;
        return head;

    }
    public int getLive(int i,int m){
        if(i==1){
            return 1;
        }
        return (getLive(i-1,m)+m-1)%i+1;
    }
}
