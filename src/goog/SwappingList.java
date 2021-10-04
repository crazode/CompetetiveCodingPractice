package goog;

public class SwappingList {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        SwappingList sol = new SwappingList();
        Node newHead = sol.swappingPairs(head);

        Node temp = newHead;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public Node swappingPairs(Node head){
        if(head == null)return head;

        if(head.next == null)return head;

        Node newHead = null;

        while(head != null){
            Node node1 = head;
            Node node2 = head.next;

            if(node2 == null)break;

            node1.next = node2.next;
            node2.next = node1;

            head = node1.next;
            if(newHead == null){
                newHead = node2;
            }

        }
        return newHead;
    }

    static class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
        }
    }

}
