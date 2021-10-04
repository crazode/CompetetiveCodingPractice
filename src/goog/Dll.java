package goog;

public class Dll<T> {
    private Node<T> head;
    private Node<T> tail;

    public static void main(String[] arg){
        Dll<Integer> dll = new Dll<>();
        dll.add(new Node<>(1));
        dll.add(new Node<>(2));
        dll.add(new Node<>(3));
        System.out.println(dll.find(2).data);
        dll.delete(2);
        String str = dll.find(2) == null ? "null" :  String.valueOf(dll.find(2).data);
        System.out.println(str);
        System.out.println(dll.find(3).data);
        System.out.println();
    }


    @Override
    public String toString() {
        return "Dll{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }

    public void add(Node<T> newNode){
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = tail.next;
        }
    }
    public  Node<T> find(T data){
        Node<T> itr = head;
        while(itr != null && itr.data != data){
            itr = itr.next;
        }
        return itr;

    }

    public  void delete(T data){
        Node<T> nodeToBeDeleted = find(data);
        if(nodeToBeDeleted != null){
            Node<T> prevNode = nodeToBeDeleted.prev;
            Node<T> nextNode = nodeToBeDeleted.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

    }

    static class Node<T>{
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data){
            this.data = data;
        }

        @Override
        public String  toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    ", prev=" + prev +
                    '}';
        }
    }
}
