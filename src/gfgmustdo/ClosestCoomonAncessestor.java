package gfgmustdo;

public class ClosestCoomonAncessestor {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static void main(String[] arg){
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(8);
        root.right = new Node(4);
        root.right.left = new Node(5);

        Node node1 = root.left.left;
        Node node2 = root.left.right.right;

        Node cca = getLowestCommonAncesstor(root, node1,node2);
        System.out.println(cca.data);
        int dist1 = getDistance(cca, node1);
        int dist2 = getDistance(cca, node2);
        System.out.println(dist1 + dist2);

    }

    public static int getDistance(Node root, Node target){
        if(root == null)
            return -1;
        if(root == target){
            return 0;
        }
        int dist  = -1;
        dist = getDistance(root.left, target);
        if(dist >= 0)return dist + 1;
        else{
            dist = getDistance(root.right, target);
        }
        if(dist >= 0)return dist + 1;
        return -1;
    }

    public static Node getLowestCommonAncesstor(Node root, Node node1, Node node2){
        if(root == null)return root;
        if(root == node1 || root == node2){
            return root;
        }

        Node lNode = getLowestCommonAncesstor(root.left, node1, node2);
        Node rNode = getLowestCommonAncesstor(root.right, node1, node2);

        if(lNode != null && rNode != null){
            return root;
        }else if(lNode == null && rNode == null){
            return  null;
        }
        return lNode != null ? lNode : rNode;
    }

}
