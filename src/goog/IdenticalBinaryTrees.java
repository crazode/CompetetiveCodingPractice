package goog;

public class IdenticalBinaryTrees {


    public static void main(String[] arg){
        Node root1 = new Node(1);
        Node root2 = new Node(1);
        IdenticalBinaryTrees sol = new IdenticalBinaryTrees();
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root2.left = new Node(3);
        root2.right = new Node(2);
        root2.right.left = new Node(4);
        root2.right.right = new Node(5);

        //root2.left.left = new Node(3);

        if(sol.areIndenticalTrees(root1, root2)){
            System.out.println("trees are identical");
        }else System.out.println("not identical");

    }

    public boolean areIndenticalTrees(Node root1, Node root2){
        if(root1 == null && root2 == null)return true;
        if(root1 == null || root2 == null)return false;
        if(root1.val != root2.val)return false;
        else{
            if(areIndenticalTrees(root1.left, root2.left) && areIndenticalTrees(root1.right, root2.right)){
                return true;
            }else{
                flip(root2);
                return areIndenticalTrees(root1.left, root2.left) && areIndenticalTrees(root1.right, root2.right);
            }
        }
    }

    public void flip(Node root){
        if(root == null)return;
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        flip(root.left);
        flip(root.right);

    }

    static class Node{
        int val;
        Node left;
        Node right;

        Node(int data){
            this.val = data;
        }
    }
}
