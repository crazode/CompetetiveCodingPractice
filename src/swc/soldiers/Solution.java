package swc.soldiers;

public class Solution {
    int maxSize = 100001;
    MyDll[][] myDll = new MyDll[5][5];
    Soldier[] soldiers = new Soldier[maxSize];
    static class Soldier{
        int sId;
        int tId;
        Node soldierNode;

        Soldier(int sId, int tId){
            this.tId = tId;
            this.sId = sId;
            this.soldierNode = null;
        }
    }

    public void init(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                myDll[i][j] = new MyDll();
            }
        }
    }

    public void addSoldier(int sId, int tId, int score){
        soldiers[sId] = new Soldier(sId, tId);
        Node node = new Node(sId);
        Node prevNode = myDll[tId - 1][score - 1].tail.prev;
        node.next = myDll[tId - 1][score - 1].tail;
        prevNode.next = node;
        node.prev = prevNode;
        soldiers[sId].soldierNode = node;
    }

    public void fireSoldier(int sId){
        Node node = soldiers[sId].soldierNode;
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    public void changeSoldierRating(int sId, int val){

    }
    static class MyDll{
        Node head;
        Node tail;
        MyDll(){
            this.head = new Node(-1);
            this.tail = new Node(-2);
            head.next = tail;
            tail.prev = head;
        }
    }

    static class Node{
        int val;
        Node next;
        Node prev;
        Node(int val){
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

}
