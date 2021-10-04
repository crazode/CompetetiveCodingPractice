package goog;

import sun.reflect.generics.tree.Tree;

public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        CountCompleteTreeNodes sol = new CountCompleteTreeNodes();
        System.out.println(sol.countNodes(root));
        System.out.println(sol.countNodes(null));


    }
    public int countNodes(TreeNode root) {
        if(root == null)return 0;
            int leftHt = getLeftHt(root);
            int rightHt = getRightHt(root);
            if(leftHt == rightHt)return (int)Math.pow(2, leftHt) - 1;
            return 1 + countNodes(root.left) + countNodes(root.right);

    }

    private int getLeftHt(TreeNode root) {
        if(root == null)return 0;
        return 1 + getLeftHt(root.left);
    }
    private int getRightHt(TreeNode root) {
        if(root == null)return 0;
        return 1 + getRightHt(root.right);

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    }


