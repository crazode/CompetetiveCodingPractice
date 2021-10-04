package gfgmustdo;

//public class Add1toll {
//
//}

// { Driver Code Starts

import java.io.*;
        import java.util.*;
//class Node
//{
//    int data;
//    Node next;
//
//    Node(int x)
//    {
//        data = x;
//        next = null;
//    }
//}
//class Add1toll
//{
//    public static void printList(Node node)
//    {
//        while (node != null)
//        {
//            System.out.print(node.data);
//            node = node.next;
//        }
//        System.out.println();
//    }
//    public static void main(String args[])throws IOException
//    {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        while(t-->0)
//        {
//            String s = sc.next();
//            Node head = new Node( s.charAt(0) - '0' );
//            Node tail = head;
//            for(int i=1; i<s.length(); i++)
//            {
//                tail.next = new Node( s.charAt(i) - '0' );
//                tail = tail.next;
//            }
//            Solution obj = new Solution();
//            head = obj.addOne(head);
//            printList(head);
//        }
//    }
//}// } Driver Code Ends
//
//
///*
//class Node{
//    int data;
//    Node next;
//
//    Node(int x){
//        data = x;
//        next = null;
//    }
//}
//*/

class Add1toll
{
   static class Node{
        int data;
        Node next;

        Node(int x){
            data = x;
            next = null;
        }
    }

    public static void main(String[] arg){
       Node root = new Node(1);
       root.next = new Node(2);
       root.next.next = new Node(3);
       root.next.next.next = new Node(4);

       Node revHead = getReverseHead(root);
       addOne(revHead);
       revHead = getReverseHead(revHead);
       print(revHead);
    }

    public static void print(Node node){
       Node temp = node;
       while(temp != null){
           System.out.print(temp.data + " ");
           temp = temp.next;
       }
       System.out.println();
    }




    static Node getReverseHead(Node head){
       Node lastNode = head;
       while(lastNode.next != null){
           lastNode = lastNode.next;
       }


        Node current = head;

        while (current != lastNode) {
            current = head.next;
            head.next = lastNode.next;
            lastNode.next = head;
            head = current;

        }
        return lastNode;
    }

    static void addOne(Node head)
    {
        int carry = 1;
        int val = 0;
        Node temp = head;
        while(temp.next != null){
            val = (temp.data + carry)%10;
            carry = (temp.data + carry)/10;
            temp.data = val;

            temp = temp.next;
        }
        val = (temp.data + carry)%10;
        carry = (temp.data + carry)/10;
        temp.data = val;
        if(carry != 0){
            temp.next = new Node(carry);
        }

    }


}

