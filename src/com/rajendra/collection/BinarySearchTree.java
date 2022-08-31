package com.rajendra.collection;

import com.rajendra.model.TreeNode;

import java.util.ArrayList;

/**
 * Created by Rajendra Verma on 30/08/22.
 */
public class BinarySearchTree extends BinaryTree {
    @Override
    public void buildTree(int[] data) {
        for (int i = 0; i < data.length; i++) {
            this.root = insert(this.root, data[i]);
        }

    }

    public void insert(int data) {
        this.root = insert(this.root, data);
    }

    public boolean search(int val) {

        return searchRec(this.root, val);
    }

    private boolean searchRec(TreeNode root, int key) {
        if (root == null)
            return false;
        if (root.val > key) {
            return searchRec(root.left, key);
        } else if (root.val == key) {
            return true;
        } else {
            return searchRec(root.right, key);
        }

    }

    public void delete(int key) {
        this.root = deleteRec(this.root, key);
    }

    private TreeNode deleteRec(TreeNode root, int key) {
        if (root.val > key) {
            root.left = deleteRec(root.left, key);
        } else if (root.val < key) {
            root.right = deleteRec(root.right, key);
        } else {
// case 1 leaf Node
            if (root.left == null && root.right == null) {
                return null;
            }

// case 2 root.left =null
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
//             case 3 inorder successor
            TreeNode is = inorderSuccessor(root.right);
            root.val = is.val;
            root.right = deleteRec(root.right, is.val);


        }
        return root;
    }

    private TreeNode inorderSuccessor(TreeNode root) {
        while (root.left != null)
            root = root.left;

        return root;
    }


    private TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }
        if (root.val > data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public void printInRange(int x, int y) {

        printInRangeRec(this.root, x, y);
    }

    private void printInRangeRec(TreeNode root, int x, int y) {
        if (root == null) return;
        if (root.val >= x && root.val <= y) {
            printInRangeRec(root.left, x, y);
            System.out.print(root.val + ",");
            printInRangeRec(root.right, x, y);
        } else if (root.val >= y) {
            printInRangeRec(root.left, x, y);
        } else {
            printInRangeRec(root.right, x, y);
        }


    }

    private void printRootToLeaf() {
        ArrayList<Integer> path = new ArrayList<>();
        printRootToLeafRec(root, path);

    }

    private void printRootToLeafRec(TreeNode root, ArrayList<Integer> path) {
        if (root == null)
            return;
        path.add(root.val);
//        leaf
        if (root.left ==null&& root.right==null){
            printPath(path);
        }else { // non leaf
            printRootToLeafRec(root.left, path);
            printRootToLeafRec(root.right, path);
        }
        path.remove(path.size() - 1);

    }

    private void printPath(ArrayList<Integer> path) {
        for (int val:path) {
            System.out.print(val+"->");
        }
        System.out.print("END");
        System.out.println();
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int data[] = {5, 1, 3, 4, 2, 7};
        bst.buildTree(data);
        System.out.println("In order display");
        bst.levelOrderDisplay();
        System.out.println();
 System.out.println("Print in the range 1 to 5");
        bst.printInRange(1, 3);
       // bst.printRootToLeaf();

    }


}
