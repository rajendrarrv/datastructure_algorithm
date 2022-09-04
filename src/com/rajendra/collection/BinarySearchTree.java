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
        if (key< root.left.val) {
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
//        based on sorting
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

//    left most element in right successor
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
//         the smaller value always goes to the left side of tree and vice vera
        if (data<root.val) {
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
        if (root.left == null && root.right == null) {
            printPath(path);
        } else {
            printRootToLeafRec(root.left, path);
            printRootToLeafRec(root.right, path);
        }
        path.remove(path.size() - 1);

    }

    private void printPath(ArrayList<Integer> path) {
        for (int val : path) {
            System.out.print(val + "->");
        }
        System.out.print("END");
        System.out.println();
    }

    private TreeNode sortedArrayToBstRec(int[] nums) {
        return sortedArrayToBstRec(nums, 0, nums.length - 1);
    }


    public TreeNode sortedArrayToBstRec(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = sortedArrayToBstRec(nums, start, mid - 1);
        treeNode.right = sortedArrayToBstRec(nums, mid + 1, end);
        return treeNode;
    }




    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int data[] = {6, 2, 0, 4, 3, 5, 8, 7, 9};
        bst.buildTree(data);
        System.out.println("In order display");
        bst.levelOrderDisplay();
        bst.listCommonAnsisters(7, 9);

    }

    private TreeNode listCommonAnsisters(int p, int q) {
         return listCommonAnsistersRec(root, p, q);


    }

    private TreeNode listCommonAnsistersRec(TreeNode root, int n1, int n2) {

        if (root == null)
            return null;

        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (root.val > n1 && root.val > n2)
            return listCommonAnsistersRec(root.left, n1, n2);

        // If both n1 and n2 are greater than root, then LCA lies in right
        if (root.val < n1 && root.val < n2)
            return listCommonAnsistersRec(root.right, n1, n2);

        return root;

    }
}



