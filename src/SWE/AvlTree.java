package SWE;

public class AvlTree {
//    Node avlRoot;
//    AvlTree(){
//        this.avlRoot = null;
//    }

    public static void main(String[] arg){
        Node root = null;
//        root = insert(10, root);
//        root = insert(7, root);
//        root = insert(8, root);
//        root = insert(5, root);
//        root = insert(3, root);
//        root = insert(12, root);



//        root = insertInAvl(10, root);
//        root = insertInAvl(20, root);
//        root = insertInAvl(30, root);
//        root = insertInAvl(40,root);
//        root = insertInAvl(50, root);
//        root = insertInAvl(25, root);

        root = insertInAvl(9, root);
        root = insertInAvl(5, root);
        root = insertInAvl(10, root);
        root = insertInAvl(0,root);
        root = insertInAvl(6, root);
        root = insertInAvl(11, root);
        root = insertInAvl(-1,root);
        root = insertInAvl(1, root);
        root = insertInAvl(2, root);

        preorder(root);

        root = delete(10, root);
        System.out.println("After deleting");
        preorder(root);

    }

    public static Node delete(int value, Node root){
        if(root == null){
            return root;
        }
        if(root.data == value){
            if(root.left == null && root.right == null){
                root = null;
            }
            if(root.left == null){
                root = root.right;
                root.left = null;
            }else if(root.right == null){
                root = root.left;
                root.right = null;

            }else{
                root.data = getMinOfSubTree(root.right);
            }
        }else if(value < root.data){
            delete(value, root.left);
        }else{
            delete(value, root.right);
        }
        root = balanceTree(root);
        return root;
    }

    public static int getMinOfSubTree(Node node){
        if(node == null)
            return -1;
        if(node.left == null){
            int temp = node.left.data;
            return temp;
        }
        return getHeight(node.left);

    }

    public static Node insertInAvl(int data, Node root){
        root = insert(data, root);
        return balanceTree(root);

    }

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;

        }
    }
    public static void preorder(Node node){
        if(node == null)
            return;
        System.out.println(node.data);
        preorder(node.left);
        preorder(node.right);
    }
    public static Node insert(int data, Node root){
        if(root == null){
            root = new Node(data);
            return root;
        }
        if(data < root.data ){
            if(root.left == null){
                root.left = new Node(data);
            }else{
                root.left = insert(data, root.left);
            }

        }else{
            if(root.right == null){
                root.right = new Node(data);
            }else{
                root.right = insert(data, root.right);
            }
        }

        return root;
    }

    public static Node balanceTree(Node root){
        if(root == null){
            return root;
        }
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if(heightDiff == 0 || heightDiff == -1 || heightDiff == 1){
            root.left = balanceTree(root.left);
            root.right = balanceTree(root.right);
        }else{
            if(heightDiff == 2){
                Node temp = root.left;
                root.left = temp.right;
                temp.right = root;
                root = temp;
            }else{
                Node temp = root.right;
                root.right = root.right.left;
                temp.left = root;
                root = temp;
            }
        }
        return root;
    }
    public static int getHeight(Node root){
        if(root == null){
            return 0;
        }
        if(root.right == null && root.left == null){
            return 1;
        }
        return 1 + getMax(getHeight(root.left), getHeight(root.right));
    }
    public static int getMax(int a, int b){
        if(a > b)
            return a;
        return b;
    }
}
