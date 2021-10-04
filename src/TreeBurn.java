public class TreeBurn {
    public static void main(String[] arg){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.left.left.left = new Node(8);
        root.left.right.left = new Node(9);
        root.left.right.right = new Node(10);
        root.left.right.left.left = new Node(11);
        int target = 11;
        System.out.println(getTimeToBurnTrees(root, target, 0, 0, false, 0));

    }

    private static int getTimeToBurnTrees(Node root, int target, int curTime, int targetLeafBurnTime, boolean targetVisited, int maxBurnTime) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            if(root. data != target){
                maxBurnTime = Math.max(maxBurnTime, curTime);

            }else{
                targetLeafBurnTime = curTime;
            }
            return targetLeafBurnTime + maxBurnTime;
        }
        return Math.max(getTimeToBurnTrees(root.left, target, curTime + 1, targetLeafBurnTime, targetVisited, maxBurnTime),
                getTimeToBurnTrees(root.right, target, curTime + 1, targetLeafBurnTime, targetVisited, maxBurnTime));


    }

    static class Node {
        int data;
        Node left, right;

        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
