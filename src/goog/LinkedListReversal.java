package goog;

public class LinkedListReversal {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        LinkedListReversal sol = new LinkedListReversal();

        //Node newHead = sol.getReverseList(head);
        Node newHead = sol.reverseRecur(head);

        while(newHead != null){
            System.out.println(newHead.val + " ");
            newHead = newHead.next;
        }

    }
    public Node reverse(Node head){
        if(head == null)return head;
        if(head.next == null)return head;

        Node lastNode = null;
        while(head != null){
            Node newHead = head.next;
            head.next = lastNode;
            lastNode = head;
            head = newHead;
        }
        return lastNode;
    }
    public Node reverseRecur(Node head){
        if(null == head || null == head.next)return head;
        Node next = reverseRecur(head.next);
        head.next.next = head;
        return next;
    }
    static class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
        }
    }
}
